package br.ufc.dc.luthier.exceptions;

public class InstJaExisteException extends Exception {
	private String num_de_serie;
	public InstJaExisteException(String num_de_serie) {
		super("[Instrumento já existe]");
		this.num_de_serie = num_de_serie;
	}
	public String getNumDeSerie() {return num_de_serie;}
}
