package org.example.peluqueria.peluquero;

import jakarta.persistence.OneToMany;
import org.example.peluqueria.turno.Turno;

import java.util.List;

public record PeluqueroRequest (
        Long id,
        String nombre,
        String apellido,
        String email,
        String telefono,
        int edad,
        List<Turno> turnos
){
}
