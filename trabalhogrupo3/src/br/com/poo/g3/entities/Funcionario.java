package br.com.poo.g3.entities;

import java.util.HashMap;
import java.util.Map;

public class Funcionario {
	
	private Integer id;
	private String nome;
	private String cpf;
	private Double salario;
	
	static Map<Integer, Funcionario> mapaFuncionarios = new HashMap<>();
	
	// construtor default
	
	public Funcionario() {
		super();
		
	}

	// construtor parametrizado
	
	public Funcionario(Integer id, String nome, String cpf, Double salario) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public Double getSalario() {
		return salario;
	}

	
	public static Map<Integer, Funcionario> getMapaFuncionarios() {
		return mapaFuncionarios;
	}

	// método toString
	
	@Override
	public String toString() {
		return "Funcionario \nid: " + id + "\nnome: " + nome + "\ncpf: " + cpf + "\nsalario: " + salario + "\n";
	}
}