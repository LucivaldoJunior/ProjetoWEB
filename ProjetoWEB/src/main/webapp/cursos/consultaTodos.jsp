<%--
  Created by IntelliJ IDEA.
  User: Junior
  Date: 24/11/2022
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../util/topo.jsp"/>
<html><head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script type="text/javascript" src="${pageContext.request.contextPath}/lib/js/jquery.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}lib/js/bootstrap.min.js"></script>
  <link href="${pageContext.request.contextPath}/lib/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/lib/css/bootstrap.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/lib/css/padrao.css" rel="stylesheet" type="text/css">
  <title>Página Consultar Todos os Clientes</title>
</head><body>
<div class="section section-danger text-justify">
  <div class="container">
    <div class="row text-center">
      <div class="col-md-12 text-center">
        <h1 class="text-center">${mensagem}</h1>
        <table align="center" border="1">
          <tr>
            <th>CD</th>
            <th>NOME</th>
            <th>VALOR</th>
            <th>URL</th>
          </tr>
          <c:forEach var="row" items="${cursos}">
            <tr>
              <td><c:out value="${row.cdCurso}"/></td>
              <td><c:out value="${row.nome}"/></td>
              <td><c:out value="${row.valor}"/></td>
              <td><c:out value="${row.url}"/></td>
            </tr>
          </c:forEach>
        </table>
      </div>
    </div>
  </div>
</div>

<div class="section">
  <div class="container">
    <div class="row">
      <div class="col-md-12 text-center">
        <a class="btn btn-default" href="javascript:window.history.go(-1)">Voltar</a>
      </div>
    </div>
  </div>
</div>
<footer>
  <div class="navbar navbar-fixed-bottom bgred">
    <div class="container">
      <div class="row">
        <div class="col-sm-12 text-center" style="top:13px;color:#fff;">© ABCTreinamentos - Curso de Java 8 para Web</div>
      </div>
    </div>
  </div>
</footer>


</body></html>
