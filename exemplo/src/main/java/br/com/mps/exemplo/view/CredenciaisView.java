package br.com.mps.exemplo.view;

import br.com.mps.exemplo.business.control.UsuarioControl;
import br.com.mps.exemplo.business.dto.UsuarioDTO;
import br.com.mps.exemplo.business.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/credenciais")
public class CredenciaisView {

    private final UsuarioControl usuarioControl;

    public CredenciaisView(UsuarioControl usuarioControl) {
        this.usuarioControl = usuarioControl;
    }

    @PostMapping // Cadastra um usuário
    public ResponseEntity<?> cadastraUsuario(@RequestBody UsuarioDTO usuario) {
        Usuario response = usuarioControl.cadastraUsuario(usuario);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping // Lista todos os usuários cadastrados
    public ResponseEntity<?> listaUsuarios() {
        return ResponseEntity.ok(usuarioControl.listaUsuarios());
    }

    @DeleteMapping // Deleta um usuário
    public ResponseEntity<?> deletaUsuario(@RequestParam String username) throws Exception {
        return ResponseEntity.ok(usuarioControl.deletaUsuarioPorUsername(username));
    }

    @GetMapping("/ordenadas-por-username") // Lista os usuários ordenados por login
    public ResponseEntity<?> listaUsuariosPorUsername() {
        return ResponseEntity.ok(usuarioControl.listaUsuariosPorUsername());
    }

    @GetMapping("/ordenadas-por-nascimento") // Lista os usuários ordenados por data de nascimento
    public ResponseEntity<?> listaUsuariosPorNascimento() {
        return ResponseEntity.ok(usuarioControl.listaUsuariosPorDataNascimento());
    }


}
