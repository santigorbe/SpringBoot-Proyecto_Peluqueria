package org.example.peluqueria.notification;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonDeserialize
public record TurnoConfirmation(
        String nombreUsuario,
        String nombrePeluquero,
        String apellidoPeluquero,
        String emailUsuario,
        String diaHorario
) {
}
