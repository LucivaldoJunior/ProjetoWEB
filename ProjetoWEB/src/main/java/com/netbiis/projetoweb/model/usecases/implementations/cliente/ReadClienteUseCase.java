package com.netbiis.projetoweb.model.usecases.implementations.cliente;


import com.netbiis.projetoweb.model.daos.IClienteDAO;
import com.netbiis.projetoweb.model.entity.ClienteEntity;
import com.netbiis.projetoweb.model.usecases.IReadClienteUseCase;

import java.util.List;
import java.util.Optional;

public  class ReadClienteUseCase implements IReadClienteUseCase {
    private final IClienteDAO clienteDAO;

    public ReadClienteUseCase(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }


    @Override
    public List<ClienteEntity> executeAll() {

        List<ClienteEntity> cliente = clienteDAO.findAll();

        return cliente;
    }

    @Override
    public Optional<ClienteEntity> executeEsp(String CPF) {

        Optional<ClienteEntity> cliente = clienteDAO.findByCpf(CPF);
        return cliente;
    }
}
