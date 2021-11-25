package br.com.mps.exemplo.business.control;

import br.com.mps.exemplo.business.dto.UsuarioDTO;
import br.com.mps.exemplo.business.dto.UsuarioDataNascimentoDTO;
import br.com.mps.exemplo.business.model.Usuario;

public interface UsuarioAdapter {

    Usuario getUsuarioFromDTO(UsuarioDTO dto);

    Usuario getUsuarioFromDTO(UsuarioDataNascimentoDTO dto);

}
