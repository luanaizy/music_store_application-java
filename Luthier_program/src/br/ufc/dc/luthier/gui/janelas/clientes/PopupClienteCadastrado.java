package br.ufc.dc.luthier.gui.janelas.clientes;

import br.ufc.dc.luthier.gui.janelas.PopupInformacaoAbstract;
import br.ufc.dc.luthier.gui.listeners.clientes.BotaoOkClienteCadastradoListener;

public class PopupClienteCadastrado extends PopupInformacaoAbstract {
	public PopupClienteCadastrado(){
		super("Cliente cadastrado com sucesso.", new BotaoOkClienteCadastradoListener()); //falta o listeer
	}
}
