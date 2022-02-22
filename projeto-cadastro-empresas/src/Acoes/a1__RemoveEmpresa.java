package Acoes;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.a1__Banco;

public class a1__RemoveEmpresa implements Acao {

	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {

		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		System.out.println(id);
		
		a1__Banco banco = new a1__Banco();
		banco.removeEmpresa(id);
		
	
		return "redirect:entrada?acao=a1__ListaEmpresa";
		
	}
	
	

}
