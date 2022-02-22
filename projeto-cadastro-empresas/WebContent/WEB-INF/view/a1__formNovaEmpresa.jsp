<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="LinkEntradaNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	
	.topo {
		position: absolute;
		right: 20px;
		top: 15px;
	}
	
	.bt {
		width: 150px;
		margin-left: 49px;
	}
	
	.ocultar{
		display: none;	
	}
	
</style>
<meta charset="ISO-8859-1">
<title>::Adicionar Empresa</title>
</head>
<body>

<!-- 	Importanto pedaço de página html -->
	<c:import url="a1__logout.jsp" />

	<form action="${ LinkEntradaNovaEmpresa }" method="post">
		<table>
			<tr>
				<th colspan="2">Cadastro Empresa</th>
			</tr>
			<tr>
				<td class="campoNome">Nome:</td>
				<td><input type="text" name="nome"></td>
				<td class="campoNome">Data Abertura:</td>
				<td><input type="text" name="data"></td>
				<td class="ocultar"><input type="hidden" name="acao" value="a1__NovaEmpresa"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Cadastrar" class="bt">
				</td>
			</tr>
		</table>
	
		
	</form>

</body>
</html>