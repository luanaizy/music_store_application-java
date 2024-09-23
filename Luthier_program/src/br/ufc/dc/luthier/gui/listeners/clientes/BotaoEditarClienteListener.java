package br.ufc.dc.luthier.gui.listeners.clientes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.ufc.dc.luthier.controllers.ClienteController;
import br.ufc.dc.luthier.gui.janelas.clientes.JanelaEditarCliente;
import br.ufc.dc.luthier.gui.janelas.clientes.JanelaClientes;

public class BotaoEditarClienteListener implements ActionListener {
	public JanelaClientes owner;
	private ClienteController cliente_controller;
	private int index;
	
	public BotaoEditarClienteListener(JanelaClientes owner, ClienteController cliente_controller, int index) {
		this.owner = owner;
		this.cliente_controller = cliente_controller;
		this.index = index;
	}
	public void actionPerformed(ActionEvent e) {
		JanelaEditarCliente janela_editar_cliente = new JanelaEditarCliente(owner, cliente_controller, index);
	}
}
