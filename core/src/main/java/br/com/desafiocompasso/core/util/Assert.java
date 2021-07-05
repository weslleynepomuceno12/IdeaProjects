package br.com.desafiocompasso.core.util;

import java.util.Collection;
import java.util.List;

/**
 * [Desafio Compasso] - Criação da classe Assert, utilizada para centralizar validações básicas do sistema.
 * @author Weslley Medeiros
 * @since 04/07/2021
 */
public class Assert {

    private Assert() {
        super();
    }

    /**
     * Verifica se value é uma String null ou vazia.
     *
     * @param value
     * @return boolean
     */
    public static boolean isNullAndEmpty(final String value) {
        return ((value == null) || (value.trim().equals("")));
    }

    /**
     * Verifica se value NÃO é uma String null ou vazia.
     *
     * @param value
     * @return boolean
     */
    public static boolean isNotNullAndEmpty(final String value) {
        return ((value != null) && (!value.trim().equals("")));
    }

    /**
     * Verifica se value NÃO é um objeto null ou vazio.
     *
     * @param objeto
     * @return boolean
     */
    public static boolean isNotNullAndEmpty(final Object objeto){
        if(objeto != null){
            if(!objeto.toString().trim().equals("")){
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica se value NÃO é um Number null ou vazio.
     *
     * @param value
     * @return boolean
     */
    public static boolean isNotNullAndEmpty(final Number value) {
        return ((value != null) && (value.longValue() > 0));
    }

    /**
     * Verifica se value é um Number null ou vazio.
     *
     * @param value
     * @return boolean
     */
    public static boolean isNullAndEmpty(final Number value) {
        return !isNotNullAndEmpty(value);
    }

    /**
     * Verifica se a Collection é null ou vazia.
     *
     * @param collection
     * @return boolean
     */
    public static boolean isEmptyList(
            final Collection<? extends Object> collection) {
        return ((collection == null) || (collection.isEmpty()));
    }

    /**
     * Verifica se a Collection não se encontra vazia.
     *
     * @param collection
     * @return boolean - boolean
     */
    public static boolean isNotEmptyList(
            final Collection<? extends Object> collection) {
        return !isEmptyList(collection);
    }

    /**
     * Verifica se a collection é null, vazia ou se possui apenas um registro de
     * string vazio.
     *
     * @param collection
     * @return true caso seja vazio, false caso contrário.
     */
    public static boolean isListEmptyRegister(
            final Collection<String> collection) {
        boolean result = isEmptyList(collection);
        if (!result) {
            if ((collection.size() == 1)
                    && (isNullAndEmpty(((List<String>) collection).get(0)))) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    /**
     * Verifica se o Object é null.
     *
     * @param value
     * @return boolean
     */
    public static boolean isNull(final Object value) {
        return (value == null);
    }

    /**
     * Verifica se o Object NÃO é null.
     *
     * @param value
     * @return boolean
     */
    public static boolean isNotNull(final Object value) {
        return !isNull(value);
    }

    public static boolean isNegativo(final Number value) {
        return isNotNull(value) && value.longValue() <= 0;
    }

    /**
     * Metodo que realiza a validacao do Numero qué é informado pelo parametro,
     * verificando se é menor ou igual a zero.
     *
     * @param value :valor a ser recebido onde a String deve conter um valor numerico
     * @return retorna true se for negativo ou falso se for positivo.
     */
    public static boolean isNegativo(final String value) {
        try {

            return isNegativo(Long.valueOf(value));

        } catch (final NumberFormatException exc) {
            return true;
        }
    }

    /**
     * Verifica se a String NÃO é um numero.
     *
     * @param value
     * @return boolean
     */
    public static boolean isNotNumber(final String value) {
        try {
            Long.valueOf(value);
            return false;
        } catch (final NumberFormatException exc) {
            return true;
        }
    }

    /**
     * Valida se todos os argumentos são não-nulos.
     *
     * @param objects
     * @return boolean
     */
    public static boolean areAllArgsNotNull(Object... objects) {
        for (Object object : objects) {
            if (object == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica se value é uma String vazia.
     *
     * @param value
     * @return boolean
     */
    public static boolean isEmpty(final String value) {
        return (value.trim().equals(""));
    }

}
