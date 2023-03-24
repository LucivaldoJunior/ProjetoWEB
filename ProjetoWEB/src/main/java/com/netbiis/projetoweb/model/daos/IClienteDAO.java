package com.netbiis.projetoweb.model.daos;

import com.netbiis.projetoweb.model.entity.ClienteEntity;

import java.util.List;
import java.util.Optional;

public interface IClienteDAO {
    Optional<ClienteEntity> findByCpf(String cpf);

    List<ClienteEntity> findAll();
    void update(ClienteEntity cliente);

    void create(ClienteEntity cliente);

    void delete(ClienteEntity cliente);

}
