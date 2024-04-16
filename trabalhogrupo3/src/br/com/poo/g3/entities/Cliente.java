package br.com.poo.g3.entities;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Cliente {

	private Integer id;
	private String nome;
	private LocalDate dataNasc;
	private String email;
	private String senha;
//	private String usuario;
//	private String senha;
	
	static Map<Integer, Cliente> mapaClientes = new HashMap<>();

	// construtor default

	public Cliente() {
		super();
	}

	// construtor parametrizado

	public Cliente(Integer id, String nome, LocalDate dataNasc, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.email = email;
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

	public String getEmail() {
		return email;
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
		return "Cliente \nid: " + id + "\nnome: " + nome + "\ndataNasc: " + dataNasc + "\nemail: " + email + "\n";
	}
}