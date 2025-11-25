package ucentral.edu.co.AgroSense.Controladores;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ucentral.edu.co.AgroSense.Servicios.ServicioUsuario;
import ucentral.edu.co.AgroSense.dto.UsuarioDTO;


@RestController
@AllArgsConstructor
@RequestMapping("/usuarios")
public class ControladorUsuario {

    private final ServicioUsuario servicioUsuario;

    @PostMapping("/crear")
    public ResponseEntity<?> crearUsuario(@RequestBody UsuarioDTO dto) {

        if (dto.cedula == null ||
                dto.nombreUsuario == null || dto.nombreUsuario.isBlank() ||
                dto.contrasena == null || dto.contrasena.isBlank()) {

            return ResponseEntity.badRequest()
                    .body("Error: faltan datos obligatorios (cedula, nombreUsuario o contraseña).");
        }

        UsuarioDTO nuevoUsuario = servicioUsuario.crearUsuario(dto);

        if (nuevoUsuario.cedula != null && nuevoUsuario.cedula == -1) {
            return ResponseEntity.badRequest()
                    .body("Datos incompletos para crear usuario.");
        }

        if (nuevoUsuario.cedula != null && nuevoUsuario.cedula == -2) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Ya existe un usuario con esa cédula.");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioDTO dto) {

        if (dto.nombreUsuario == null || dto.nombreUsuario.isBlank() ||
                dto.contrasena == null || dto.contrasena.isBlank()) {

            return ResponseEntity.badRequest()
                    .body("Error: faltan datos obligatorios (nombreUsuario y contrasena).");
        }

        UsuarioDTO resultado = servicioUsuario.loginUsuario(
                dto.nombreUsuario,
                dto.contrasena
        );

        // Usuario NO existe
        if (resultado.cedula != null && resultado.cedula == -1) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado.");
        }

        // Contraseña incorrecta
        if (resultado.cedula != null && resultado.cedula == -2) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Contraseña incorrecta.");
        }

        // Login correcto
        return ResponseEntity.ok(resultado);
    }
}
