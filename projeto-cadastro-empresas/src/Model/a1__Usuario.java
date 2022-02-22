package Model;


public class a1__Usuario {
	
	
	private String login;
	private String senha;
	


	public String getLogin() {
		return login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	public boolean ehIgual(String login, String senha) {
		
		if (!this.login.equals(login)) {
			return false;
		}
		
		if (!this.senha.equals(senha)) {
			return false;
		}
		
		return true;
	}
	
	

}
