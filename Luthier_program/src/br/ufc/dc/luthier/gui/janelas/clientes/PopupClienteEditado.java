package br.ufc.dc.luthier.gui.janelas.clientes;

import br.ufc.dc.luthier.gui.janelas.PopupInformacaoAbstract;
import br.ufc.dc.luthier.gui.listeners.clientes.BotaoOkClienteEditadoListener;

public class PopupClienteEditado extends PopupInformacaoAbstract {
	public PopupClienteEditado(){
		super("Cliente editado com sucesso.", new BotaoOkClienteEditadoListener());
	}
}
