package br.edu.infnet.view;

import br.edu.infnet.exceptions.SaldoInsuficienteException;
import br.edu.infnet.exceptions.ValorInvalidoException;
import br.edu.infnet.model.ContaCorrente;
import br.edu.infnet.model.ContaEspecial;

public class TestaConta {

	public static void main(String[] args) {
		
		
		ContaCorrente contaCorrente = new ContaCorrente();
		contaCorrente.setNumero(0);
		contaCorrente.setTitular("Machado de Assis");
		contaCorrente.setSaldo(1000.00);
		
		System.out.println(contaCorrente);
		
		System.out.println("Depositando -1 moeda na conta corrente");
		
		double novoValor;
		
		try {
			novoValor = contaCorrente.depositar(-1.00);
			System.out.println("Dep�sito efetuado com sucesso. O novo saldo � " + novoValor);
		} catch (ValorInvalidoException e) {
			System.out.println("Valor informado para dep�sito � inv�lido.");
		}
		
		try {
			novoValor = contaCorrente.sacar(0.00);
			System.out.println("Saque efetuado com sucesso. O novo saldo � " + novoValor);
		} catch (ValorInvalidoException e) {
			System.out.println("Valor informado para saque � inv�lido pelo seguinte motivo: " + e.getMessage());
		} catch (SaldoInsuficienteException e) {
			System.out.println("O saldo � insuficiente para realizar a transa��o");
		}
		
		try {
			novoValor = contaCorrente.depositar(1.00);
			System.out.println("Dep�sito efetuado com sucesso. O novo saldo � " + novoValor);
		} catch (ValorInvalidoException e) {
			System.out.println("Valor informado para dep�sito � inv�lido.");
		}
		
		try {
			novoValor = contaCorrente.sacar(200.00);
			System.out.println("Saque efetuado com sucesso. O novo saldo � " + novoValor);
		} catch (ValorInvalidoException e) {
			System.out.println("Valor informado para saque � inv�lido.");
		} catch (SaldoInsuficienteException e) {
			System.out.println("O saldo � insuficiente para realizar a transa��o");
		}
		
		try {
			novoValor = contaCorrente.sacar(1000.00);
			System.out.println("Saque efetuado com sucesso. O novo saldo � " + novoValor);
		} catch (ValorInvalidoException e) {
			System.out.println("Valor informado para saque � inv�lido.");
		} catch (SaldoInsuficienteException e) {
			System.out.println("O saldo � insuficiente para realizar a transa��o");
		}
		
		ContaEspecial contaEspecial = new ContaEspecial();
		contaEspecial.setNumero(1);
		contaEspecial.setTitular("Olavo Bilac");
		contaEspecial.setSaldo(2000.00);
		contaEspecial.setLimite(200.00);
		
		System.out.println(contaEspecial);
		
		try {
			novoValor = contaEspecial.sacar(1000.00);
			System.out.println("Saque efetuado com sucesso. O novo saldo � " + novoValor);
		} catch (ValorInvalidoException e) {
			System.out.println("Valor informado para saque � inv�lido.");
		} catch (SaldoInsuficienteException e) {
			System.out.println("O saldo � insuficiente para realizar a transa��o");
		}
		
	}
	
}
