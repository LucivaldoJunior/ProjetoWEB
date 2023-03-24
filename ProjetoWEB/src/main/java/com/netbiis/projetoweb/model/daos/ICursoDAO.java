package com.netbiis.projetoweb.model.daos;

import com.netbiis.projetoweb.model.entity.CursoEntity;

import java.util.List;
import java.util.Optional;

public interface ICursoDAO {

    Optional<CursoEntity> find(int cdCurso);
    List<CursoEntity> findAll();

    void create(CursoEntity curso);

    void update(CursoEntity curso);

    void delete(CursoEntity curso);

}
