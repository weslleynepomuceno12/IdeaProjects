package br.com.desafiocompasso.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * [Desafio Compasso] - Classe utilizada para o erro Bad Request, para o tipo de exception DesafioCompasso.
 * @author Weslley Medeiros
 * @since 04/07/2021
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DesafioCompassoException extends RuntimeException {
    public DesafioCompassoException(String message) {
        super(message);
    }
}