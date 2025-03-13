package org.example.peluqueria.peluquero;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PeluqueroService {

    private PeluqueroRepository repository;

    public List<Peluquero> listAll() {
        return repository.findAll();
    }

    public Optional<Peluquero> findById(Long id) {
        return repository.findById(id);
    }
}
