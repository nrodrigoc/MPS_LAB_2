package br.com.mps.exemplo.infra;

import br.com.mps.exemplo.business.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findFirstByUsername(String username);

    Optional<Usuario> deleteByUsername(String username);

}
