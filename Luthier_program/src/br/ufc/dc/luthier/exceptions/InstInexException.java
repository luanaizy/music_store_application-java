package br.ufc.dc.luthier.exceptions;

public class InstInexException extends Exception {
	private String num_de_serie;
	public InstInexException(String num_de_serie) {
		super("[Instrumento inexistente]");
		this.num_de_serie = num_de_serie;
	}
	public String getCodigo() {return num_de_serie;}
}
