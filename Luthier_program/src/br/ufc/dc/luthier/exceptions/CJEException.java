package br.ufc.dc.luthier.exceptions;

public class CJEException extends Exception {
	private String cpf;
	
	public CJEException(String cpf) {
		super("Este cpf já está cadastrado");
		this.cpf = cpf;
	}
	public String getCpf() {return cpf;}
}
