package br.com.poo.g3.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import br.com.poo.g3.util.Comparador;

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

	public Cliente buscarCliente(String cpf) {

		for (Cliente cliente : this.clientes.values()) {
			if (cliente.getCpf().equals(cpf)) {
				return cliente;
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

	public Gerente buscarGerente(Integer agencia) {

		for (Gerente gerente : this.gerentes.values()) {
			Conta contaGerente = buscarConta(gerente.getCpf());
			if (contaGerente.getNumeroDaAgencia().equals(agencia)) {
				return gerente;
			}
		}
		return null;
	}

	public Integer buscarTotalContasPorAgencia(Integer agencia) {
		Integer quantidade = 0;
		for (Conta conta : this.contas.values()) {
			if (conta.getNumeroDaAgencia().equals(agencia)) {
				quantidade++;
			}
		}
		return quantidade;
	}

	public List<Conta> buscarInformacoesDeContasPorAgencia(Integer agencia) {
		List<Conta> contasDaAgencia = new ArrayList<Conta>();
		for (Conta conta : this.contas.values()) {
			if (conta.getNumeroDaAgencia().equals(agencia)) {
				contasDaAgencia.add(conta);
			}
		}
		return contasDaAgencia;
	}

	public List<String> buscarInformacoesDeClientes(Integer agencia) {
		List<String> clienteDaAgencia = new ArrayList<String>();
		for (Conta conta : this.contas.values()) {
			if (conta.getNumeroDaAgencia().equals(agencia)) {
				Cliente cliente = buscarCliente(conta.getCpf());
				if (cliente != null) {
					clienteDaAgencia.add("\nNome: " + cliente.getNome() + "\nCPF: " + cliente.getCpf()
							+ "\nNúmero da agência: " + conta.getNumeroDaAgencia());
				}
			}
		}
		Collections.sort(clienteDaAgencia, new Comparador());
		return clienteDaAgencia;
	}

	public List<String> buscarInformacoesDeDiretores() {
		List<String> diretoresAgencias = new ArrayList<String>();
		for (Diretor diretor : this.diretores.values()) {
			Conta contaDiretor = buscarConta(diretor.getCpf());
			Gerente gerenteDoDiretor = buscarGerente(contaDiretor.getNumeroDaAgencia());
			if (gerenteDoDiretor != null) {
				diretoresAgencias.add("\nDiretor: " + diretor.getNome() + "\nGerente: " + gerenteDoDiretor.getNome()
						+ "\nNúmero da agência: " + contaDiretor.getNumeroDaAgencia());
			} else {
				diretoresAgencias.add("\nDiretor: " + diretor.getNome() + "\nGerente: " + "Gerente não encontrado"
						+ "\nNúmero da agência: " + contaDiretor.getNumeroDaAgencia());
			}
		}
		return diretoresAgencias;
	}

	public Double buscarCapital() {
		Double valorTotal = 0.0;
		for (Conta conta : this.contas.values()) {
			valorTotal += conta.getSaldo();

		}
		return valorTotal;
	}
	public Double buscarSalarioFuncionario(String cpf) {
		for (Funcionario funcionario : this.funcionarios.values()) {
			if (funcionario.getCpf().equals(cpf)) {
				return funcionario.getSalario();
			}
		}
		return null;
	}
	public void CadastrarContaClientes(Cliente cliente, Conta conta) {
		clientes.put(cliente.getCpf(), cliente);
		contas.put(cliente.getCpf(), conta);
	}
	public void CadastrarContaGerentes(Gerente gerente, Conta conta) {
		gerentes.put(gerente.getCpf(), gerente);
		contas.put(gerente.getCpf(), conta);
	}
	public void CadastrarContaDiretor(Diretor diretor, Conta conta) {
		diretores.put(diretor.getCpf(), diretor);
		contas.put(diretor.getCpf(), conta);
	}
}