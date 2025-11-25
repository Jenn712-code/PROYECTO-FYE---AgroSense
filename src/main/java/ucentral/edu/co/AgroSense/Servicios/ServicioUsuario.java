package ucentral.edu.co.AgroSense.Servicios;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ucentral.edu.co.AgroSense.Entidades.Usuario;
import ucentral.edu.co.AgroSense.Repositorios.RepositorioUsuario;
import ucentral.edu.co.AgroSense.dto.UsuarioDTO;

@Service
@AllArgsConstructor
public class ServicioUsuario {

    private final RepositorioUsuario repositorioUsuario;

    public UsuarioDTO crearUsuario(UsuarioDTO dto) {

        // ===== VALIDACIONES BÁSICAS ===== //
        if (dto.cedula == null ||
                dto.nombreUsuario == null || dto.nombreUsuario.isBlank() ||
                dto.contrasena == null || dto.contrasena.isBlank() ||
                dto.nombreCompleto == null || dto.nombreCompleto.isBlank() ||
                dto.correo == null || dto.correo.isBlank() ||
                dto.celular == null ||
                dto.departamento == null || dto.departamento.isBlank() ||
                dto.municipio == null || dto.municipio.isBlank() ||
                dto.tipoUsuario == null || dto.tipoUsuario.isBlank()) {

            UsuarioDTO error = new UsuarioDTO();
            error.cedula = (long) -1;  // Error por datos incompletos
            return error;
        }

        // ===== VERIFICAR SI YA EXISTE ===== //
        if (repositorioUsuario.existsByCedula(dto.cedula)) {
            UsuarioDTO error = new UsuarioDTO();
            error.cedula = (long) -2; // Cedula duplicada
            return error;
        }

        // ===== MAPEAR DTO → ENTIDAD ===== //
        Usuario entidad = new Usuario();
        entidad.setCedula(dto.cedula);
        entidad.setNombreUsuario(dto.nombreUsuario);
        entidad.setContrasena(dto.contrasena);
        entidad.setNombreCompleto(dto.nombreCompleto);
        entidad.setCorreo(dto.correo);
        entidad.setCelular(dto.celular);
        entidad.setDepartamento(dto.departamento);
        entidad.setMunicipio(dto.municipio);
        entidad.setTipoUsuario(dto.tipoUsuario);
        entidad.setProposito(dto.proposito);
        entidad.setNivelConocimiento(dto.nivelConocimiento);
        entidad.setTamañoTerreno(dto.tamañoTerreno);
        entidad.setUsoDatos(dto.usoDatos);

        // ===== GUARDAR EN LA BD ===== //
        Usuario guardado = repositorioUsuario.save(entidad);

        // ===== MAPEAR ENTIDAD → DTO FINAL ===== //
        UsuarioDTO respuesta = new UsuarioDTO();
        respuesta.cedula = guardado.getCedula();
        respuesta.nombreUsuario = guardado.getNombreUsuario();
        respuesta.contrasena = guardado.getContrasena();
        respuesta.nombreCompleto = guardado.getNombreCompleto();
        respuesta.correo = guardado.getCorreo();
        respuesta.celular = guardado.getCelular();
        respuesta.departamento = guardado.getDepartamento();
        respuesta.municipio = guardado.getMunicipio();
        respuesta.tipoUsuario = guardado.getTipoUsuario();
        respuesta.proposito = guardado.getProposito();
        respuesta.nivelConocimiento = guardado.getNivelConocimiento();
        respuesta.tamañoTerreno = guardado.getTamañoTerreno();
        respuesta.usoDatos = guardado.getUsoDatos();

        return respuesta;
    }

    public UsuarioDTO loginUsuario(String nombreUsuario, String contrasena) {

        // Buscar usuario por nombreUsuario
        Usuario usuario = repositorioUsuario.findByNombreUsuario(nombreUsuario)
                .orElse(null);

        if (usuario == null) {
            // Usuario NO existe
            UsuarioDTO error = new UsuarioDTO();
            error.cedula = (long) -1; // código de usuario no encontrado
            return error;
        }

        // Validar contraseña
        if (!usuario.getContrasena().equals(contrasena)) {
            UsuarioDTO error = new UsuarioDTO();
            error.cedula = (long) -2; // contraseña incorrecta
            return error;
        }

        // Login correcto → Devolver DTO con información básica
        UsuarioDTO dto = new UsuarioDTO();
        dto.cedula = usuario.getCedula();
        dto.nombreUsuario = usuario.getNombreUsuario();
        dto.correo = usuario.getCorreo();
        dto.tipoUsuario = usuario.getTipoUsuario();

        return dto;
    }
}
