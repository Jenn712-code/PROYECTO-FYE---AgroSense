package ucentral.edu.co.AgroSense.Entidades;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "controlPlagas")
public class ControlPlagas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idControlP", nullable = false)
    private Integer idControlP;

    @ManyToOne
    @JoinColumn(name = "idPlaga")
    private Plaga plaga;

    @ManyToOne
    @JoinColumn(name = "idMetodoControl")
    private MetodoControl metodoControl;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;
}
