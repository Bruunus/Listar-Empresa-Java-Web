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

	h1,h3{text-align: center;}
	
	div{
/* 		height: 15%; */
		width: 20% ;
		border: 1px solid gray;
		border-radius: 1.5px;
		padding: 10px;
		position: absolute;
	    top: 50%;
	    left: 50%;
	    transform: translate(-50%, -50%);
	}
	
	
	table,tr{
		width:  100%; 
		border-collapse: collapse; 
		border: 0px solid gray;
		
	}
	
/* 	Formatação para as barras */
	.formatB{
		position: relative;
		left: 20px;
	}

	
	.formatP{
		position: relative;
		left: 15px;
		font-weight: bold;
	}
	
	.pSenha{
		position: relative;
		left: 15px;
		top: 5px;
		font-weight: bold;
	}
		
	 
	
	.bt{
		font-size: 15px;
		font-weight: bold;
		height: 50px;
		width: 100%;
		cursor: pointer;
	}
	
	

</style>
<meta charset="ISO-8859-1">
<title>::Login</title>
</head>

<body>
	<h1>Sessão de Autenticação</h1><hr>
	
	<div>
		
		<form action="${ LinkEntradaNovaEmpresa }" method="post">
		<table>
			 <tr><td colspan="2"><h3>Autenticação</h3></td></tr>
			 <tr>
				<td><p class="formatP">Login:</p><p class="pSenha">Senha:</p></td>
				<td>
					<input type="text" name="login"  class="formatB"><br><br>
					<input type="password" name="senha"   class="formatB">
				</td>			 
			 </tr>
			 <tr>
				<td><input type="hidden" name="acao" value="a1__Login"></td>	 
			 </tr>
			 <tr ><td colspan="2"><input type="submit" value="Logar" class="bt"></td></tr>
		</table>
	
		
	</form>
	
	</div>
	
</body>
</html>