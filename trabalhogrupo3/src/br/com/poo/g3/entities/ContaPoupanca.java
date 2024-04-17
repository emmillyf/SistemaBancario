package br.com.poo.g3.entities;

import java.util.Scanner;

public class ContaPoupanca extends Conta {


	// construtor default

	public ContaPoupanca() {
		super();
	}
	// construtor parametrizado

	public ContaPoupanca(Integer numeroDaConta, Double saldo, Integer numeroDaAgencia, String cpf) {
		super(numeroDaConta, saldo, numeroDaAgencia, cpf);
	}

	public static void simularpoupanca() {

        double juros = 0.0035;
        double valorcapital = 0;
        double capital;

        Scanner leitor = new Scanner(System.in);

        System.out.println("1- Rendimento por dia.");
        System.out.println("2- Rendimento por mes.");
        int escolha = leitor.nextInt();

        switch (escolha) {
        case 1:
            System.out.println("Digite o capital inicial: ");
            capital = leitor.nextDouble();
            System.out.println("Digite a quantidade de dias que o capital ficará na poupança: ");
            int dia = leitor.nextInt();
            for (int i = 1; i <= dia; i++) {
                double valortemp = capital * (juros / 30);
                capital = valortemp + capital;
                System.out.printf("no mes " + i + " o capital será: %.2f \n", capital);
                valorcapital = valortemp + valorcapital;
            }
            break;
        case 2:
            System.out.println("Digite o capital inicial: ");
            capital = leitor.nextDouble();
            System.out.println("Digite a quantidade de meses que o capital ficará na poupança: ");
            int mes = leitor.nextInt();
            for (int i = 1; i <= mes; i++) {
                double valortemp = capital * juros;
                capital = valortemp + capital;
                System.out.printf("no mes " + i + " o capital será: %.2f \n", capital);
                valorcapital = valortemp + valorcapital;
            }
            System.out.printf("O rendimento total é: %.2f", capital);
        }
    }
	

	// getters e setters



}