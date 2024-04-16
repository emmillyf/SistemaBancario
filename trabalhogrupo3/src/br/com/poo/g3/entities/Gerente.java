package br.com.poo.g3.entities;

import br.com.poo.g3.enums.TipoPessoa;

public class Gerente extends Funcionario {

	private Integer numeroDeFuncionarios;

	public boolean autentica(String senha) {
		if (this.getSenha() == senha) {
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

	public Gerente(Integer numeroDaConta, Double saldo, Integer id, String nome, String cpf, Double salario,
			String senha, TipoPessoa cargo) {
		super(numeroDaConta, saldo, id, nome, cpf, salario, senha, cargo);
		this.numeroDeFuncionarios = 0;
	}

	// getters e setters

	public int getNumeroDeFuncionarios() {
		return numeroDeFuncionarios;
	}

	public void setNumeroDeFuncionarios(Integer numeroDeFuncionarios) {
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}
}