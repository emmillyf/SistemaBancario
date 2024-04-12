package br.com.poo.g3.entities;

public class ContaCorrente extends Conta {

	private Double tarifa;
	private Double limite;

	
	// construtor default

	public ContaCorrente() {
		super();

	}

	public ContaCorrente(Integer numeroDaConta, Double saldo) {
		super(numeroDaConta, saldo);

	}

	// construtor parametrizado

	public ContaCorrente(Integer numeroDaConta, Double saldo, Double tarifa, Double limite) {
		super(numeroDaConta, saldo);
		this.tarifa = tarifa;
		this.limite = limite;
	}

	public Double getTarifa() {
		return tarifa;
	}

	public Double getLimite() {
		return limite;
	}

	// método toString

	@Override
	public String toString() {
		return "ContaCorrente \ntarifa: " + tarifa + "\nlimite: " + limite + "\n";
	}
}