package br.edu.infnet.model;

import br.edu.infnet.exceptions.SaldoInsuficienteException;
import br.edu.infnet.exceptions.ValorInvalidoException;

public class ContaCorrente {

	private int numero;
	private String titular;
	private double saldo;
	private String senha;

	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getTitular() {
		return titular;
	}
	
	public void setTitular(String titular) {
		this.titular = titular;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public double depositar(double valor) throws ValorInvalidoException {
		if (valor <= 0) {
			throw new ValorInvalidoException("O valor do depósito deve ser maior que 0");
		} 
		
		this.saldo += valor;
		
		return this.saldo; 
	}
	
	public double sacar(double valor) throws ValorInvalidoException, SaldoInsuficienteException {
		if (valor <= 0) {
			throw new ValorInvalidoException("O valor do depósito deve ser maior que 0");
		}
	
		validarSaldoParaSaque(valor);
		
		this.saldo -= valor;
		
		return this.saldo;
	}
	
	@Override
	public String toString() {
		return "Conta Corrente: " + this.numero + " - " + this.titular + " - saldo: " + this.saldo;
	}
	
	protected void validarSaldoParaSaque(double valor) throws SaldoInsuficienteException {
		if (this.saldo < valor) {
			throw new SaldoInsuficienteException("Saldo insuficiente para saque");
		}
	}
	
}
