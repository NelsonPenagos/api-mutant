package com.mercadolibre.mutant.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void getRatio() {
        long numberMutant = 40;
        long numberHuman = 100;
        assertEquals(Util.getRatio(numberMutant, numberHuman), 0.4000000059604645);

    }

    @Test
    void isValidADN() {
        String[] dnaA = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        assertTrue(Util.isValidADN(dnaA));

        String[] dnaB = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTX"};
        assertFalse(Util.isValidADN(dnaB));
    }

    @Test
    void isNxN() {
        String[] dnaA = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        assertTrue(Util.isNxN(dnaA));

        String[] dnaB = {"ATGCGA","CAGTGXXXXC","TTATGT","AGAAGG","CCCCTA","TCACTX"};
        assertFalse(Util.isNxN(dnaB));
    }
}