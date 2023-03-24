package com.netbiis.projetoweb.model.usecases;

import com.netbiis.projetoweb.model.entity.CursoEntity;

import java.util.List;
import java.util.Optional;

public interface IReadCursoUseCase {
    List<CursoEntity> executeAll();
    Optional<CursoEntity> executeesp(int cdCurso);
}
