package Incremento1;

import java.util.Scanner;

class CartaoDeCredito {
	private String numero, nomeTitular, cpfTitular;
	private float limite, saldo;
	
	private float get_limite() {
		return limite;
	}
	
	private void set_limite(float valor) {
		limite = valor;
	}
	
	private float get_saldo() {
		return limite;
	}
	
	private void set_saldo(float valor) {
		saldo = valor;
	}
	
	
	public CartaoDeCredito(float l_inicial) {
		limite = l_inicial;
		set_saldo(get_limite());
	}
	
	public float consultarSaldo() {
		return get_saldo();
	}
	
	public float consultarLimite() {
		return get_limite();
	}
	
	public boolean realizarTransação(float valor) {
		float resultado = get_saldo() - valor;
		if(resultado > 0.f) {
			set_saldo(resultado);
			return true;
		}
		return false;
	}
	
	public void alterarLimite(float novo_limite) {
		set_limite(novo_limite);
		set_saldo(novo_limite);
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
