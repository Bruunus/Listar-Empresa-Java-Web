package Controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class a1__AutorizacaoFilter___Filter_II implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

		System.out.println("Filtro de Segurança rodando...");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse 	response = (HttpServletResponse) servletResponse;
		
		String acao = request.getParameter("acao");
		
		
		HttpSession session = request.getSession();
		boolean usuarioNaoEstaLogado = (session.getAttribute("usuarioLogado") == null);
		boolean heUmaAcaoProtegida = !(acao.equals("a1__Login") || acao.equals("a1__LoginForm"));
		
		if(heUmaAcaoProtegida && usuarioNaoEstaLogado) {
			response.sendRedirect("entrada?acao=a1__LoginForm");
			return;
		}
		
		chain.doFilter(request, response);
	}


}
