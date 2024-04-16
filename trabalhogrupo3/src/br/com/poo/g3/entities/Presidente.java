package br.com.poo.g3.entities;

import br.com.poo.g3.enums.TipoPessoa;

public class Presidente extends Funcionario {

	public boolean autentica(String senha) {
		if (this.getSenha() == senha) {
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

	public Presidente(Integer numeroDaConta, Double saldo, Integer id, String nome, String cpf, Double salario,
			String senha, TipoPessoa cargo) {
		super(numeroDaConta, saldo, id, nome, cpf, salario, senha, cargo);
	}
}