package br.com.poo.g3.entities;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import br.com.poo.g3.enums.TipoPessoa;

public class Diretor extends Funcionario {
	
	// criar 2 agencias de controle para cada diretor (agencias que ja existem)

	static Map<Integer, Diretor> mapaDiretores = new HashMap<>();

	public Diretor() {
		super();

	}



	public Diretor(Integer id, String nome, LocalDate dataNasc, String cpf, String senha, Double salario,
			TipoPessoa cargo) {
		super(id, nome, dataNasc, cpf, senha, salario, cargo);
	}



	public static Map<Integer, Diretor> getMapaDiretores() {
		return mapaDiretores;
	}
}