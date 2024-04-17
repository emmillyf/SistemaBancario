package br.com.poo.g3.entities;

import java.util.HashMap;
import java.util.Map;

import br.com.poo.g3.enums.TipoPessoa;

public class Diretor extends Funcionario {
	
	// criar 2 agencias de controle para cada diretor (agencias que ja existem)

	static Map<Integer, Diretor> mapaDiretores = new HashMap<>();

	public Diretor() {
		super();

	}

	public Diretor(Integer numeroDaConta, Double saldo, Integer id, String nome, String cpf, Double salario,
			String senha, TipoPessoa cargo) {
		super(numeroDaConta, saldo, id, nome, cpf, salario, senha, cargo);
	}

	public static Map<Integer, Diretor> getMapaDiretores() {
		return mapaDiretores;
	}
}