package Acoes;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.a1__Banco;
import Model.a1__Empresa;

public class a1__ListaEmpresa implements Acao{
	
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		System.out.println("Listando Empresas");

		a1__Banco banco = new a1__Banco();
        List<a1__Empresa> lista = banco.getEmpresas();

        
        request.setAttribute("empresas", lista);

        return "forward:a1__listaEmpresas.jsp";
        
    }
	
	
	
	
	

}
