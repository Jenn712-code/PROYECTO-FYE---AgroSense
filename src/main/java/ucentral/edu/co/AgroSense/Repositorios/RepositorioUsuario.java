package ucentral.edu.co.AgroSense.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucentral.edu.co.AgroSense.Entidades.Usuario;

import java.util.Optional;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario,Long> {

    Optional<Usuario> findByNombreUsuario(String nombreUsuario);

    boolean existsByCedula(Long cedula);
}
