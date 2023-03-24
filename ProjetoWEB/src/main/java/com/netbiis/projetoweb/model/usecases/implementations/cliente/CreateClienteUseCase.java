package com.netbiis.projetoweb.model.usecases.implementations.cliente;

import com.netbiis.projetoweb.model.daos.IClienteDAO;
import com.netbiis.projetoweb.model.entity.ClienteEntity;
import com.netbiis.projetoweb.model.usecases.ICreateClienteUseCase;

import java.util.Optional;

public class CreateClienteUseCase implements ICreateClienteUseCase {

    private final IClienteDAO clienteDAO;

    public CreateClienteUseCase(IClienteDAO clienteDAO) {
        super();
        this.clienteDAO = clienteDAO;
    }
    @Override
    public void execute(ClienteEntity data) {
            Optional<ClienteEntity> clienteByCpf = clienteDAO.findByCpf(data.getCpf());

            if(clienteByCpf.isPresent())
                throw new IllegalArgumentException("CPF: Já existe um cadastro com este CPF!");


            clienteDAO.create(data);

    }
}
