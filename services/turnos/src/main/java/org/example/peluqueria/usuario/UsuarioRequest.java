package org.example.peluqueria.usuario;

public record UsuarioRequest(
        Long id,
        String nombre,
        String apellido,
        String email,
        String telefono,
        Integer edad
) {
}
