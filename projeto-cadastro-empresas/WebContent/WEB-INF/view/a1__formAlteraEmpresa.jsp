<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:url value="/entrada" var="AlteraEmpresaServlet"/>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">

	.topo{
		position: absolute;
		right: 20px;
		top: 15px;
	}
	
</style>
<meta charset="ISO-8859-1">
<title>::Altera Empresa</title>
</head>
<body>

	<c:import url="a1__logout.jsp" />


	<form action="${ AlteraEmpresaServlet }" method="post">
	
		Nome: <input type="text" name="nome" value="${empresa.nome }" />
		Data Abertura: <input type="text" name="data"  value="<fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/>" />
		<input type="hidden" name="id" value="${empresa.id }">
		<td class="ocultar"><input type="hidden" name="acao" value="a1__AlteraEmpresa"></td>
		<input type="submit" />
	</form>

</body>
</html>