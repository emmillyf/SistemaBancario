package br.com.poo.g3.entities;

import java.time.LocalDate;

import br.com.poo.g3.enums.TipoPessoa;

public class Gerente extends Funcionario {

	// criar uma agencia
	// construtores default

	public Gerente() {
		super();

	}

	public Gerente(Integer id, String nome, LocalDate dataNasc, String cpf, String senha, Double salario,
			TipoPessoa cargo) {
		super(id, nome, dataNasc, cpf, senha, salario, cargo);
	}

	// construtor parametrizado

	

	// getters e setters

	
}