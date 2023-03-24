package com.netbiis.projetoweb.model.usecases.implementations.curso;

import com.netbiis.projetoweb.model.daos.ICursoDAO;
import com.netbiis.projetoweb.model.entity.CursoEntity;
import com.netbiis.projetoweb.model.usecases.IUpdateCursoUseCase;

public class UpdateCursoUseCase implements IUpdateCursoUseCase {

   private final ICursoDAO cursoDAO;

    public UpdateCursoUseCase(ICursoDAO cursoDAO) {
        super();
        this.cursoDAO = cursoDAO;
    }


    @Override
    public void execute(CursoEntity data) {

        cursoDAO.update(data);
    }
}
