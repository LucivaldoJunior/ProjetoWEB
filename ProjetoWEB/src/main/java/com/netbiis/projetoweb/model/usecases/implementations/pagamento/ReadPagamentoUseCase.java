package com.netbiis.projetoweb.model.usecases.implementations.pagamento;

import com.netbiis.projetoweb.model.daos.IpagamentoDAO;
import com.netbiis.projetoweb.model.entity.PagamentoEntity;
import com.netbiis.projetoweb.model.usecases.IReadPagamentoUseCase;

import java.util.List;
import java.util.Optional;

public class ReadPagamentoUseCase implements IReadPagamentoUseCase {

    private final IpagamentoDAO pagamentoDAO;

    public ReadPagamentoUseCase(IpagamentoDAO pagamentoDAO) {
        this.pagamentoDAO = pagamentoDAO;
    }

    @Override
    public List<PagamentoEntity> executeAll() {
        List<PagamentoEntity> pagamentos = pagamentoDAO.findAll();
        return pagamentos;
    }

    @Override
    public Optional<PagamentoEntity> executeesp(PagamentoEntity pagamento) {
        Optional<PagamentoEntity> pagamentoachado = pagamentoDAO.find(pagamento);
        return pagamentoachado;
    }
}
