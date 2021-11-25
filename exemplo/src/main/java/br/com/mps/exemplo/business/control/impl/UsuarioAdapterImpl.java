package br.com.mps.exemplo.business.control.impl;

import br.com.mps.exemplo.business.control.UsuarioAdapter;
import br.com.mps.exemplo.business.dto.UsuarioDTO;
import br.com.mps.exemplo.business.dto.UsuarioDataNascimentoDTO;
import br.com.mps.exemplo.business.model.Usuario;

public class UsuarioAdapterImpl implements UsuarioAdapter {

    private Usuario usuario;

    public UsuarioAdapterImpl(UsuarioDTO dto) {
        this.usuario = getUsuarioFromDTO(dto);
    }

    public UsuarioAdapterImpl(UsuarioDataNascimentoDTO dto) {
        this.usuario = getUsuarioFromDTO(dto);
    }

    @Override
    public Usuario getUsuarioFromDTO(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setUsername(dto.getUsername());
        usuario.setPassword(dto.getPassword());
        usuario.setData_nascimento(dto.getData_nascimento());

        return usuario;
    }

    @Override
    public Usuario getUsuarioFromDTO(UsuarioDataNascimentoDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setUsername(dto.getUsername());
        usuario.setPassword(dto.getPassword());
        usuario.setData_nascimento(dto.getData_nascimento().toDate());
        return usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
