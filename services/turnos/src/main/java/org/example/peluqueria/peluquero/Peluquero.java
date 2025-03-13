package org.example.peluqueria.peluquero;

import jakarta.persistence.*;
import lombok.*;
import org.example.peluqueria.turno.Turno;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Peluquero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private int edad;

    @OneToMany(mappedBy = "peluquero")
    private List<Turno> turnos;
}
