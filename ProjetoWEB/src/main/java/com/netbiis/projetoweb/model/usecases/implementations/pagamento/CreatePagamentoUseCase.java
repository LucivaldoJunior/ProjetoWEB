package com.netbiis.projetoweb.model.usecases.implementations.pagamento;

import com.netbiis.projetoweb.model.daos.IpagamentoDAO;
import com.netbiis.projetoweb.model.entity.PagamentoEntity;
import com.netbiis.projetoweb.model.usecases.ICreatePagamentoUseCase;

public class CreatePagamentoUseCase implements ICreatePagamentoUseCase {

    private final IpagamentoDAO pagamentoDAO;

    public CreatePagamentoUseCase(IpagamentoDAO pagamentoDAO) {
        super();
        this.pagamentoDAO = pagamentoDAO;
    }

    @Override
    public void execute(PagamentoEntity pagamento) {
        pagamentoDAO.create(pagamento);
    }
}
