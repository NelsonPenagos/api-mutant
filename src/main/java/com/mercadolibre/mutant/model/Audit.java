package com.mercadolibre.mutant.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "audits")
public class Audit {

    @Id
    private String audit_id;
    private String audit_dna;
    private String audit_sequence;

    public String getAudit_id() {
        return audit_id;
    }

    public void setAudit_id(String audit_id) {
        this.audit_id = audit_id;
    }

    public String getAudit_dna() {
        return audit_dna;
    }

    public void setAudit_dna(String audit_dna) {
        this.audit_dna = audit_dna;
    }

    public String getAudit_sequence() {
        return audit_sequence;
    }

    public void setAudit_sequence(String audit_sequence) {
        this.audit_sequence = audit_sequence;
    }
}
