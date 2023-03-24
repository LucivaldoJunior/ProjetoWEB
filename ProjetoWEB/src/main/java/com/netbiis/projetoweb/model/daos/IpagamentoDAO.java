package com.netbiis.projetoweb.model.daos;


import com.netbiis.projetoweb.model.entity.PagamentoEntity;

import java.util.List;
import java.util.Optional;

public interface IpagamentoDAO {

    Optional<PagamentoEntity> find(PagamentoEntity pagamento);

    List<PagamentoEntity> findAll();

    void create(PagamentoEntity pagamento);


    void update(PagamentoEntity pagamento);

    void delete(PagamentoEntity pagamento);
}
