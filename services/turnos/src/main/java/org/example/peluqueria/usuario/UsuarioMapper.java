package org.example.peluqueria.usuario;

import org.springframework.stereotype.Service;

@Service
public class UsuarioMapper {

    public Usuario toUsuario(UsuarioRequest request) {
        return Usuario.builder()
                .id(request.id())
                .nombre(request.nombre())
                .apellido(request.apellido())
                .email(request.email())
                .telefono(request.telefono())
                .edad(request.edad())
                .build();
    }

    public UsuarioResponse toUsuarioResponse(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getEmail(),
                usuario.getTelefono(),
                usuario.getEdad()
        );
    }
}
