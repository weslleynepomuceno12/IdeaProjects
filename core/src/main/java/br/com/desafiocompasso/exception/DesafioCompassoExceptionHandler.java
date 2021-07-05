package br.com.desafiocompasso.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * [Desafio Compasso] - Classe Handler com os métodos de retorno para as validações com retorno de status 400 e 404.
 * @author Weslley Medeiros
 * @since 04/07/2021
 */
@ControllerAdvice
public class DesafioCompassoExceptionHandler {
    @ExceptionHandler(DesafioCompassoException.class)
    public ResponseEntity<?> handlerException(DesafioCompassoException exception){
        DesafioCompassoExceptionDetails details = DesafioCompassoExceptionDetails.Builder
                .newBuilder()
                .status_code(400)
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DesafioCompassoExceptionNotFound.class)
    public ResponseEntity<?> handlerException(DesafioCompassoExceptionNotFound exception){
        DesafioCompassoExceptionDetails details = DesafioCompassoExceptionDetails.Builder
                .newBuilder()
                .status_code(404)
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }
}
