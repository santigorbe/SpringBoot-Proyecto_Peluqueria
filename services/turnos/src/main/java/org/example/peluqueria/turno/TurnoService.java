package org.example.peluqueria.turno;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.peluqueria.exception.TurnoTomadoException;
import org.example.peluqueria.peluquero.PeluqueroService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TurnoService {

    private final TurnoRepository repository;
    private final TurnoMapper mapper;

    private final PeluqueroService peluqueroService;


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
        var turnos = peluquero.turnos();

        if (turnos.stream().anyMatch(turno -> turno.getDiaHorario().equals(request.diaHorario()))) {
            throw new TurnoTomadoException("El turno que intentas obtener ya está tomado");
        }

        return repository.save(mapper.toTurno(request)).getId();
    }
}
