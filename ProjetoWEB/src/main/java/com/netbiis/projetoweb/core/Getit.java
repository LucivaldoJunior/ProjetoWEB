package com.netbiis.projetoweb.core;

import com.netbiis.projetoweb.model.daos.IClienteDAO;
import com.netbiis.projetoweb.model.daos.ICursoDAO;
import com.netbiis.projetoweb.model.daos.IpagamentoDAO;
import com.netbiis.projetoweb.model.daos.implementations.ClienteDAO;
import com.netbiis.projetoweb.model.daos.implementations.CursoDAO;
import com.netbiis.projetoweb.model.daos.implementations.PagamentoDAO;
import com.netbiis.projetoweb.model.helper.EntityManagerHelper;
import com.netbiis.projetoweb.model.usecases.*;
import com.netbiis.projetoweb.model.usecases.implementations.cliente.CreateClienteUseCase;
import com.netbiis.projetoweb.model.usecases.implementations.cliente.DeleteClienteUseCase;
import com.netbiis.projetoweb.model.usecases.implementations.cliente.ReadClienteUseCase;
import com.netbiis.projetoweb.model.usecases.implementations.cliente.UpdateClienteUseCase;
import com.netbiis.projetoweb.model.usecases.implementations.curso.CreateCursoUseCase;
import com.netbiis.projetoweb.model.usecases.implementations.curso.DeleteCursoUseCase;
import com.netbiis.projetoweb.model.usecases.implementations.curso.ReadCursoUseCase;
import com.netbiis.projetoweb.model.usecases.implementations.curso.UpdateCursoUseCase;
import com.netbiis.projetoweb.model.usecases.implementations.pagamento.CreatePagamentoUseCase;
import com.netbiis.projetoweb.model.usecases.implementations.pagamento.DeletePagamentoUseCase;
import com.netbiis.projetoweb.model.usecases.implementations.pagamento.ReadPagamentoUseCase;
import com.netbiis.projetoweb.model.usecases.implementations.pagamento.UpdatePagamentoUseCase;
import jakarta.persistence.EntityManager;

public class Getit {
    private static final EntityManager entityManager = EntityManagerHelper.getEntityManager();

    //clientes
    private static final IClienteDAO clienteDAO = new ClienteDAO(entityManager);

    public static final ICreateClienteUseCase createClienteUsecase = new CreateClienteUseCase(clienteDAO);
    public  static final IUpdateClienteUseCase updateClienteUsecase = new UpdateClienteUseCase(clienteDAO);

    public static final IDeleteClienteUseCase deleteClienteUsecase = new DeleteClienteUseCase(clienteDAO);

    public static final IReadClienteUseCase readClienteUsecase = new ReadClienteUseCase(clienteDAO);

    //cursos
    private static final ICursoDAO cursoDAO = new CursoDAO(entityManager);

    public static final ICreateCursoUseCase createCursoUsecase = new CreateCursoUseCase(cursoDAO);

    public static final IUpdateCursoUseCase updateCursoUsecase = new UpdateCursoUseCase(cursoDAO);

    public static final IDeleteCursoUseCase deleteCursoUsecase = new DeleteCursoUseCase(cursoDAO);

    public  static final IReadCursoUseCase readCursoUsecase = new ReadCursoUseCase(cursoDAO);

    //Pagamento

    private  static final IpagamentoDAO pagamentoDAO = new PagamentoDAO(entityManager);

    public static final ICreatePagamentoUseCase createPagamentoUsecase = new CreatePagamentoUseCase(pagamentoDAO);

    public static final IUpdatePagamentoUseCase updatePagamentoUsecase = new UpdatePagamentoUseCase(pagamentoDAO);

    public static final IDeletePagamentoUseCase deletePagamentoUsecase = new DeletePagamentoUseCase(pagamentoDAO);

    public static final IReadPagamentoUseCase readPagamentoUsecase = new ReadPagamentoUseCase(pagamentoDAO);


}
