package com.mercadolibre.mutant.services.impl;

import com.mercadolibre.mutant.model.Audit;
import com.mercadolibre.mutant.payload.StatsResponse;
import com.mercadolibre.mutant.services.AuditService;
import com.mercadolibre.mutant.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class AuditServiceImpl implements AuditService {

    private static final String MUTANT = "MUTANT";
    private static final String HUMAN = "HUMAN";
    private static final String COLLECTION = "audits";

    @Autowired
    MongoTemplate mongoTemplate;

    public void save(Audit audit) {
        Query query = new Query();
        query.addCriteria(Criteria.where("audit_dna").is(audit.getAudit_dna()));
        if (mongoTemplate.findOne(query, Audit.class) == null) {
            mongoTemplate.save(audit);
        }
    }

    public StatsResponse countBySequenceMutant() {
        Query qMutant = new Query();
        StatsResponse statsResponse = new StatsResponse();
        qMutant.addCriteria(Criteria.where("audit_sequence").is(MUTANT));
        long mutant = mongoTemplate.count(qMutant, COLLECTION);
        statsResponse.setCount_mutant_dna(mutant);

        Query qNoMutant = new Query();
        qNoMutant.addCriteria(Criteria.where("audit_sequence").is(HUMAN));
        long human = mongoTemplate.count(qNoMutant, COLLECTION);
        statsResponse.setCount_human_dna(human);
        statsResponse.setRatio(Util.getRatio(mutant, human));

        return statsResponse;
    }

}
