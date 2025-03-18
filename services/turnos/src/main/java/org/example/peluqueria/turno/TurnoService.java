package org.example.peluqueria.turno;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.peluqueria.exception.TurnoTomadoException;
import org.example.peluqueria.notification.NotificationProducer;
import org.example.peluqueria.notification.TurnoConfirmation;
import org.example.peluqueria.peluquero.PeluqueroService;
import org.example.peluqueria.usuario.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TurnoService {

    private final TurnoRepository repository;
    private final TurnoMapper mapper;

    private final PeluqueroService peluqueroService;
    private final UsuarioService usuarioService;
    private final NotificationProducer notificationProducer;

    public List<TurnoResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toTurnoResponse)
                .collect(Collectors.toList());
    }

    public TurnoResponse findById(Long id) {
       return repository.findById(id)
            .map(mapper::toTurnoResponse)
            .orElseThrow(() -> new EntityNotFoundException("Peluquero con ID " + id + " no encontrado"));
    }

    public Long createTurno(TurnoRequest request) {
        var peluquero = peluqueroService.findById(request.peluqueroId());
        var usuario = usuarioService.findById(request.usuarioId());
        var turnos = peluquero.turnos();

        if (turnos.stream().anyMatch(turno -> turno.getDiaHorario().equals(request.diaHorario()))) {
            throw new TurnoTomadoException("El turno que intentas obtener ya está tomado");
        }

        var id_turno = repository.save(mapper.toTurno(request)).getId();

        this.notificationProducer.sendNotification(
                new TurnoConfirmation(
                        usuario.nombre(),
                        peluquero.nombre(),
                        peluquero.apellido(),
                        usuario.email(),
                        request.diaHorario()
                )
        );
        return id_turno;
    }
}
