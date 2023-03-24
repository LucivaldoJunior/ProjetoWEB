package com.netbiis.projetoweb.model.usecases.implementations.pagamento;

import com.netbiis.projetoweb.model.daos.IpagamentoDAO;
import com.netbiis.projetoweb.model.entity.PagamentoEntity;
import com.netbiis.projetoweb.model.usecases.IDeletePagamentoUseCase;

import java.util.Optional;

public class DeletePagamentoUseCase implements IDeletePagamentoUseCase {

    private final IpagamentoDAO pagamentoDAO;

    public DeletePagamentoUseCase(IpagamentoDAO pagamentoDAO) {
        super();
        this.pagamentoDAO = pagamentoDAO;
    }
    @Override
    public void execute(PagamentoEntity pagamento) {
        Optional<PagamentoEntity> pagdeletado = pagamentoDAO.find(pagamento);
        pagamentoDAO.delete(pagdeletado.get());
    }
}
