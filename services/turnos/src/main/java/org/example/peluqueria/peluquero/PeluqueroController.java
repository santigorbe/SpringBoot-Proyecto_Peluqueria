package org.example.peluqueria.peluquero;

import brave.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/turnos")
@RequiredArgsConstructor
public class PeluqueroController {

    private final PeluqueroService service;

    @GetMapping
    public List<Peluquero> listAll() {
        return service.listAll();
    }
}
