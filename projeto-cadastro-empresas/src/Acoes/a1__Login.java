package Acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.a1__Banco;
import Model.a1__Usuario;

public class a1__Login implements Acao {
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		
		System.out.println("Logado: " + login);
		
		
		a1__Banco banco = new a1__Banco();
		a1__Usuario usuario = banco.existeUsuario(login, senha);
		
		
		if (usuario != null) {
			System.out.println("Usuário Existe!");
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", usuario);
			return "redirect:entrada?acao=a1__NovaEmpresaForm";
			
		}else {
			
			return "redirect:entrada?acao=a1__LoginForm";
			
		}
		
		
		
	}

}
