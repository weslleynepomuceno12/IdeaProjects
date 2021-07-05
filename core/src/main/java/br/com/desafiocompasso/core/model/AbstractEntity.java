package br.com.desafiocompasso.core.model;

import java.io.Serializable;

/**
 * [Desafio Compasso] - Criação de interface abstrata responsável por encapsular o id.
 * @author Weslley Medeiros
 * @since 04/07/2021
 */
public interface AbstractEntity extends Serializable {
    Long getId();
}
