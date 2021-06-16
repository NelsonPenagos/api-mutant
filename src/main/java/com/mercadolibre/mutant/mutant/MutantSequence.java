package com.mercadolibre.mutant.mutant;

public class MutantSequence {

    private static int count = 0;

    public static boolean isMatchRow(String[] dna) {
        for (String mutant : dna) {
            if (isMatchADN(mutant)) {
                count++;
                if (count > 1) {
                    count = 0;
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isMatchColumn(String[] dna) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < dna.length; i++) {
            for (String s : dna) {
                text.append(s.charAt(i));
            }
            if (isMatchADN(text.toString())) {
                count++;
                if (count > 1) {
                    count = 0;
                    return true;
                }
            }
            text.setLength(0);
        }
        return false;
    }

    public static boolean isMatchTopDiagonal(String[] dna) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < dna.length; i++) {
            for (int j = 0; j <= i; j++) {
                text.append(dna[i - j].charAt(j));
            }
            if (isMatchADN(text.toString())) {
                count++;
                if (count > 1) {
                    count = 0;
                    return true;
                }
            }
            text.setLength(0);
        }
        return false;
    }

    public static boolean isMatchLowerDiagonal(String[] dna) {
        String[] lowerDiagonal = new String[dna.length];
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < dna.length; i++) {
            for (int j = 0; j < dna.length - i - 1; j++) {
                text.append(dna[dna.length - j - 1].charAt(j + i + 1));
            }
            if (isMatchADN(text.toString())) {
                count++;
                if (count > 1) {
                    count = 0;
                    return true;
                }
            }
            text.setLength(0);
        }
        return false;
    }

    public static boolean isMatchTopDiagonalReverse(String[] dna) {
        String[] topDiagonalReverse = new String[dna.length];
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < dna.length; i++) {
            for (int j = dna.length - 1; j >= i; j--) {
                text.append(dna[j - i].charAt(j));
            }
            if (isMatchADN(text.toString())) {
                count++;
                if (count > 1) {
                    count = 0;
                    return true;
                }
            }
            text.setLength(0);
        }
        return false;
    }

    public static boolean isMatchLowerDiagonalReverse(String[] dna) {
        String[] lowerDiagonalReverse = new String[dna.length];
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < dna.length; i++) {
            for (int j = dna.length - 1; j > i; j--) {
                text.append(dna[j].charAt(i));
            }
            if (isMatchADN(text.toString())) {
                count++;
                if (count > 1) {
                    count = 0;
                    return true;
                }
            }
            text.setLength(0);
        }
        return false;
    }

    static boolean isMatchADN(String dna) {
        return dna.matches(".*([A]{4}|[T]{4}|[C]{4}|[G]{4}).*");
    }
}
