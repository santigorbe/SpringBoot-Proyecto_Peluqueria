package org.example.peluqueria.peluquero;

import org.example.peluqueria.turno.Turno;

import java.util.List;

public record PeluqueroResponse(
        String nombre,
        String apellido,
        String email,
        String telefono,
        List<Turno> turnos
) {
}
