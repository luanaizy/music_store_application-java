package br.ufc.dc.luthier.servicos;

import java.util.Vector;

public class ServicoRevisao extends ServicoAbstract {
	private String resultado;
	private ServicoManutencao servico_recomendado;
	
	public ServicoRevisao(String descricao, double valor, String resultado) {
		super(descricao, valor);
		this.resultado = resultado;
		servico_recomendado = null;
	}

	public String getResultado() {return resultado;}

	public void setResultado(String resultado) {this.resultado = resultado;}

	public ServicoManutencao getServicoRecomendado() {return servico_recomendado;}

	public void setServicoRecomendado(ServicoManutencao servico_recomendado) {
		this.servico_recomendado = servico_recomendado;
	}

}
