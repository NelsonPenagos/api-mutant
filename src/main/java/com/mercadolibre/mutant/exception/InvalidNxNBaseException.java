package com.mercadolibre.mutant.exception;

/**
 * Exception structure NxN
 *
 * @author nelson.penagos
 */
public class InvalidNxNBaseException extends Exception {
    public InvalidNxNBaseException() {
        super("La estructura no es NxN");
    }
}
