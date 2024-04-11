package br.com.poo.g3.entities;

import java.util.HashMap;
import java.util.Map;

public class Conta extends Cliente {
	private static int contadorDeContas = 1;
	// toda vez que uma conta for criada, um número é atribuido à ela

	private Integer numeroDaConta;
	private Double saldo = 0.0;

	static Map<Integer, Conta> mapaContas = new HashMap<>();

	public Conta() {
		super();

	}

	// construtor parametrizado

	public Conta(Integer numeroDaConta, Double saldo) {
		super();
		this.numeroDaConta = contadorDeContas;
		this.saldo = saldo;
		contadorDeContas += 1;
	}

	// getters e setters

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Integer getNumeroDaConta() {
		return numeroDaConta;
	}
	
	public static Map<Integer, Conta> getMapaContas() {
		return mapaContas;
	}
	
	// método toString

	@Override
	public String toString() {
		return "Conta \nnumeroDaConta: " + numeroDaConta + "\nsaldo: " + saldo + "\n";
	}
}