package br.com.mps.exemplo.business.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Usuario implements Comparable<Usuario>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long id;

    private String username;

    private String password;

    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date data_nascimento;

    public Usuario(String username, String password, Date data_nascimento) {
        this.username = username;
        this.password = password;
        this.data_nascimento = data_nascimento;
    }

    public Usuario() {
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

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    @Override
    public int compareTo(Usuario o) {
        return getUsername().compareTo(o.getUsername());
    }
}
