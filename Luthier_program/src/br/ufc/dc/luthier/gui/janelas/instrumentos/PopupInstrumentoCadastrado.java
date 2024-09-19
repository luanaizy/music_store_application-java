package br.ufc.dc.luthier.gui.janelas.instrumentos;

import br.ufc.dc.luthier.gui.janelas.PopupInformacaoAbstract;
import br.ufc.dc.luthier.gui.listeners.instrumentos.BotaoOkInstrumentoCadastradoListener;

public class PopupInstrumentoCadastrado extends PopupInformacaoAbstract {
	public PopupInstrumentoCadastrado(){
		super("Instrumento cadastrado com sucesso.", new BotaoOkInstrumentoCadastradoListener());
	}
}
