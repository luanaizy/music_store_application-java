package br.ufc.dc.luthier.exceptions;

public class FuncInexistenteException extends Exception {
	String cpf;
	public FuncInexistenteException(String cpf) {
		super("[Funcionario Inexistente]");
		this.cpf = cpf;
	}
	public String getCpf() {return cpf;}
}
