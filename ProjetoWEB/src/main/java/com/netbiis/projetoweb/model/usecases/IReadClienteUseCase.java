package com.netbiis.projetoweb.model.usecases;

import com.netbiis.projetoweb.model.entity.ClienteEntity;

import java.util.List;
import java.util.Optional;

public interface IReadClienteUseCase {

   List<ClienteEntity>executeAll();

   Optional<ClienteEntity> executeEsp(String cpf);
}
