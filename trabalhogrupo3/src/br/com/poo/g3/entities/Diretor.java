package br.com.poo.g3.entities;

import java.util.HashMap;
import java.util.Map;

public class Diretor extends Funcionario {

	private Integer senha;

	public boolean autentica(Integer senha) {
		if (this.senha == senha) {
			System.out.println("Acesso Permitido!");
			return true;
		} else {
			System.out.println("Acesso Negado!");
			return false;
		}
	}

	// construtor default

	public Diretor() {
		super();

	}

	// construtor parametrizado

	public Diretor(Integer id, String nome, String cpf, Double salario, Integer senha) {
		super(id, nome, cpf, salario);
		this.senha = senha;
	}

	// getters e setters

	public int getSenha() {
		return senha;
	}

	public void setSenha(Integer senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Diretor \nsenha: " + senha + "\n";
	}
}