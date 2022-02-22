package Controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Acoes.Acao;


public class a1__ControladorFilterPrincipal__Filter_I implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}


	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

		System.out.println("Executando Filtro Controlador Principal");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
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
