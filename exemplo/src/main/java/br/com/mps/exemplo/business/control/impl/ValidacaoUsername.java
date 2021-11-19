package br.com.mps.exemplo.business.control.impl;

import br.com.mps.exemplo.business.control.Validacao;
import br.com.mps.exemplo.business.exception.ValidacaoException;

public class ValidacaoUsername implements Validacao {

    @Override
    public void isValid(String object) {

        if(object.length() > 12 || object.isBlank() ||
                object.matches(".*\\d.*")){
            throw new ValidacaoException("Validação para username falhou");
        }
    }
}
