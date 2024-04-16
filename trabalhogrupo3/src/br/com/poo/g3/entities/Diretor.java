package br.com.poo.g3.entities;

public class Diretor extends Funcionario {

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

	public Diretor() {
		super();

	}

	// construtor parametrizado

	public Diretor(Integer id, String nome, String cpf, Double salario, String senha) {
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
		return "Diretor \nsenha: " + senha + "\n";
	}
}