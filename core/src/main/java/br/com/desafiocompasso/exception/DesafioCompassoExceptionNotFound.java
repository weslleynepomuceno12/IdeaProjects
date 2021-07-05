package br.com.desafiocompasso.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * [Desafio Compasso] - Classe utilizada para o erro Not Found, para o tipo de exception DesafioCompasso.
 * @author Weslley Medeiros
 * @since 04/07/2021
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class DesafioCompassoExceptionNotFound extends RuntimeException {
    public DesafioCompassoExceptionNotFound(String message) {
        super(message);
    }
}