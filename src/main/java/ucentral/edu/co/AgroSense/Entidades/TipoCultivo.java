package ucentral.edu.co.AgroSense.Entidades;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "tipoCultivo")
public class TipoCultivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCultivo", nullable = false)
    private Integer idCultivo;

    @Column(name = "nombreCultivo", nullable = false)
    private String nombreCultivo;
}
