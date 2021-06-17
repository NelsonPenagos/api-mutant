package com.mercadolibre.mutant.controller;

import com.mercadolibre.mutant.exception.InvalidDnaBaseException;
import com.mercadolibre.mutant.exception.InvalidNxNBaseException;
import com.mercadolibre.mutant.model.Audit;
import com.mercadolibre.mutant.payload.ErrorMessageResponse;
import com.mercadolibre.mutant.payload.request.MutantRequest;
import com.mercadolibre.mutant.services.AuditService;
import com.mercadolibre.mutant.services.MutantService;
import com.mercadolibre.mutant.util.Util;
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

    @Autowired
    private AuditService auditService;

    private static final String MUTANT = "MUTANT";
    private static final String HUMAN = "HUMAN";

    /**
     * @param mutantRequest
     * @return
     */
    @PostMapping("/mutant")
    public ResponseEntity<?> mutant(@RequestBody MutantRequest mutantRequest) {

        try {
            if (Util.isNxN(mutantRequest.getDna())) {
                if (Util.isValidADN(mutantRequest.getDna())) {
                    Audit audit = new Audit();
                    audit.setAudit_dna(mutantRequest.getDna());

                    if (!mutantService.isMutant(mutantRequest.getDna())) {
                        audit.setAudit_sequence(HUMAN);
                        auditService.save(audit);
                        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
                    }
                    audit.setAudit_sequence(MUTANT);
                    auditService.save(audit);
                    return new ResponseEntity<>(HttpStatus.OK);
                } else {
                    throw new InvalidDnaBaseException();
                }
            } else {
                throw new InvalidNxNBaseException();
            }
        } catch (InvalidDnaBaseException | InvalidNxNBaseException e) {
            ErrorMessageResponse errorMessage = new ErrorMessageResponse();
            errorMessage.setMessage(e.getMessage());
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
    }

}
