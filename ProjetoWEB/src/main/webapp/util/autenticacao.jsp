<jsp:directive.page import="java.sql.*"/>
<jsp:declaration>

static String url = "jdbc:mysql://localhost:3306/formacaojava";
static String usuario = "root";
static String senha = "xxrickyxd";
static Connection conexao; 

public void init() throws ServletException {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conexao = DriverManager.getConnection(url, usuario, senha);
		conexao.setAutoCommit(false);
	} catch (SQLException | ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
</jsp:declaration>
<jsp:scriptlet>
String cpf = request.getParameter("cpf");
String senha = request.getParameter("senha");
String consulta = "SELECT * FROM login where cpf='" + cpf + "' and senha='" + senha + "'";
Statement statement;

try {

	statement = conexao.createStatement();
	ResultSet rs = statement.executeQuery(consulta);
	if (rs.next()) { //usuario autenticado
		session.setAttribute("mensagem", "Usuario Autenticado");
		session.setAttribute("login", "true");
		response.sendRedirect("../index.jsp");
	} else {
		session.setAttribute("mensagem", "Usuario Não Autenticado. Favor informar outro CPF e Senha !");
		session.setAttribute("login", "false");
		response.sendRedirect("../login.jsp");
	}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}</jsp:scriptlet>