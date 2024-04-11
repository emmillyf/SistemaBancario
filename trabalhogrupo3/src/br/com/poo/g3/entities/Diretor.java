package br.com.poo.g3.entities;

public class Diretor extends Funcionario {

	private Integer senha;

	// construtor default

	public Diretor() {
		super();

	}

	public Diretor(String nome, String cpf, Double salario) {
		super();

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