package com.mercadolibre.mutant.controller;

import com.mercadolibre.mutant.payload.request.MutantRequest;
import com.mercadolibre.mutant.services.MutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MutantController {

    @Autowired
    private MutantService mutantService;

    @PostMapping("/mutant")
    public ResponseEntity<?> mutant(@RequestBody MutantRequest mutantRequest) {

        if (!mutantService.isMutant(mutantRequest.getDna())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok().build();
    }
}
