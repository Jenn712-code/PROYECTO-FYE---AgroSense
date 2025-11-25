package ucentral.edu.co.AgroSense.Entidades;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "enfermedades")
public class Enfermedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEnfermedad", nullable = false)
    private Integer idEnfermedad;

    @Column(name = "nombreEnfermedad", nullable = false)
    private String nombreEnfermedad;
}
