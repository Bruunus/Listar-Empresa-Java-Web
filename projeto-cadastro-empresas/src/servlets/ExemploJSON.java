package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Model.a1__Banco;
import Model.a1__Empresa;


@WebServlet("/empresaJSON")
public class ExemploJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// puxando as listas de empresas...
		List<a1__Empresa> empresas = new a1__Banco().getEmpresas();
		
		// invocando biblioteca JSON do Google...
		Gson gson = new Gson();
		String json = gson.toJson(empresas);
		
		
		// informando do HTTP o tipo de retorno (JSON)
		response.setContentType("application/json");
		
		// acionando o gravador 
		response.getWriter().print(json);
		
	}

}
