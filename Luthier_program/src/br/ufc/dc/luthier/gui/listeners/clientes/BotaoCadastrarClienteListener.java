package br.ufc.dc.luthier.gui.listeners.clientes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.ufc.dc.luthier.controllers.ClienteController;
import br.ufc.dc.luthier.gui.janelas.clientes.JanelaCadastrarCliente;
import br.ufc.dc.luthier.gui.janelas.clientes.JanelaClientes;

public class BotaoCadastrarClienteListener implements ActionListener {
	
	private ClienteController cliente_controller;
	private JanelaClientes owner;
	
	public BotaoCadastrarClienteListener(ClienteController cliente_controller, JanelaClientes janela_clientes) {
		this.cliente_controller = cliente_controller;
		owner = janela_clientes;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		JanelaCadastrarCliente janela_cadastrar_cliente = new JanelaCadastrarCliente(cliente_controller, owner);
	}
}
