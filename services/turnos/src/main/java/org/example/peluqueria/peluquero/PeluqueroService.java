package org.example.peluqueria.peluquero;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PeluqueroService {

    private final PeluqueroRepository repository;
    private final PeluqueroMapper mapper;

    public List<PeluqueroResponse> listAll() {
        return this.repository.findAll()
                .stream()
                .map(mapper::toPeluqueroResponse)
                .collect(Collectors.toList());
    }

    public PeluqueroResponse findById(Long id) {
        return repository.findById(id)
                .map(mapper::toPeluqueroResponse)
                .orElseThrow(() -> new EntityNotFoundException("Peluquero con ID " + id + " no encontrado"));
    }

    public Long createPeluquero(PeluqueroRequest request){
        var peluquero = mapper.toPeluquero(request);
        return repository.save(peluquero).getId();
    }
}
