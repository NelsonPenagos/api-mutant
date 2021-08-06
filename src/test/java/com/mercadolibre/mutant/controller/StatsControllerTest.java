package com.mercadolibre.mutant.controller;

import com.mercadolibre.mutant.payload.StatsResponse;
import com.mercadolibre.mutant.services.AuditService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class StatsControllerTest {

    @Mock
    private AuditService auditService;

    @InjectMocks
    public StatsController statsController;

    StatsResponse statsResponse;

    @BeforeEach
    void setUp() {
        statsResponse = new StatsResponse();
        MockitoAnnotations.openMocks(this);
        Mockito.when(auditService.countBySequenceMutant()).thenReturn(statsResponse);
    }

    @Test
    void stats() {
        assertEquals(statsController.stats(), new ResponseEntity<>(statsResponse, HttpStatus.OK));
    }
}