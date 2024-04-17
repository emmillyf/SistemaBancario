package br.com.poo.g3.entities;

import java.util.HashMap;
import java.util.Map;

public class Usuarios {
	Map<String, Cliente> clientes;
	Map<String, Funcionario> funcionarios;
	Map<String, Diretor> diretores = Map.of();
	Map<String, Gerente> gerentes = Map.of();
	Map<String, Presidente> presidente = Map.of();
	Map<String, Conta> contas = Map.of();

	public Usuarios() {
		super();
	}

	public Map<String, Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Map<String, Cliente> clientes) {
		this.clientes = clientes;
	}

	public Map<String, Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Map<String, Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Map<String, Diretor> getDiretores() {
		return diretores;
	}

	public void setDiretores(Map<String, Diretor> diretores) {
		this.diretores = diretores;
	}

	public Map<String, Gerente> getGerentes() {
		return gerentes;
	}

	public void setGerentes(Map<String, Gerente> gerentes) {
		this.gerentes = gerentes;
	}

	public Map<String, Presidente> getPresidente() {
		return presidente;
	}

	public void setPresidente(Map<String, Presidente> presidente) {
		this.presidente = presidente;
	}

	public Map<String, Conta> getContas() {
		return contas;
	}

	public void setContas(Map<String, Conta> contas) {
		this.contas = contas;
	}

	public Conta buscarConta(String cpf) {

		for (Conta conta : this.contas.values()) {
			if (conta.getCpf().equals(cpf)) {
				return conta;
			}
		}
		return null;
	}
	public Funcionario buscarFuncionario(String cpf) {

		for (Funcionario funcionario : this.funcionarios.values()) {
			if (funcionario.getCpf().equals(cpf)) {
				return funcionario;
			}
		}
		return null;
	}
}
