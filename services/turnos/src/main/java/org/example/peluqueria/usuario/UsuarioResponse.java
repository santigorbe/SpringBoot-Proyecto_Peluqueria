package org.example.peluqueria.usuario;

public record UsuarioResponse (
        String nombre,
        String apellido,
        String email,
        String telefono,
        Integer edad
) {
}
