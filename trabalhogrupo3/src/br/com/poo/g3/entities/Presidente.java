package br.com.poo.g3.entities;

public class Presidente extends Funcionario {

	private int senha;

	public boolean autentica(Integer senha) {
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

	public Presidente(Integer id, String nome, String cpf, Double salario, int senha) {
		super(id, nome, cpf, salario);
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