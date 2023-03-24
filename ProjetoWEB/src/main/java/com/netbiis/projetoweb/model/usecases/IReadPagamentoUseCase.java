package com.netbiis.projetoweb.model.usecases;

import com.netbiis.projetoweb.model.entity.PagamentoEntity;

import java.util.List;
import java.util.Optional;

public interface IReadPagamentoUseCase {
    List<PagamentoEntity> executeAll();
    Optional<PagamentoEntity> executeesp(PagamentoEntity pagamento);
}
