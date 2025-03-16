package org.example.peluqueria.peluquero;

import org.springframework.stereotype.Service;

@Service
public class PeluqueroMapper {

    public Peluquero toPeluquero(PeluqueroRequest request) {
        return Peluquero.builder()
                .id(request.id())
                .nombre(request.nombre())
                .apellido(request.apellido())
                .email(request.email())
                .telefono(request.telefono())
                .edad(request.edad())
                .turnos(request.turnos())
                .build();
    }

    public PeluqueroResponse toPeluqueroResponse(Peluquero peluquero) {
        return new PeluqueroResponse(
                peluquero.getNombre(),
                peluquero.getApellido(),
                peluquero.getEmail(),
                peluquero.getTelefono(),
                peluquero.getTurnos()
        );
    }

}


