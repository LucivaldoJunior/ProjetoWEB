package com.netbiis.projetoweb.controller.controlador;

import com.netbiis.projetoweb.model.entity.ClienteEntity;
import com.netbiis.projetoweb.model.entity.CursoEntity;
import com.netbiis.projetoweb.model.entity.PagamentoEntity;
import jakarta.servlet.ServletException;
import com.netbiis.projetoweb.core.Getit;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

/**
 * Servlet implementation class Controlador
 */
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req,resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		//criar variaveis
		int idformulario; // 1-cliente 2-curso 3-pagamentos
		int tipoformulario; //1.1 consultar ...
		String cpf,nome,email;
		int cdcurso,valorcurso;
		String nomecurso,url;
		String datainscricao;

		idformulario = Integer.parseInt(request.getParameter("idformulario"));
		tipoformulario =Integer.parseInt(request.getParameter("tipoformulario"));
		
		if(idformulario ==1) { //cliente
			switch(tipoformulario) {
			case 11:
			{
				List<ClienteEntity>clientes = Getit.readClienteUsecase.executeAll();
				session.setAttribute("mensagem", "Totald de Clientes: " + clientes.size() );
				session.setAttribute("clientes", clientes);
				response.sendRedirect("clientes/consultaTodos.jsp");
				break;
			}case 12:
			{

				cpf = request.getParameter("cpf").toString();
				Optional<ClienteEntity> cliente= Getit.readClienteUsecase.executeEsp(cpf);
				ClienteEntity cli = cliente.get();
				if(cliente.isPresent()) {
					session.setAttribute("mensagem", "Cliente " + cli.getCpf() + " Encontrado");
					session.setAttribute("cliente", cli);
				}else{
					session.setAttribute("mensagem", "Cliente " + cli.getCpf() + " não Encontrado");
					session.setAttribute("cliente", cli);
				}
				response.sendRedirect("clientes/resultado.jsp");


				break;
			}case 13:
			{
				email = request.getParameter("email").toString();
				nome = request.getParameter("nome").toString();
				cpf = request.getParameter("cpf").toString();
				ClienteEntity cliente = new ClienteEntity();
				cliente.setNome(nome);
				cliente.setCpf(cpf);
				cliente.setEmail(email);
				Getit.createClienteUsecase.execute(cliente);
				session.setAttribute("mensagem", "Cliente " + cliente.getCpf() + " cadastrado");
				session.setAttribute("cliente", cliente);
				response.sendRedirect("clientes/resultado.jsp");
				break;
			}case 14:
			{
				email = request.getParameter("email").toString();
				nome = request.getParameter("nome").toString();
				cpf = request.getParameter("cpf").toString();
				ClienteEntity cliente = new ClienteEntity();
				cliente.setNome(nome);
				cliente.setCpf(cpf);
				cliente.setEmail(email);
				Getit.updateClienteUsecase.execute(cliente);
				session.setAttribute("mensagem", "Cliente " + cliente.getCpf() + " Alterado");
				session.setAttribute("cliente", cliente);
				response.sendRedirect("clientes/resultado.jsp");
				break;
			}case 15:
			{
				cpf = request.getParameter("cpf").toString();
				ClienteEntity cliente = new ClienteEntity();
				cliente.setCpf(cpf);
				Getit.deleteClienteUsecase.execute(cliente);
				session.setAttribute("mensagem", "Cliente " + cliente.getCpf() + " Deletado");
				session.setAttribute("cliente", cliente);
				response.sendRedirect("clientes/resultado.jsp");
				break;
			}
			}

		} else if(idformulario==2) { //cursos
			switch(tipoformulario) {
			
			case 21:
			{
				List<CursoEntity> cursos = Getit.readCursoUsecase.executeAll();
				session.setAttribute("mensagem", "Total de Cursos: " + cursos.size());
				session.setAttribute("cursos", cursos);
				response.sendRedirect("cursos/consultaTodos.jsp");
				break;
				
			}case 22:
			{
				cdcurso = Integer.parseInt(request.getParameter("cdcurso"));

				Optional<CursoEntity> curso = Getit.readCursoUsecase.executeesp(cdcurso);
				CursoEntity curso2 = curso.get();
				if(curso.isPresent()) {
					session.setAttribute("mensagem", "Curso " + curso2.getNome() + " Encontrado");
					session.setAttribute("curso", curso2);
				}else{
					session.setAttribute("mensagem", "Curso " + curso2.getNome() + " Não Encontrado");
					session.setAttribute("curso", curso2);
				}
				response.sendRedirect("cursos/resultado.jsp");
				break;
				
			}case 23:
			{
				cdcurso = Integer.parseInt(request.getParameter("cdcurso"));
				nomecurso = request.getParameter("nome");
				valorcurso = Integer.parseInt(request.getParameter("valor"));
				url = request.getParameter("site");
				CursoEntity curso = new CursoEntity();
				curso.setCdCurso(cdcurso);
				curso.setNome(nomecurso);
				curso.setUrl(url);
				curso.setValor(valorcurso);
				Getit.createCursoUsecase.execute(curso);
				session.setAttribute("mensagem", "Curso " + curso.getNome() + " cadastrado");
				session.setAttribute("curso", curso);
				response.sendRedirect("cursos/resultado.jsp");
				break;
			}case 24:
			{
				cdcurso = Integer.parseInt(request.getParameter("cdcurso"));
				nomecurso = request.getParameter("nome");
				valorcurso =  Integer.parseInt(request.getParameter("valor"));
				url = request.getParameter("site");

				CursoEntity curso = new CursoEntity();
				curso.setCdCurso(cdcurso);
				curso.setNome(nomecurso);
				curso.setUrl(url);
				curso.setValor(valorcurso);
				Getit.updateCursoUsecase.execute(curso);
				session.setAttribute("mensagem", "Curso " + curso.getNome() + " alterado");
				session.setAttribute("curso", curso);
				response.sendRedirect("cursos/resultado.jsp");
				break;
			}case 25:{
				cdcurso = Integer.parseInt(request.getParameter("cdcurso").toString());
				CursoEntity curso = new CursoEntity();
				curso.setCdCurso(cdcurso);
				Getit.deleteCursoUsecase.execute(curso);
				session.setAttribute("mensagem", "Curso " + curso.getNome() + " deletado");
				session.setAttribute("curso", curso);
				response.sendRedirect("cursos/resultado.jsp");
				break;
			}
			}
			
		}else if(idformulario==3) { //pagamentos
switch(tipoformulario) {
			
			case 31:
			{
				List<PagamentoEntity> pagamentos= Getit.readPagamentoUsecase.executeAll();
				session.setAttribute("mensagem", "Total de pagamentos: " + pagamentos.size());
				session.setAttribute("pagamentos", pagamentos);
				response.sendRedirect("pagamentos/consultaTodos.jsp");
				break;
				
			}case 32:
			{
				cpf = request.getParameter("cpf").toString();
				cdcurso = Integer.parseInt(request.getParameter("cdcurso"));

				Optional<ClienteEntity> cliente = Getit.readClienteUsecase.executeEsp(cpf);
				Optional<CursoEntity> curso = Getit.readCursoUsecase.executeesp(cdcurso);
				PagamentoEntity pagamento = new PagamentoEntity();
				pagamento.setClienteByClienteId(cliente.get());
				pagamento.setCursoByCursoId(curso.get());
				Optional<PagamentoEntity> pagamentoac = Getit.readPagamentoUsecase.executeesp(pagamento);
				PagamentoEntity pag2 = pagamentoac.get();
				session.setAttribute("mensagem", "pagamento  Encontrado");
				session.setAttribute("pagamento", pag2);
				response.sendRedirect("pagamentos/resultado.jsp");
				break;
				
			}case 33:
			{
				//funcionando
				cpf = request.getParameter("cpf").toString();
				cdcurso = Integer.parseInt(request.getParameter("cdcurso"));
				datainscricao = request.getParameter("datainscricao");
				//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				//LocalDate date = LocalDate.parse(datainscricao,formatter);
				//DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");



				Optional<ClienteEntity> cliente = Getit.readClienteUsecase.executeEsp(cpf);
				Optional<CursoEntity> curso = Getit.readCursoUsecase.executeesp(cdcurso);
				PagamentoEntity pagamento = new PagamentoEntity();
				pagamento.setClienteByClienteId(cliente.get());
				pagamento.setCursoByCursoId(curso.get());
				pagamento.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));

				Getit.createPagamentoUsecase.execute(pagamento);
				session.setAttribute("mensagem", "pagamento Cadastrado ");
				session.setAttribute("pagamento", pagamento);
				response.sendRedirect("pagamentos/resultado.jsp");
				break;
			}case 34:
			{
				cpf = request.getParameter("cpf").toString();
				cdcurso = Integer.parseInt(request.getParameter("cdcurso"));
				datainscricao = request.getParameter("datainscricao");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate date = LocalDate.parse(datainscricao,formatter);
				DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

				Optional<ClienteEntity> cliente = Getit.readClienteUsecase.executeEsp(cpf);
				Optional<CursoEntity> curso = Getit.readCursoUsecase.executeesp(cdcurso);
				PagamentoEntity pagamento = new PagamentoEntity();
				pagamento.setClienteByClienteId(cliente.get());
				pagamento.setCursoByCursoId(curso.get());
				pagamento.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
				Getit.updatePagamentoUsecase.execute(pagamento);
				session.setAttribute("mensagem", "pagamento alterado ");
				session.setAttribute("pagamento", pagamento);
				response.sendRedirect("pagamentos/resultado.jsp");


				break;
			}case 35:{
				cpf = request.getParameter("cpf").toString();
				cdcurso = Integer.parseInt(request.getParameter("cdcurso"));
				Optional<ClienteEntity> cliente = Getit.readClienteUsecase.executeEsp(cpf);
				Optional<CursoEntity> curso = Getit.readCursoUsecase.executeesp(cdcurso);
				PagamentoEntity pagamento = new PagamentoEntity();
				pagamento.setClienteByClienteId(cliente.get());
				pagamento.setCursoByCursoId(curso.get());
				Getit.deletePagamentoUsecase.execute(pagamento);
				session.setAttribute("mensagem", "pagamento Excluido ");
				session.setAttribute("pagamento", pagamento);
				response.sendRedirect("pagamentos/resultado.jsp");

				break;
			}
			}
		}
	}

}
