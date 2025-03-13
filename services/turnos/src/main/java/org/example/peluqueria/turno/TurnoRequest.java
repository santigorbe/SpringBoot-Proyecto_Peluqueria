package org.example.peluqueria.turno;

import org.example.peluqueria.peluquero.Peluquero;
import org.example.peluqueria.usuario.Usuario;

import java.math.BigDecimal;

public record TurnoRequest (
        Integer id,
        String diaHorario,
        Usuario usuario,
        Peluquero peluquero
){
}
