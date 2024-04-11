package br.com.poo.g3.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g3.entities.Cliente;
import br.com.poo.g3.entities.Conta;
import br.com.poo.g3.entities.ContaCorrente;
import br.com.poo.g3.entities.Funcionario;
import br.com.poo.g3.enums.TipoRegistro;
import br.com.poo.g3.util.Util;

public class RelatorioIO extends ContaCorrente {

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

				if (dados[0].equalsIgnoreCase(TipoRegistro.TIPOCONTA.name())) {
					// private Integer numeroDaConta;
					// private Double saldo = 0.0;
					Conta conta = new Conta(Integer.parseInt(dados[1]), Double.parseDouble(dados[2]));

					Conta.getMapaContas().put(Integer.parseInt(dados[1]), conta);
					logger.log(Level.INFO, conta::toString);
				} else if (dados[0].equalsIgnoreCase(TipoRegistro.FUNCIONARIO.name())) {
					// private Integer id;
					// private String nome;
					// private String cpf;
					// private Double salario;
					Funcionario funcionario = new Funcionario(Integer.parseInt(dados[1]), dados[2], dados[3],
							Double.parseDouble(dados[4]));

					Funcionario.getMapaFuncionarios().put(null, funcionario);
					logger.log(Level.INFO, funcionario::toString);

				} else if (dados[0].equalsIgnoreCase(TipoRegistro.TIPOCLIENTE.name())) {
					// private Integer id;
					// private String nome;
					// private LocalDate dataNasc;
					// private String email;
					Cliente cliente = new Cliente(Integer.parseInt(dados[1]), dados[2], LocalDate.parse(dados[3], dtf),
							dados[4]);

					Cliente.getMapaClientes().put(Integer.parseInt(dados[1]), cliente);
					logger.log(Level.INFO, cliente::toString);
				} else {
					break;
				}
			}
		}
		buffRead.close();
	}

	public static void escritor(String path) throws IOException {
		Scanner sc = new Scanner(System.in);
		Util.customizer();
		logger.log(Level.INFO, () -> "Escreva o nome do arquivo: ");
		String nome = sc.next();

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true));
		String linha = "";

		Util.customizer();
		logger.log(Level.INFO, () -> "Escreva algo: ");
		Scanner sc1 = new Scanner(System.in);
		linha = sc1.nextLine();
		buffWrite.append(linha + "\n");
		buffWrite.close();
		sc.close();
		sc1.close();

	}
}