package org.example.peluqueria.usuario;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    public Long createUsuario(UsuarioRequest request) {
        var usuario = mapper.toUsuario(request);
        return repository.save(usuario).getId();
    }

    public UsuarioResponse findById(Long id) {
        return repository.findById(id)
                .map(mapper::toUsuarioResponse)
                .orElseThrow(() -> new EntityNotFoundException("Usuario con ID " + id + " no encontrado"));
    }

    public List<UsuarioResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toUsuarioResponse)
                .collect(Collectors.toList());
    }
}
