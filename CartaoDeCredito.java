package Incremento1;

import java.util.Scanner;

class CartaoDeCredito {
	String numero, nomeTitular, cpfTitular;
	float limite, saldo;
	
	public CartaoDeCredito(float l_inicial) {
		limite = l_inicial;
		saldo = limite;
	}
	
	public float consultarSaldo() {
		return saldo;
	}
	
	public float consultarLimite() {
		return limite;
	}
	
	public boolean realizarTransação(float valor) {
		float resultado = saldo - valor;
		if(resultado > 0.f) {
			saldo = resultado;
			return true;
		}
		return false;
	}
}

public class Principal {

	public static void main(String[] args) {
		CartaoDeCredito cartao = new CartaoDeCredito(1000.0f);
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Seja bem-vindo! Aqui estão suas opções:");
		
		while(true) {
			
			System.out.println("1. Consultar Saldo");
			System.out.println("2. Consultar Limite");
			System.out.println("3. Realizar Transação");
			System.out.println("4. Sair");
			
			int opção = entrada.nextInt();
			
			if(opção == 4) {
				System.out.println("Muito obrigado por usar nosso serviço!");
				break;
			}else {
				switch(opção) {
				case 1:
					System.out.println("Seu saldo é: " + cartao.consultarSaldo());
					break;
				case 2:
					System.out.println("Seu limite é: " + cartao.consultarLimite());
					break;
				case 3:
					System.out.println("Por favor comunique o valor da transação.");
					float valor = entrada.nextFloat();
					if(cartao.realizarTransação(valor)) {
						System.out.println("Seu saldo agora é: " + cartao.consultarSaldo());
					}else {
						System.out.println("Transação alta demais para seu saldo atual.");
					}
					break;
				}
			}
		}
		
		entrada.close();
	}
}
