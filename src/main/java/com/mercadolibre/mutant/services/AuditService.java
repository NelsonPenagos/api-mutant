package com.mercadolibre.mutant.services;

import com.mercadolibre.mutant.model.Audit;
import com.mercadolibre.mutant.payload.StatsResponse;

public interface AuditService {

    void save(Audit audit);

    StatsResponse countBySequence(String sequence);

}
