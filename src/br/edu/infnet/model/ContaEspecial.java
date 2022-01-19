package br.edu.infnet.model;

import br.edu.infnet.exceptions.SaldoInsuficienteException;

public class ContaEspecial extends ContaCorrente {

	private double limite;

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	@Override
	public String toString() {
		return super.toString() + " - limite: " + this.limite;
	}
	

	@Override
	protected void validarSaldoParaSaque(double valor) throws SaldoInsuficienteException {
		if ((this.getSaldo() + this.limite) < valor)
			throw new SaldoInsuficienteException("Saldo insuficiente para saque");
	}
	
}
