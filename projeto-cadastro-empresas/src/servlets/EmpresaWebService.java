package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import Model.a1__Banco;
import Model.a1__Empresa;


@WebServlet("/empresa")
public class EmpresaWebService extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String valorCabecalhoHttp = request.getHeader("Accept");
		
		
		if (valorCabecalhoHttp.contains("xml")) {
						
			
			List<a1__Empresa> empresas = new a1__Banco().getEmpresas();  	// puxando as listas de empresas...
						
			XStream xstream = new XStream(); 					// invocando biblioteca JSON do Google...
			xstream.alias("empresa", a1__Empresa.class); 		// melhorar a descrição das tags do xml...
			String xml = xstream.toXML(empresas);
						
			response.setContentType("application/xml");  		// informando do HTTP o tipo de retorno (JSON)			
			
			response.getWriter().print(xml);   				// acionando o gravador 
			
			
			
			
		} else if(valorCabecalhoHttp.contains("json")) {
						
			List<a1__Empresa> empresas = new a1__Banco().getEmpresas();			// puxando as listas de empresas...
			
			Gson gson = new Gson();												// invocando biblioteca JSON do Google...
			String json = gson.toJson(empresas);
			
			response.setContentType("application/json");						// informando do HTTP o tipo de retorno (JSON)
			
			response.getWriter().print(json);									// acionando o gravador 
			
		} else {
			response.setContentType("application/json");
			response.getWriter().print("{'message':'Requisição não encontrada'}");
			
		}
		
	}

}
