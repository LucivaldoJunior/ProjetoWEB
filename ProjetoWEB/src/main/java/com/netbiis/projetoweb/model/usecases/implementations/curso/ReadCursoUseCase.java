package com.netbiis.projetoweb.model.usecases.implementations.curso;

import com.netbiis.projetoweb.model.daos.ICursoDAO;
import com.netbiis.projetoweb.model.entity.CursoEntity;
import com.netbiis.projetoweb.model.usecases.IReadCursoUseCase;

import java.util.List;
import java.util.Optional;

public class ReadCursoUseCase implements IReadCursoUseCase {
    private final ICursoDAO cursoDAO;

    public ReadCursoUseCase(ICursoDAO cursoDAO) {
        this.cursoDAO = cursoDAO;
    }


    @Override
    public List<CursoEntity> executeAll() {
        List<CursoEntity> cursos = cursoDAO.findAll();
        return cursos;
    }

    @Override
    public Optional<CursoEntity> executeesp(int cdCurso) {
        Optional<CursoEntity> curso = cursoDAO.find(cdCurso);
        return curso;
    }
}
