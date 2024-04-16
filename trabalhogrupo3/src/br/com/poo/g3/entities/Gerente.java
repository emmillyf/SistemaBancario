package br.com.poo.g3.entities;

public class Gerente extends Funcionario {

	private String senha;
	private Integer numeroDeFuncionarios;

	public boolean autentica(String senha) {
		if (this.senha == senha) {
			System.out.println("Acesso Permitido!");
			return true;
		} else {
			System.out.println("Acesso Negado!");
			return false;
		}
	}

	// construtores default

	public Gerente() {
		super();

	}

	// construtor parametrizado
	
	public Gerente(Integer id, String nome, String cpf, Double salario, String senha, Integer numeroDeFuncionarios) {
		super(id, nome, cpf, salario, senha);
		this.senha = senha;
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}

	// getters e setters

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getNumeroDeFuncionarios() {
		return numeroDeFuncionarios;
	}

	public void setNumeroDeFuncionarios(Integer numeroDeFuncionarios) {
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}

	// método toString

	@Override
	public String toString() {
		return "Gerente \nsenha: " + senha + "\nnumeroDeFuncionarios: " + numeroDeFuncionarios + "\n";
	}

}