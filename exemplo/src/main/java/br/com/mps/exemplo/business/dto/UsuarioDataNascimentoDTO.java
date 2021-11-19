package br.com.mps.exemplo.business.dto;


import br.com.mps.exemplo.business.model.Usuario;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioDataNascimentoDTO implements Comparable<UsuarioDataNascimentoDTO>{

    private Long id;
    private String username;
    private String password;
    private Data data_nascimento;

    public static List<UsuarioDataNascimentoDTO> fromUsuario(List<Usuario> usuarios) {
        return usuarios.stream().map(UsuarioDataNascimentoDTO::fromUsuario).collect(Collectors.toList());
    }

    public static UsuarioDataNascimentoDTO fromUsuario(Usuario usuario) {
        UsuarioDataNascimentoDTO usuarioDN = new UsuarioDataNascimentoDTO();
        usuarioDN.setId(usuario.getId());
        usuarioDN.setUsername(usuario.getUsername());
        usuarioDN.setPassword(usuario.getPassword());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(usuario.getData_nascimento());
        Data data = new Data();
        data.setDia(calendar.get(Calendar.DAY_OF_MONTH));
        data.setMes(calendar.get(Calendar.MONTH) + 1);
        data.setAno(calendar.get(Calendar.YEAR));

        usuarioDN.setData_nascimento(data);
        return usuarioDN;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Data getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Data data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    @Override
    public int compareTo(UsuarioDataNascimentoDTO o) {
        int result = getData_nascimento().getAno().compareTo(o.getData_nascimento().getAno());

        if (result == 0)
            result = getData_nascimento().getMes().compareTo(o.getData_nascimento().getMes());

        if (result == 0)
            result = getData_nascimento().getDia().compareTo(o.getData_nascimento().getDia());

        if (result == 0)
            result = getUsername().compareTo(o.getUsername());

        return result;
    }
}
