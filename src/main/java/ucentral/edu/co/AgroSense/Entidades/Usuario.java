package ucentral.edu.co.AgroSense.Entidades;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @Column(name = "cedula", nullable = false)
    private Long cedula;

    @Column(name = "nombreUsuario", nullable = false, unique = true)
    private String nombreUsuario;

    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    @Column(name = "nombreCompleto", nullable = false)
    private String nombreCompleto;

    @Column(name = "correo", nullable = false, unique = true)
    private String correo;

    @Column(name = "celular", nullable = false)
    private Long celular;

    @Column(name = "departamento", nullable = false)
    private String departamento;

    @Column(name = "municipio", nullable = false)
    private String municipio;

    @Column(name = "tipoUsuario", nullable = false)
    private String tipoUsuario;

    @Column(name = "proposito", nullable = false)
    private String proposito;

    @Column(name = "nivelConocimiento", nullable = false)
    private String nivelConocimiento;

    @Column(name = "tamañoTerreno")
    private Integer tamañoTerreno;

    @Column(name = "usoDatos", nullable = false)
    private Boolean usoDatos;
}
