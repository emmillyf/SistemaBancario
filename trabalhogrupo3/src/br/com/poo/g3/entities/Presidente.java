package br.com.poo.g3.entities;

public class Presidente extends Funcionario {

	private int senha;

	public boolean autentica(int senha) {

		if (this.senha == senha) {
			System.out.println("Acesso Permitido!");
			return true;
		} else {
			System.out.println("Acesso Negado!");
		}
	}

	// construtor default
	
	public Presidente() {
		super();

	}

	public Presidente(String nome, String cpf, double salario) {
		super(nome, cpf, salario);
		
	}
	// construtor parametrizado

	public Presidente(int senha) {
		super();
		this.senha = senha;
	}
	
	// getters e setters
	
	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Presidente \nsenha: " + senha + "\n";
	}
}