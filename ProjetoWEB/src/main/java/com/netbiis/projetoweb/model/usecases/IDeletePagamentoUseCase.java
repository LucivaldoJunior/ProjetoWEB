package com.netbiis.projetoweb.model.usecases;

import com.netbiis.projetoweb.model.entity.PagamentoEntity;

public interface IDeletePagamentoUseCase {
    void execute(PagamentoEntity pagamento);
}
