package br.com.desafiocompasso.core.util;

/**
 * [Desafio Compasso] - Enum utilizado para centralizar as mensagens de validação utilizadas no sistema.
 * @author Weslley Medeiros
 * @since 04/07/2021
 */
public enum MessageEnum {

    MESSAGE_400("Ocorreu um erro nos dados, verifique os campos informados e tente novamente."),
    MESSAGE_404("Produto com ID: {0} inexistente.");

    private String descricao;

    MessageEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
