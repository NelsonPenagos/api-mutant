package com.mercadolibre.mutant.util;

/**
 * @author nelson.penagos
 */
public class Util {

    /**
     * Get the value of the ratio
     *
     * @param numberMutant
     * @param numberHuman
     * @return
     */
    public static float getRatio(long numberMutant, long numberHuman) {
        return (((float) numberMutant / numberHuman) * 100) / 100;
    }

    /**
     * Match with letters A,T,G,C
     *
     * @param dna
     * @return
     */
    public static boolean isValidADN(String[] dna) {
        for (String x : dna) {
            if (!x.matches("(A|T|G|C)+")) {
                return false;
            }
        }
        return true;
    }

    /**
     * Valid NxN structure
     *
     * @param dna
     * @return
     */
    public static boolean isNxN(String[] dna) {
        for (String x : dna) {
            if (x.length() != dna.length) {
                return false;
            }
        }
        return true;
    }
}
