package com.netbiis.projetoweb.model.usecases.implementations.curso;

import com.netbiis.projetoweb.model.daos.ICursoDAO;
import com.netbiis.projetoweb.model.entity.CursoEntity;
import com.netbiis.projetoweb.model.usecases.IDeleteCursoUseCase;

public class DeleteCursoUseCase implements IDeleteCursoUseCase {

   private final ICursoDAO cursoDAO;

    public DeleteCursoUseCase(ICursoDAO cursoDAO) {
        super();
        this.cursoDAO = cursoDAO;
    }


    @Override
    public void execute(CursoEntity data) {
        cursoDAO.delete(data);
    }
}
