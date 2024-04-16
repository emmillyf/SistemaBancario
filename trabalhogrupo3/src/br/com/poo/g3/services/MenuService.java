package br.com.poo.g3.services;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.poo.g3.util.*;


public class MenuService {
	static Logger logger = Util.setupLogger();
		static Scanner sc = new Scanner(System.in);

		public static void menu() throws IOException {

			Util.customizer();
			logger.log(Level.INFO, """
					Menu interativo:
					[1]\tMovimentos na conta
					[2]\tRelatórios
					[3]\tSaldo disponível
					[0]\tSair
					Digite uma opção:
					""");

		
		
//		Scanner sc = new Scanner(System.in);
//		
//		String sysCpf = "995.866.968-47";
//		String sysSenha = "1456";
//		
//		
//		System.out.print("Insira seu cpf: ");
//		String Cpf = sc.next();
//		
//		System.out.print("Insira sua senha: ");
//		String Senha = sc.next();
//		Util.customizer();
//		if(sysCpf.equals(Cpf)) {
//			if(sysSenha.equals(Senha)) {
//				System.out.print("Bem vindo, presidente");
//			}else {
//				System.out.print("Cheque sua senha");
//			}
//			
//		}else {
//			System.out.print("Por favor, cheque seu cpf");
//		}
		
		
		
	}
}
