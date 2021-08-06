package com.mercadolibre.mutant.services.impl;

import com.mercadolibre.mutant.mutant.MutantSequence;
import com.mercadolibre.mutant.services.MutantService;
import org.springframework.stereotype.Service;

@Service
public class MutantServiceImpl implements MutantService {

    @Override
    public boolean isMutant(String[] dna) {

        if (MutantSequence.isMatchRow(dna)) {
            return true;
        } else if (MutantSequence.isMatchColumn(dna)) {
            return true;
        } else if (MutantSequence.isMatchTopDiagonal(dna)) {
            return true;
        } else if (MutantSequence.isMatchLowerDiagonal(dna)) {
            return true;
        } else if (MutantSequence.isMatchTopDiagonalReverse(dna)) {
            return true;
        } else if (MutantSequence.isMatchLowerDiagonalReverse(dna)) {
            return true;
        } else return false;
    }
}
