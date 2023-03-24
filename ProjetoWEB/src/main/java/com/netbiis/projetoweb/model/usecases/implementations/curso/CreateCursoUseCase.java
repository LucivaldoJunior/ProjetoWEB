package com.netbiis.projetoweb.model.usecases.implementations.curso;

import com.netbiis.projetoweb.model.daos.ICursoDAO;
import com.netbiis.projetoweb.model.entity.CursoEntity;
import com.netbiis.projetoweb.model.usecases.ICreateCursoUseCase;

public class CreateCursoUseCase implements ICreateCursoUseCase {

   private final ICursoDAO cursoDAO;

    public CreateCursoUseCase(ICursoDAO cursoDAO) {
        super();
        this.cursoDAO = cursoDAO;
    }


    @Override
    public void execute(CursoEntity data) {

        cursoDAO.create(data);
    }
}
