package org.example.peluqueria.peluquero;

import brave.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/peluqueros")
@RequiredArgsConstructor
public class PeluqueroController {

    private final PeluqueroService service;

    @GetMapping
    public List<PeluqueroResponse> listAll() {
        return service.listAll();
    }
    @GetMapping("/{id_peluquero}")
    public PeluqueroResponse findById(@PathVariable("id_peluquero") Long id) {
        return service.findById(id);
    }
    @PostMapping
    public Long createPeluquero(@RequestBody PeluqueroRequest request) {
        return service.createPeluquero(request);
    }
}
