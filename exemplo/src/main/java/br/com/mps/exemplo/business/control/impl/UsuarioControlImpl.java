package br.com.mps.exemplo.business.control.impl;

import br.com.mps.exemplo.business.dto.UsuarioDTO;
import br.com.mps.exemplo.business.dto.UsuarioDataNascimentoDTO;
import br.com.mps.exemplo.infra.UsuarioRepository;
import br.com.mps.exemplo.business.control.UsuarioControl;
import br.com.mps.exemplo.business.control.Validacao;
import br.com.mps.exemplo.business.exception.ValidacaoException;
import br.com.mps.exemplo.business.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsuarioControlImpl implements UsuarioControl {

    private final UsuarioRepository usuarioRepository;

    public UsuarioControlImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario deletaUsuarioPorUsername(String username) throws Exception {
        return usuarioRepository.deleteByUsername(username)
                .orElseThrow(() -> new Exception("Username não encontrado."));
    }

    @Override
    public UsuarioDataNascimentoDTO cadastraUsuario(UsuarioDTO usuarioDTO) throws ValidacaoException{
        String username = usuarioDTO.getUsername();
        String password = usuarioDTO.getPassword();
        Validacao.validar(username, new ValidacaoUsername());
        Validacao.validar(password, new ValidacaoPassword());

        Usuario usuario = new Usuario(username, password, usuarioDTO.getData_nascimento());
        if (usuarioDTO.getData_nascimento() == null) {
            throw new ValidacaoException("Data de nascimento nula");
        }
        return UsuarioDataNascimentoDTO.fromUsuario(usuarioRepository.save(usuario));
    }

    @Override
    public List<UsuarioDataNascimentoDTO> listaUsuarios() {
        return UsuarioDataNascimentoDTO.fromUsuario(usuarioRepository.findAll());
    }

    @Override
    public List<UsuarioDataNascimentoDTO> listaUsuariosPorUsername() {

        TreeSet<Usuario> treeSet = new TreeSet<>(usuarioRepository.findAll());

        Iterator<Usuario> iterator = treeSet.iterator();

        List<Usuario> listaOrdenada = new ArrayList<>();
        while (iterator.hasNext()) {
            listaOrdenada.add(iterator.next());
        }

        return UsuarioDataNascimentoDTO.fromUsuario(listaOrdenada);
    }

    @Override
    public List<UsuarioDataNascimentoDTO> listaUsuariosPorDataNascimento() {
        List<UsuarioDataNascimentoDTO> usuariosDN = UsuarioDataNascimentoDTO.fromUsuario(usuarioRepository.findAll());

        TreeSet<UsuarioDataNascimentoDTO> treeSet = new TreeSet<>(usuariosDN);

        Iterator<UsuarioDataNascimentoDTO> iterator = treeSet.iterator();

        List<UsuarioDataNascimentoDTO> listaOrdenada = new ArrayList<>();
        while (iterator.hasNext()) {
            listaOrdenada.add(iterator.next());
        }

        return listaOrdenada;
    }
}
