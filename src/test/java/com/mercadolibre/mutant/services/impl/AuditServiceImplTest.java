package com.mercadolibre.mutant.services.impl;

import com.mercadolibre.mutant.model.Audit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import static org.junit.jupiter.api.Assertions.*;

class AuditServiceImplTest {

    @Mock
    MongoTemplate mongoTemplate;

    @InjectMocks
    AuditServiceImpl auditService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Mockito.when(mongoTemplate.findOne(new Query(), Audit.class)).thenReturn(null);
        Mockito.when(mongoTemplate.save(new Audit())).thenReturn(new Audit());
    }

    @Test
    void save() {
        auditService.save(new Audit());
    }

    @Test
    void countBySequenceMutant() {
    }
}