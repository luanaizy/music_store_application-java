package br.ufc.dc.luthier.exceptions;

public class ExisteOrdemAbertaPInstrException extends Exception {
	String numero_ordem_aberta;
	public ExisteOrdemAbertaPInstrException(String numero_ordem_aberta) {
		super("[Existe ordem aberta para este instrumento] ");
		this.numero_ordem_aberta = numero_ordem_aberta;
	}
	public String getNumOrdemAberta() {return numero_ordem_aberta;}
}
