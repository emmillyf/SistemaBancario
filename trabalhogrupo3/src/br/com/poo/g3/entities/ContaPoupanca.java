package br.com.poo.g3.entities;

public class ContaPoupanca extends Conta {

	private Double rendimento;

	// construtor default

	public ContaPoupanca() {
		super();
	}
	// construtor parametrizado

	public ContaPoupanca(Double rendimento) {
		super();
		this.rendimento = rendimento;
	}

	public ContaPoupanca(Integer numeroDaConta, Double saldo, Double rendimento) {
		super(numeroDaConta, saldo);
		this.rendimento = rendimento;
	}

	// getters e setters

	public double getRendimento() {
		return rendimento;
	}

	public void setRendimento(Double rendimento) {
		this.rendimento = rendimento;
	}

	@Override
	public String toString() {
		return "ContaPoupanca \nrendimento: " + rendimento + "\n";
	}
}