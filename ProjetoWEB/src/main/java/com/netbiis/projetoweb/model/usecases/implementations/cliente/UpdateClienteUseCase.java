package com.netbiis.projetoweb.model.usecases.implementations.cliente;

import com.netbiis.projetoweb.model.daos.IClienteDAO;
import com.netbiis.projetoweb.model.entity.ClienteEntity;
import com.netbiis.projetoweb.model.usecases.IUpdateClienteUseCase;

import java.util.Optional;

public class UpdateClienteUseCase implements IUpdateClienteUseCase {
    private final IClienteDAO clienteDAO;

    public UpdateClienteUseCase(IClienteDAO clienteDAO){
        super();
        this.clienteDAO = clienteDAO;
    }
    @Override
    public void execute(ClienteEntity data) throws IllegalArgumentException {

        Optional<ClienteEntity> clienteByCpf = clienteDAO.findByCpf(data.getCpf());
        if (clienteByCpf.isPresent()){
            data.setIdCliente(clienteByCpf.get().getIdCliente());
            clienteDAO.update(data);
        }



    }
}
