package com.netbiis.projetoweb.model.usecases.implementations.cliente;

import com.netbiis.projetoweb.model.daos.IClienteDAO;
import com.netbiis.projetoweb.model.entity.ClienteEntity;
import com.netbiis.projetoweb.model.usecases.IDeleteClienteUseCase;

import java.util.Optional;

public class DeleteClienteUseCase implements IDeleteClienteUseCase {
    private final IClienteDAO clienteDAO;

    public DeleteClienteUseCase(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }


    @Override
    public void execute(ClienteEntity data) {
         ClienteEntity cliente = new ClienteEntity();
         Optional<ClienteEntity> clienteByCpf = clienteDAO.findByCpf(data.getCpf());
        if (clienteByCpf.isPresent()){
            data = clienteByCpf.get();
            clienteDAO.delete(data);
        }

    }
}
