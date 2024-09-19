package br.ufc.dc.luthier.servicos;

public class ServicoManutencaoTrocaDePeca extends ServicoManutencao {
	private String peca_antiga;
	
	public ServicoManutencaoTrocaDePeca(String descricao, double valor, String peca_antiga) {
		super(descricao, valor);
		this.peca_antiga = peca_antiga;
	}
	public String getPecaAntiga() {
		return peca_antiga;
	}
}
