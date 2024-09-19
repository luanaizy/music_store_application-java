package br.ufc.dc.luthier.exceptions;

public class CIException extends Exception {
	private String cpf;
	
	public CIException(String cpf) {
		super("Este cliente não existe");
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}
}
