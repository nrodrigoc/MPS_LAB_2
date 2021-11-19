package br.com.mps.exemplo.business.control;

import br.com.mps.exemplo.business.dto.UsuarioDTO;
import br.com.mps.exemplo.business.dto.UsuarioDataNascimentoDTO;
import br.com.mps.exemplo.business.model.Usuario;

import java.util.List;

public interface UsuarioControl {

    Usuario deletaUsuarioPorUsername(String username) throws Exception;

    UsuarioDataNascimentoDTO cadastraUsuario(UsuarioDTO usuario);

    List<UsuarioDataNascimentoDTO> listaUsuarios();

    List<UsuarioDataNascimentoDTO> listaUsuariosPorUsername();

    List<UsuarioDataNascimentoDTO> listaUsuariosPorDataNascimento();
}
