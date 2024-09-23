package br.ufc.dc.luthier.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.ufc.dc.luthier.controllers.ClienteController;
import br.ufc.dc.luthier.gui.janelas.clientes.JanelaClientes;
import br.ufc.dc.luthier.repositorios.clientes.IRepositorioClientes;

public class HomeBotaoClientesListener implements ActionListener {
	ClienteController cliente_controller;
	public HomeBotaoClientesListener(ClienteController cliente_controller) {
		this.cliente_controller = cliente_controller;
	}
	public void actionPerformed(ActionEvent evento){
		JanelaClientes janela_clientes = new JanelaClientes(cliente_controller);
	}
}
