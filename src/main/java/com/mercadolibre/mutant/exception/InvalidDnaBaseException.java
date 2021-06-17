package com.mercadolibre.mutant.exception;

/**
 * Exception Invalid DNA
 *
 * @author nelson.penagos
 */
public class InvalidDnaBaseException extends Exception {
    public InvalidDnaBaseException() {
        super("la cadena de ADN no es correcta");
    }
}
