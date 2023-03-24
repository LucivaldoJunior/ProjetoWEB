package com.netbiis.projetoweb.model.usecases;

import com.netbiis.projetoweb.model.entity.ClienteEntity;

public interface IDeleteClienteUseCase {
    void execute(ClienteEntity data);
}
