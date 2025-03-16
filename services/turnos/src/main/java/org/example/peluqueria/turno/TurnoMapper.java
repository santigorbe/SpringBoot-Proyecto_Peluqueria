package org.example.peluqueria.turno;

import org.example.peluqueria.peluquero.Peluquero;
import org.example.peluqueria.usuario.Usuario;
import org.springframework.stereotype.Service;

@Service
public class TurnoMapper {

    public Turno toTurno(TurnoRequest request) {
        return Turno.builder()
                .id(request.id())
                .diaHorario(request.diaHorario())
                .usuario(
                        Usuario.builder()
                            .id(request.usuarioId())
                            .build())
                .peluquero(
                        Peluquero.builder()
                                .id(request.peluqueroId())
                                .build()
                )
               .build();
    }

    public TurnoResponse toTurnoResponse(Turno turno) {
        return new TurnoResponse(
                turno.getDiaHorario(),
                turno.getUsuario(),
                turno.getPeluquero()
        );
    }
}
