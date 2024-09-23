package br.ufc.dc.luthier.servicos;

public class ServicoManutencaoRegulagem extends ServicoManutencao {
	private String regulagem_de;
	public ServicoManutencaoRegulagem(String descricao, double valor, String regulagem_de) {
		super(descricao, valor);
		this.setRegulagemDe(regulagem_de);
	}
	public String getRegulagemDe() {
		return regulagem_de;
	}
	public void setRegulagemDe(String regulagem_de) {
		this.regulagem_de = regulagem_de;
	}
	
}
