package Acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.a1__Banco;
import Model.a1__Empresa;

public class a1__MostraEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		
		
		a1__Banco banco = new a1__Banco();		
		
		a1__Empresa empresa = banco.buscaEmpresaPelaId(id);
		
		System.out.println(empresa.getNome());

		
		request.setAttribute("empresa", empresa);
		
		return "forward:a1__formAlteraEmpresa.jsp";
		
	}

}
