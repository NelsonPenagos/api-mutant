package com.mercadolibre.mutant.repository;

import com.mercadolibre.mutant.model.Audit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends MongoRepository<Audit, Long> {
}
