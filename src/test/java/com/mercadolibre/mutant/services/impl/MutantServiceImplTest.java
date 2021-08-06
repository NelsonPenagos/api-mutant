package com.mercadolibre.mutant.services.impl;

import com.mercadolibre.mutant.mutant.MutantSequence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class MutantServiceImplTest {

    @InjectMocks
    MutantServiceImpl mutantService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void isMutant() {
        String[] dnaA = {"ATGCGA","CCGGGC","TTATGT","AGAATG","CCTCTA","TCACTG"};
        assertFalse(mutantService.isMutant(dnaA));
    }
}