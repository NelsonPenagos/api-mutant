package com.mercadolibre.mutant.controller;

import com.mercadolibre.mutant.payload.StatsResponse;
import com.mercadolibre.mutant.services.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StatsController {

    @Autowired
    private AuditService auditService;

    @GetMapping("/stats")
    public ResponseEntity<StatsResponse> stats() {
        return new ResponseEntity<>(auditService.countBySequence("MUTANT"), HttpStatus.OK);
    }
}
