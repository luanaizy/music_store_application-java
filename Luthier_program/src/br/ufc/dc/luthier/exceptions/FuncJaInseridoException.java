package br.ufc.dc.luthier.exceptions;

public class FuncJaInseridoException extends Exception {
	private String codigo;
	public FuncJaInseridoException(String codigo) {
		super("[Funcionario ja inserido]");
		this.codigo = codigo;
	}
	public String getCodigo() {return codigo;}
}
