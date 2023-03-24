package com.netbiis.projetoweb.model.usecases.implementations.pagamento;

import com.netbiis.projetoweb.model.daos.IpagamentoDAO;
import com.netbiis.projetoweb.model.entity.PagamentoEntity;
import com.netbiis.projetoweb.model.usecases.IUpdatePagamentoUseCase;

import java.util.Optional;

public class UpdatePagamentoUseCase implements IUpdatePagamentoUseCase {
    private final IpagamentoDAO pagamentoDAO;

    public UpdatePagamentoUseCase(IpagamentoDAO pagamentoDAO) {
        super();
        this.pagamentoDAO = pagamentoDAO;
    }

    @Override
    public void execute(PagamentoEntity pagamento) {
        Optional<PagamentoEntity> pagamentoAlterado = pagamentoDAO.find(pagamento);
        pagamentoDAO.update(pagamentoAlterado.get());
    }
}
