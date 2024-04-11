package br.com.poo.g3.entities;

public class Gerente extends Funcionario{
	
	private Integer senha;
	private Integer numeroDeFuncionarios;
	
	// construtores default
	
	public Gerente() {
		super();
		
	}

	public Gerente(String nome, String cpf, double salario) {
		super();
	
	}

	
	// construtor parametrizado
	
	public Gerente(Integer  senha, Integer  numeroDeFuncionarios) {
		super();
		this.senha = senha;
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}
	
	// getters e setters
	
	public int getSenha() {
		return senha;
	}

	public void setSenha(Integer senha) {
		this.senha = senha;
	}

	public int getNumeroDeFuncionarios() {
		return numeroDeFuncionarios;
	}

	public void setNumeroDeFuncionarios(Integer  numeroDeFuncionarios) {
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}

	// método toString
	
	@Override
	public String toString() {
		return "Gerente \nsenha: " + senha + "\nnumeroDeFuncionarios: " + numeroDeFuncionarios + "\n";
	}
	
}