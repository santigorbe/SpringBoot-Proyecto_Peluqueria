package org.example.peluqueria.turno;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TurnoService {

    private final TurnoRepository repository;
    private final TurnoMapper mapper;


    public List<TurnoResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toTurnoResponse)
                .collect(Collectors.toList());
    }

    public TurnoResponse findById(Long id) {
       return repository.findById(id)
            .map(mapper::toTurnoResponse)
            .orElseThrow(() -> new EntityNotFoundException("Peluquero con ID " + id + " no encontrado"));
    }

    public Long createTurno(TurnoRequest request) {
        return repository.save(mapper.toTurno(request)).getId();
    }
}
