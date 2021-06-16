package com.mercadolibre.mutant.services.impl;

import com.mercadolibre.mutant.model.Audit;
import com.mercadolibre.mutant.payload.StatsResponse;
import com.mercadolibre.mutant.repository.AuditRepository;
import com.mercadolibre.mutant.services.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class AuditServiceImpl implements AuditService {

    private final AuditRepository auditRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    public AuditServiceImpl(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    public void save(Audit audit) {
        this.auditRepository.save(audit);
    }

    public StatsResponse countBySequence(String sequence) {
        Query query = new Query();
        StatsResponse statsResponse = new StatsResponse();
        query.addCriteria(Criteria.where("audit_sequence").is(sequence));
        statsResponse.setCount_human_dna(mongoTemplate.count(query, "audits"));
        return statsResponse;
    }

}
