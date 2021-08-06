package com.mercadolibre.mutant.controller;

import com.mercadolibre.mutant.exception.InvalidDnaBaseException;
import com.mercadolibre.mutant.exception.InvalidNxNBaseException;
import com.mercadolibre.mutant.model.Audit;
import com.mercadolibre.mutant.payload.request.MutantRequest;
import com.mercadolibre.mutant.services.AuditService;
import com.mercadolibre.mutant.services.MutantService;
import com.mercadolibre.mutant.util.Util;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class MutantControllerTest {

    @Mock
    private MutantService mutantService;

    @Mock
    private AuditService auditService;

    @InjectMocks
    private MutantController mutantController;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        String[] dnaA = {"ATGCGA","CCGGGC","TTATGT","AGAATG","CCTCTA","TCACTG"};
        Mockito.when(mutantService.isMutant(dnaA)).thenReturn(true);
        String[] dnaB = {"TTGCAA","CAGTGC","TTATGT","AGAAGG","CCTCTA","TCACTG"};
        Mockito.when(mutantService.isMutant(dnaB)).thenReturn(false);
    }


    @Test
    void mutant_Forbidden() {
        String[] dna = {"TTGCAA","CAGTGC","TTATGT","AGAAGG","CCTCTA","TCACTG"};
        MutantRequest mutantRequest = new MutantRequest();
        mutantRequest.setDna(dna);
        assertTrue(Util.isNxN(mutantRequest.getDna()));
        assertTrue(Util.isValidADN(mutantRequest.getDna()));
        assertFalse(mutantService.isMutant(mutantRequest.getDna()));
        auditService.save(new Audit());
        assertEquals(mutantController.mutant(mutantRequest), new ResponseEntity<>(HttpStatus.FORBIDDEN));
    }

    @Test
    void mutant_OK() {
        String[] dna = {"ATGCGA","CCGGGC","TTATGT","AGAATG","CCTCTA","TCACTG"};
        MutantRequest mutantRequest = new MutantRequest();
        mutantRequest.setDna(dna);
        assertTrue(Util.isNxN(mutantRequest.getDna()));
        assertTrue(Util.isValidADN(mutantRequest.getDna()));
        assertTrue(mutantService.isMutant(mutantRequest.getDna()));
        assertEquals(mutantController.mutant(mutantRequest), new ResponseEntity<>(HttpStatus.OK));
    }
}