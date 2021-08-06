package com.mercadolibre.mutant.mutant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MutantSequenceTest {
    String[] dnaA = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};

    @BeforeEach
    void setUp() {
    }

    @Test
    void isMatchRow() {

        assertTrue(MutantSequence.isMatchRow(dnaA));
    }

    @Test
    void isMatchColumn() {
        assertFalse(MutantSequence.isMatchColumn(dnaA));
    }

    @Test
    void isMatchTopDiagonal() {
        assertFalse(MutantSequence.isMatchTopDiagonal(dnaA));
    }

    @Test
    void isMatchLowerDiagonal() {
        assertFalse(MutantSequence.isMatchLowerDiagonal(dnaA));
    }

    @Test
    void isMatchTopDiagonalReverse() {
        assertFalse(MutantSequence.isMatchTopDiagonalReverse(dnaA));
    }

    @Test
    void isMatchLowerDiagonalReverse() {
        assertFalse(MutantSequence.isMatchLowerDiagonalReverse(dnaA));
    }

    @Test
    void isMatchADN() {
        String dna = "ATGCGACAGTGCTTATGTAGAAGGCCCCTATCACTG";
        assertTrue(MutantSequence.isMatchADN(dna));
    }
}