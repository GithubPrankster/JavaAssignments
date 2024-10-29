package Incremento1;

import java.util.Scanner;

class CartaoDeCredito {
	private String numero, nomeTitular, cpfTitular;
	private float limite, cashback;
	
	public CartaoDeCredito(String num, String nome, String cpf) {
		numero = num;
		nomeTitular = nome;
		cpfTitular = cpf;
		limite = 1000.0f;
		cashback = 5.0f / 100.0f;
	}
	
	public CartaoDeCredito(String num, String nome, String cpf, float lim, float cash) {
		numero = num;
		nomeTitular = nome;
		cpfTitular = cpf;
		limite = lim;
		cashback = cash / 100.0f;
	}
	
	public float consultarLimite() {
		return limite;
	}
	
	public boolean realizarTransação(float valor) {
		float resultado = limite - valor;
		if(resultado > 0.f) {
			limite = resultado;
			return true;
		}
		return false;
	}
	
	public boolean realizarTransaçãoCashback(float valor) {
		if(realizarTransação(valor)) {
			limite += valor * cashback;
			return true;
		}
		return false;
	}
}

public class Principal {

	public static void main(String[] args) {
		CartaoDeCredito cartao = new CartaoDeCredito("4002 8922 1234 1449", "Robson Ferreira", "000.800.169-21");
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Seja bem-vindo! Aqui estão suas opções:");
		
		while(true) {
			
			System.out.println("1. Consultar Limite");
			System.out.println("2. Realizar Transação");
			System.out.println("3. Realizar Transação com Cashback");
			System.out.println("4. Sair");
			
			int opção = entrada.nextInt();
			
			if(opção == 4) {
				System.out.println("Muito obrigado por usar nosso serviço!");
				break;
			}else {
				switch(opção) {
				case 1:
					System.out.println("Seu saldo é: " + cartao.consultarLimite());
					break;
				case 2:
					System.out.println("Por favor comunique o valor da transação.");
					float valor = entrada.nextFloat();
					if(cartao.realizarTransação(valor)) {
						System.out.println("Seu limite agora é: " + cartao.consultarLimite());
					}else {
						System.out.println("Transação alta demais para seu saldo atual.");
					}
					break;
				case 3:
					System.out.println("Por favor comunique o valor da transação.");
					float valor1 = entrada.nextFloat();
					if(cartao.realizarTransaçãoCashback(valor1)) {
						System.out.println("Seu saldo agora é: " + cartao.consultarLimite());
					}else {
						System.out.println("Transação alta demais para seu saldo atual.");
					}
					break;
				default:
					System.out.println("Opção desconhecida. Tente novamente.");
					break;
				}	
			}
		}
		
		entrada.close();
	}
}
