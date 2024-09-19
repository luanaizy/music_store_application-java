package br.ufc.dc.luthier.gui.janelas.instrumentos;

import br.ufc.dc.luthier.gui.janelas.PopupInformacaoAbstract;
import br.ufc.dc.luthier.gui.listeners.instrumentos.BotaoOkInstrumentoEditadoListener;

public class PopupInstrumentoEditado extends PopupInformacaoAbstract {
	public PopupInstrumentoEditado(){
		super("Instrumento editado com sucesso.", new BotaoOkInstrumentoEditadoListener());
	}
}