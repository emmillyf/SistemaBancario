package br.com.poo.g3.entities;

public class Presidente extends Funcionario {

	private String senha;

	public boolean autentica(String senha) {
		if (this.senha == senha) {
			System.out.println("Acesso Permitido!");
			return true;
		} else {
			System.out.println("Acesso Negado!");
			return false;
		}
	}
	// construtor default

	public Presidente() {
		super();

	}

	// construtor parametrizado

	public Presidente(Integer id, String nome, String cpf, Double salario, String senha) {
		super(id, nome, cpf, salario, senha);
		this.senha = senha;
	}

	// getters e setters

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Presidente \nsenha: " + senha + "\n";
	}
}