package org.example.peluqueria.usuario;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    public Long createUsuario(@RequestBody UsuarioRequest request) {
        return service.createUsuario(request);
    }
    @GetMapping
    public List<UsuarioResponse> findAll() {
        return service.findAll();
    }
    @GetMapping("/{id_usuario}")
    public UsuarioResponse findById(
            @PathVariable("id_usuario") Long id
    ) {
        return service.findById(id);
    }
}
