package br.com.poo.g3.entities;

public class Diretor extends Funcionario {

	private Integer  senha;

	public boolean autentica(Integer senha) {

		if (this.senha == senha) {
			System.out.println("Acesso Permitido!");
			return true;
		} else {
			System.out.println("Acesso Negado!");
		}
	}

	// construtor default

	public Diretor() {
		super();

	}

	public Diretor(String nome, String cpf, double salario) {
		super(nome, cpf, salario);

	}

	// construtor parametrizado

	public Diretor(Integer senha) {
		super();
		this.senha = senha;
	}

	// getters e setters

	public int getSenha() {
		return senha;
	}

	public void setSenha(Integer senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Diretor \nsenha: " + senha + "\n";
	}
}