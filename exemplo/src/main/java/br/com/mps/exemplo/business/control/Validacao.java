package br.com.mps.exemplo.business.control;

import br.com.mps.exemplo.business.exception.ValidacaoException;

public interface Validacao {

    void isValid(String object) throws ValidacaoException;

    static void validar(String value, Validacao validador){
       validador.isValid(value);
    }
}

