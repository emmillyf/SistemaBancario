package br.com.poo.g3.entities;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g3.util.Util;

public abstract class Conta {
	static Logger logger = Util.setupLogger();
	// buscar uma lógica que
	private static int contadorDeContas = 1;
	// toda vez que uma conta for criada, um número é atribuido à ela

	private Integer numeroDaAgencia;
	private Integer numeroDaConta;
	private Double saldo = 0.0;
	private String cpf;
	private double tributos = 0;

	static Map<Integer, Conta> mapaContas = new HashMap<>();

	public Conta() {
		super();

	}

	// construtor parametrizado

	public Conta(Integer numeroDaConta, Double saldo, Integer numeroDaAgencia, String cpf) {
		super();
		this.numeroDaConta = contadorDeContas;
		this.saldo = saldo;
		this.numeroDaAgencia = numeroDaAgencia;
		this.cpf = cpf;
		contadorDeContas += 1;
	}

	public void depositar(double valorInserido) {
		saldo += valorInserido;
		saldo -= 0.10;
		tributos += 0.10;

		 logger.log(Level.INFO, "----------------------------");
		 logger.log(Level.INFO, "Saldo anterior: R$%.2f\n", (saldo - valorInserido));
		 logger.log(Level.INFO, "Valor Depositado: R$%.2f\n", valorInserido);
		 logger.log(Level.INFO, "Saldo atual: R$%.2f\n", saldo);
		 logger.log(Level.INFO, "-----------------------------");
	}

	public boolean sacar(double valorInserido) {
		if ((saldo - valorInserido) >= 0) {
			saldo -= valorInserido;
			saldo -= 0.10;
			tributos += 0.10;

			 logger.log(Level.INFO, "-----------------------------");
			 logger.log(Level.INFO, "Saldo anterior: R$%.2f\n", (saldo + valorInserido));
			 logger.log(Level.INFO, "Valor do saque: R$%.2f\n", valorInserido);
			 logger.log(Level.INFO, "Saldo atual: R$%.2f\n", saldo);
			 logger.log(Level.INFO,"-----------------------------");

			return true;
		} else {
			 logger.log(Level.INFO, "-------------------");
			 logger.log(Level.INFO, "Saldo insuficiente!");
			 logger.log(Level.INFO, "-------------------");
			return false;
		}
	}

	public boolean transferencia(double valorInserido, Conta destinatario) {
		if ((saldo - valorInserido - 0.20) >= 0) {
			saldo -= valorInserido;
			destinatario.saldo += valorInserido;
			saldo = saldo - 0.20;
			tributos += 0.20;

			 logger.log(Level.INFO, "-----------------------------");
			 logger.log(Level.INFO, "O valor a ser transferido é: R$%.2f\n", valorInserido);
			 logger.log(Level.INFO, "Destinatario: " + destinatario.getCpf());
			 logger.log(Level.INFO, "O seu saldo atual é: R$%.2f\n", saldo);
			 logger.log(Level.INFO, "-----------------------------");

			return true;
		} else {
			 logger.log(Level.INFO, "-------------------");
			 logger.log(Level.INFO, "Saldo insuficiente!");
			 logger.log(Level.INFO, "-------------------");
			return false;
		}
	}

	public void tributosconta() throws IOException {

		logger.log(Level.INFO, "--------------------------------------------------------");
		logger.log(Level.INFO, "O total de tributos que voce pagou foi de: R$%.2f\n", tributos);
		logger.log(Level.INFO, "--------------------------------------------------------");

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

	public String getCpf() {
		return cpf;
	}

	public Integer getNumeroDaAgencia() {
		return numeroDaAgencia;
	}

	public void setNumeroDaAgencia(Integer numeroDaAgencia) {
		this.numeroDaAgencia = numeroDaAgencia;
	}

	public static Map<Integer, Conta> getMapaContas() {
		return mapaContas;
	}

	// método toString

	@Override
	public String toString() {
		return "Conta \nnumeroDaConta: " + numeroDaConta + "\nsaldo: " + saldo + "\n" + "\nCPF: " + cpf + "\nTributos: "
				+ tributos;
	}
}