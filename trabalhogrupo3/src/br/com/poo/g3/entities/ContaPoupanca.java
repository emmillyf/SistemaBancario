package br.com.poo.g3.entities;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g3.util.Util;


public class ContaPoupanca extends Conta {
	static Logger logger = Util.setupLogger();

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

        logger.log(Level.INFO, "1- Rendimento por dia.");
        logger.log(Level.INFO, "2- Rendimento por mes.");
        int escolha = leitor.nextInt();

        switch (escolha) {
        case 1:
        	 logger.log(Level.INFO, "Digite o capital inicial: ");
            capital = leitor.nextDouble();
            logger.log(Level.INFO, "Digite a quantidade de dias que o capital ficará na poupança: ");
            int dia = leitor.nextInt();
            for (int i = 1; i <= dia; i++) {
                double valortemp = capital * (juros / 30);
                capital = valortemp + capital;
                logger.log(Level.INFO, "no mes " + i + " o capital será: %.2f \n", capital);
                valorcapital = valortemp + valorcapital;
            }
            break;
        case 2:
        	 logger.log(Level.INFO, "Digite o capital inicial: ");
            capital = leitor.nextDouble();
            logger.log(Level.INFO, "Digite a quantidade de meses que o capital ficará na poupança: ");
            int mes = leitor.nextInt();
            for (int i = 1; i <= mes; i++) {
                double valortemp = capital * juros;
                capital = valortemp + capital;
                logger.log(Level.INFO, "no mes " + i + " o capital será: %.2f \n", capital);
                valorcapital = valortemp + valorcapital;
            }
            logger.log(Level.INFO, "O rendimento total é: %.2f", capital);
        }
    }
	

	// getters e setters



}