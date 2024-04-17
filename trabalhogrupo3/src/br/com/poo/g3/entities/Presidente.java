package br.com.poo.g3.entities;

import java.time.LocalDate;

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

	public Presidente(Integer id, String nome, LocalDate dataNasc, String cpf, String senha, Double salario,
			TipoPessoa cargo) {
		super(id, nome, dataNasc, cpf, senha, salario, cargo);
	}

	// construtor parametrizado


}