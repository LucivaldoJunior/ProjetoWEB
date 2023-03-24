package com.netbiis.projetoweb.model.usecases;

import com.netbiis.projetoweb.model.entity.ClienteEntity;

public interface ICreateClienteUseCase {
    void execute(ClienteEntity data);
}
