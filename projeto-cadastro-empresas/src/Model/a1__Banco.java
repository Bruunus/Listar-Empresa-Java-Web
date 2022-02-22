package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class a1__Banco {
	
	private static List<a1__Empresa> lista = new ArrayList<>();
	private static List<a1__Usuario> listaUsuarios = new ArrayList<>();
	
	
	private static Integer chaveSequencial = 1;
	
	
	static {
		
		a1__Empresa empresa = new a1__Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Alura");
		
		a1__Empresa empresa2 = new a1__Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Caelum");
		
		lista.add(empresa);
		lista.add(empresa2);
		
		
		a1__Usuario u1 = new a1__Usuario();
		u1.setLogin("@brunus");
		u1.setSenha("@brunus");
		
		a1__Usuario u2 = new a1__Usuario();
		u2.setLogin("@paola");
		u2.setSenha("@paola");
		
		listaUsuarios.add(u1);
		listaUsuarios.add(u2);
		
	}

	
	public void adiciona(a1__Empresa empresa) {
		empresa.setId(a1__Banco.chaveSequencial++);
		a1__Banco.lista.add(empresa);
	}
	
	
	public List<a1__Empresa> getEmpresas(){
		return a1__Banco.lista;
	}

	
	public void removeEmpresa(Integer id) {
		
		Iterator<a1__Empresa> it = lista.iterator();
		
		while(it.hasNext()) {
			a1__Empresa emp = it.next();
			
			if(emp.getId() == id) {
				it.remove();
			}
		}
	}

	
	public a1__Empresa buscaEmpresaPelaId(Integer id) {
		for (a1__Empresa empresa : lista) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	

	public a1__Usuario existeUsuario(String login, String senha) {

		for(a1__Usuario usuario : listaUsuarios) {
			
			if (usuario.ehIgual(login, senha)) {
				return usuario;
			}
			
		}

		return null;
	}
	

}
