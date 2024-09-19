package br.ufc.dc.luthier.servicos;

public class ServicoManutencaoConserto extends ServicoManutencao {
	private String peca_consertada;
	public ServicoManutencaoConserto(String descricao, double valor, String peca_consertada) {
		super(descricao, valor);
		this.peca_consertada = peca_consertada;
	}
	public String getPecaConsertada() {
		return peca_consertada;
	}
}
