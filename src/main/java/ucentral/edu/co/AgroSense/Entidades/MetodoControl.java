package ucentral.edu.co.AgroSense.Entidades;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "metodosControl")
public class MetodoControl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMetodoControl", nullable = false)
    private Integer idMetodoControl;

    @Column(name = "nombreMetodoControl", nullable = false)
    private String nombreMetodoControl;
}
