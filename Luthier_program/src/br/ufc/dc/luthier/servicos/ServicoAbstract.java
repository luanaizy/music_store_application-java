package br.ufc.dc.luthier.servicos;

public abstract class ServicoAbstract {
	private double valor;
	private String descricao;
	
	public ServicoAbstract(String descricao, double valor) {
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public double getValor() {return valor;}
	public String getDescricao() {return descricao;}
}
