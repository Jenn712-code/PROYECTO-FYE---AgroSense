package ucentral.edu.co.AgroSense.Entidades;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "controlEnfermedades")
public class ControlEnfermedades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idControlE", nullable = false)
    private Integer idControlE;

    @ManyToOne
    @JoinColumn(name = "idEnfermedad")
    private Enfermedad enfermedad;

    @ManyToOne
    @JoinColumn(name = "idMetodoControl")
    private MetodoControl metodoControl;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;
}
