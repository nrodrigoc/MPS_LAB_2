package br.com.mps.exemplo.business.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UsuarioDTO {

    private String username;
    private String password;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data_nascimento;

    public UsuarioDTO(String username, String password, String data_nascimento) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        this.username = username;
        this.password = password;
        this.data_nascimento = formato.parse(data_nascimento);
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

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
}
