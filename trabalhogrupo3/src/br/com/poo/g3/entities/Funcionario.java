package br.com.poo.g3.entities;

import java.util.HashMap;
import java.util.Map;

import br.com.poo.g3.enums.TipoPessoa;

public class Funcionario extends Conta {

	private Integer id;
	private String nome;
	private String cpf;
	private Double salario;
	private String senha;
	private TipoPessoa cargo;

	static Map<Integer, Funcionario> mapaFuncionarios = new HashMap<>();

	// construtor default

	public Funcionario() {
		super();

	}

	// construtor parametrizado

	public Integer getId() {
		return id;
	}

	public Funcionario(Integer numeroDaConta, Double saldo, Integer id, String nome, String cpf, Double salario,
			String senha, TipoPessoa cargo) {
		super(numeroDaConta, saldo);
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
		this.senha = senha;
		this.cargo = cargo;
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

	public String getSenha() {
		return senha;
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