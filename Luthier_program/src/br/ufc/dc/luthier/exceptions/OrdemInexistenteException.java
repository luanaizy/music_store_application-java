package br.ufc.dc.luthier.exceptions;

public class OrdemInexistenteException extends Exception {
	private String numero;
	
	public OrdemInexistenteException(String numero) {
		super("[Ordem inexistente]");
		this.numero = numero;
	}
}
