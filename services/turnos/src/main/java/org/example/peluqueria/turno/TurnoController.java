package org.example.peluqueria.turno;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/turnos")
@RequiredArgsConstructor
public class TurnoController {
    private final TurnoService service;

    @GetMapping
    public List<TurnoResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id_turno}")
    public TurnoResponse findById(@RequestParam("id_turno") Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Long createTurno(@RequestBody TurnoRequest request) {
        return service.createTurno(request);
    }
}
