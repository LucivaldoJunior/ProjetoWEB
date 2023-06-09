<jsp:include page="util/topo.jsp"/>
<html><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}lib/js/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/lib/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/lib/css/bootstrap.css" rel="stylesheet" type="text/css">
     <link href="${pageContext.request.contextPath}/lib/css/padrao.css" rel="stylesheet" type="text/css">
  
  </head><body>
    <div class="section section-danger text-justify">
      <div class="container">
        <div class="row text-center">
          <div class="col-md-12 text-center">
            <h1 class="text-center">Sistema de Gerenciamento de Cursos</h1>
          </div>
        </div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12 text-center">
            <div class="col-md-12  btn-group btn-group-lg btn-group-vertical">
              <a href="${pageContext.request.contextPath}/clientes/index.jsp" class="btn btn-default">CLIENTES</a>
              <a href="${pageContext.request.contextPath}/cursos/index.jsp" class="btn btn-default">CURSOS</a>
              <a href="${pageContext.request.contextPath}/pagamentos/index.jsp" class="btn btn-default">PAGAMENTOS</a>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12 text-center">
            	<a class="btn btn-default" href="${pageContext.request.contextPath}/logout.jsp">Sair</a>
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