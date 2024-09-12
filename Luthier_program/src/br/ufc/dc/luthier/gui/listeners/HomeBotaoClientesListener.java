package br.ufc.dc.luthier.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.ufc.dc.luthier.gui.janelas.clientes.JanelaClientes;

public class HomeBotaoClientesListener implements ActionListener {
	public void actionPerformed(ActionEvent evento){
		JanelaClientes janela_clientes = new JanelaClientes();
	}
}
