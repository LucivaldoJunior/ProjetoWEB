package com.netbiis.projetoweb.model.usecases;

import com.netbiis.projetoweb.model.entity.PagamentoEntity;

public interface ICreatePagamentoUseCase {
    void execute(PagamentoEntity pagamento);
}
