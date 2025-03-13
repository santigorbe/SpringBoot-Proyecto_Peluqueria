package org.example.peluqueria.turno;

import jakarta.persistence.*;
import lombok.*;
import org.example.peluqueria.peluquero.Peluquero;
import org.example.peluqueria.usuario.Usuario;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String diaHorario;

    @OneToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="peluquero_id")
    private Peluquero peluquero;

}
