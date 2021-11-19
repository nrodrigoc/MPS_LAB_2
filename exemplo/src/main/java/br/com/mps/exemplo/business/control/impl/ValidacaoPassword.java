package br.com.mps.exemplo.business.control.impl;

import br.com.mps.exemplo.business.control.Validacao;
import br.com.mps.exemplo.business.exception.ValidacaoException;

public class ValidacaoPassword implements Validacao{

    @Override
    public void isValid(String object) {
        if(object.length() > 20 || object.length() < 8 || object.isBlank() ||
                object.matches("(.*?\\d){2}")){
            throw new ValidacaoException("Validação para password falhou");
        }
    }
}
