package ucentral.edu.co.AgroSense.Entidades;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "plagas")
public class Plaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPlaga", nullable = false)
    private Integer idPlaga;

    @Column(name = "nombrePlaga", nullable = false)
    private String nombrePlaga;
}
