package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Acoes.Acao;


public class a1__PrincipalServlet___Filter_I extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String acao = request.getParameter("acao");	
				
		String nome = null;
		
		String rastrearNomeDaClasse = "Acoes." + acao;
		
		
		try {
			Class classe = Class.forName(rastrearNomeDaClasse);
			Acao acaoInterface = (Acao) classe.newInstance();
			nome = acaoInterface.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}
		
		
		
        String[] tipoEEndereco = nome.split(":");
        if (tipoEEndereco[0].equals("forward")) {
        	RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
            rd.forward(request, response);
		}else {
			response.sendRedirect(tipoEEndereco[1]);
		}
        


	}
	

}
