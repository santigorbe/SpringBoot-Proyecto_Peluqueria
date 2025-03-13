package org.example.peluqueria.turno;

import org.example.peluqueria.peluquero.Peluquero;
import org.example.peluqueria.usuario.Usuario;

public record TurnoResponse(
        Integer id,
        String diaHorario,
        Usuario usuario,
        Peluquero peluquero
) {
}
