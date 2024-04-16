package br.com.poo.g3.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g3.entities.Cliente;
import br.com.poo.g3.entities.Conta;
import br.com.poo.g3.entities.ContaCorrente;
import br.com.poo.g3.entities.ContaPoupanca;
import br.com.poo.g3.entities.Diretor;
import br.com.poo.g3.entities.Funcionario;
import br.com.poo.g3.entities.Gerente;
import br.com.poo.g3.entities.Presidente;
import br.com.poo.g3.enums.TipoConta;
import br.com.poo.g3.enums.TipoPessoa;
import br.com.poo.g3.util.Util;

public class RelatorioIO extends Funcionario {

	static final String PATH_BASICO = "./temp/";
	static final String EXTENSAO = ".txt";
	private static Logger logger = Util.setupLogger();
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public static void leitor(String path) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(PATH_BASICO + path + EXTENSAO));
		String linha = "";
		while (true) {
			linha = buffRead.readLine();
			if (linha != null) {
				Util.customizer();
				String[] dados = linha.split(";");

			 if (dados[0].equalsIgnoreCase(TipoPessoa.GERENTE.name())) {
				// private Integer id;
				// private String nome;
				// private String cpf;
				// private Double salario;
				Funcionario gerente = new Gerente(Integer.parseInt(dados[1]), dados[2], dados[3],
						Double.parseDouble(dados[4]), dados[5], Integer.parseInt(dados[6]));

				Funcionario.getMapaFuncionarios().put(Integer.parseInt(dados[1]), gerente);
//				logger.log(Level.INFO, gerente::toString);

			} else if (dados[0].equalsIgnoreCase(TipoPessoa.DIRETOR.name())) {
				// private Integer id;
				// private String nome;
				// private String cpf;
				// private Double salario;
				Funcionario diretor = new Diretor(Integer.parseInt(dados[1]), dados[2], dados[3],
						Double.parseDouble(dados[4]), dados[5]);

				Funcionario.getMapaFuncionarios().put(Integer.parseInt(dados[1]), diretor);
//				logger.log(Level.INFO, diretor::toString);

			} else if (dados[0].equalsIgnoreCase(TipoPessoa.PRESIDENTE.name())) {
				// private Integer id;
				// private String nome;
				// private String cpf;
				// private Double salario;
				Funcionario presidente = new Presidente(Integer.parseInt(dados[1]), dados[2], dados[3],
						Double.parseDouble(dados[4]), dados[5]);

				Funcionario.getMapaFuncionarios().put(Integer.parseInt(dados[1]), presidente);
//				logger.log(Level.INFO, presidente::toString);
			}else if (dados[0].equalsIgnoreCase(TipoPessoa.FUNCIONARIO.name())) {
				// private Integer id;
//				private String nome;
//				private String cpf;
//				private Double salario;
				Funcionario funcionario = new Funcionario(Integer.parseInt(dados[1]), dados[2], dados[3], Double.parseDouble(dados[4]), dados[5]);

				Funcionario.getMapaFuncionarios().put(Integer.parseInt(dados[1]), funcionario);
//				logger.log(Level.INFO, funcionario::toString);
			
		}else if (dados[0].equalsIgnoreCase(TipoPessoa.CLIENTE.name())) {
				// private Integer id;
				// private String nome;
				// private LocalDate dataNasc;
				// private String email;
				Cliente cliente = new Cliente(Integer.parseInt(dados[1]), dados[2], LocalDate.parse(dados[3], dtf),
						dados[4], dados[5]);

				Cliente.getMapaClientes().put(Integer.parseInt(dados[1]), cliente);
//				logger.log(Level.INFO, cliente::toString);
				
		}else if (dados[0].equalsIgnoreCase(TipoConta.CONTA_CORRENTE.name())) {
					// Integer numeroDaConta, Double saldo, Double tarifa, Double limite

					Conta contaCorrente = new ContaCorrente(Integer.parseInt(dados[1]), Double.parseDouble(dados[2]),
							Double.parseDouble(dados[3]), Double.parseDouble(dados[4]));

					Conta.getMapaContas().put(Integer.parseInt(dados[1]), contaCorrente);
//					logger.log(Level.INFO, contaCorrente::toString);

				} else if (dados[0].equalsIgnoreCase(TipoConta.CONTA_POUPANCA.name())) {
					// Integer numeroDaConta, Double saldo, Double rendimento
					Conta contaPoupanca = new ContaPoupanca(Integer.parseInt(dados[1]), Double.parseDouble(dados[2]),
							Double.parseDouble(dados[3]));

					Conta.getMapaContas().put(Integer.parseInt(dados[1]), contaPoupanca);
//					logger.log(Level.INFO, contaPoupanca::toString);
				
				} else {
					break;
				}
		}
		}
		buffRead.close();
		
	}
}

//	public static void escritor(String path) throws IOException {
//		Scanner sc = new Scanner(System.in);
//		Util.customizer();
//		logger.log(Level.INFO, () -> "Escreva o nome do arquivo: ");
//		String nome = sc.next();
//
//		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true));
//		String linha = "";
//
//		Util.customizer();
//		logger.log(Level.INFO, () -> "Escreva algo: ");
//		Scanner sc1 = new Scanner(System.in);
//		linha = sc1.nextLine();
//		buffWrite.append(linha + "\n");
//		buffWrite.close();
//		sc.close();
//		sc1.close();
//
//	}
