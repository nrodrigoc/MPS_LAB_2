package br.com.mps.exemplo.business.dto;

import java.text.DateFormatSymbols;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Data{

    private Integer dia;

    private Integer mes;

    private Integer ano;

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public Date toDate() {
        Calendar calendar = new GregorianCalendar(getAno(), getIntMes(), getDia());
        return calendar.getTime();
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public int getIntMes() {
        return getMes() - 1;
    }
}
