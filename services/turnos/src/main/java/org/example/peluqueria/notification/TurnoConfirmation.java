package org.example.peluqueria.notification;

public record TurnoConfirmation(
        String nombreUsuario,
        String nombrePeluquero,
        String apellidoPeluquero,
        String emailUsuario,
        String diaHorario
) {
}
