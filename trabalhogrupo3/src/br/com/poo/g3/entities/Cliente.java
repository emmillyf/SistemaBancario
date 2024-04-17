package br.com.poo.g3.entities;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Cliente {

	private Integer id;
	private String nome;
	private LocalDate dataNasc;
	private String cpf;
	private String senha;
	
	
	
	static Map<Integer, Cliente> mapaClientes = new HashMap<>();


	

	// construtor default

	public Cliente() {
		super();
	}

	// construtor parametrizado

	public Cliente(Integer id, String nome, LocalDate dataNasc, String cpf, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.cpf = cpf;
		this.senha = senha;
//		this.usuario = usuario;
//		this.senha = senha;
	}

	
	// getters e setters

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public String getCpf() {
		return cpf;
	}
	
	
//	public String getUsuario() {
//		return usuario;
//	}
//
//	public void setUsuario(String usuario) {
//		this.usuario = usuario;
//	}
//
//	public String getSenha() {
//		return senha;
//	}
//
//	public void setSenha(String senha) {
//		this.senha = senha;
//	}

	public String getSenha() {
		return senha;
	}

	public static Map<Integer, Cliente> getMapaClientes() {
		return mapaClientes;
	}

	
	// método toString
	
	@Override
	public String toString() {
		return "Cliente \nid: " + id + "\nnome: " + nome + "\ndataNasc: " + dataNasc + "\nemail: " + cpf + "\n";
	}
}