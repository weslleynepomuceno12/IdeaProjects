package br.com.desafiocompasso.exception;

import lombok.Getter;

/**
 * [Desafio Compasso] - Classe utilizada para criar o retorno das exceptions de forma personalizada para o sistema, foi utilizado a extensão "Builder Generater".
 * @author Weslley Medeiros
 * @since 04/07/2021
 */
@Getter
public class DesafioCompassoExceptionDetails {
    private Integer status_code;
    private String message;

    private DesafioCompassoExceptionDetails() {
    }

    public static final class Builder {
        private Integer status_code;
        private String message;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder status_code(Integer status_code) {
            this.status_code = status_code;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public DesafioCompassoExceptionDetails build() {
            DesafioCompassoExceptionDetails desafioCompassoExceptionDetails = new DesafioCompassoExceptionDetails();
            desafioCompassoExceptionDetails.status_code = this.status_code;
            desafioCompassoExceptionDetails.message = this.message;
            return desafioCompassoExceptionDetails;
        }
    }
}
