package br.com.poo.g3.entities;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import br.com.poo.g3.enums.TipoPessoa;

public class Funcionario extends Cliente {


	private Double salario;
	private TipoPessoa cargo;

	static Map<Integer, Funcionario> mapaFuncionarios = new HashMap<>();

	// construtor default

	public Funcionario() {
		super();

	}

	// construtor parametrizado

	public Double getSalario() {
		return salario;
	}



	public Funcionario(Integer id, String nome, LocalDate dataNasc, String cpf, String senha, Double salario,
			TipoPessoa cargo) {
		super(id, nome, dataNasc, cpf, senha);
		this.salario = salario;
		this.cargo = cargo;
	}

	public static Map<Integer, Funcionario> getMapaFuncionarios() {
		return mapaFuncionarios;
	}

	// método toString

	@Override
	public String toString() {
		return "Funcionario \nid: " + this.getId() + "\nnome: " + this.getNome() +  "\nsalario: " + this.getSalario() + "\n";
	}
}