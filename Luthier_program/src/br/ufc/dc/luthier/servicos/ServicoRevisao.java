package br.ufc.dc.luthier.servicos;

import java.util.Vector;

public class ServicoRevisao extends ServicoAbstract {
	private String resultado;
	private Vector<ServicoManutencao> servicos_recomendados;
	
	public ServicoRevisao(String descricao, double valor) {
		super(descricao, valor);
	}

	public String getResultado() {return resultado;}

	public void setResultado(String resultado) {this.resultado = resultado;}

	public Vector<ServicoManutencao> getServicosRecomendados() {return servicos_recomendados;}

	public void setServicosRecomendados(Vector<ServicoManutencao> servicos_recomendados) {
		this.servicos_recomendados = servicos_recomendados;
	}

}
