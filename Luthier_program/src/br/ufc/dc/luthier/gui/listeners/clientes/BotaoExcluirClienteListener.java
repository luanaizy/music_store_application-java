package br.ufc.dc.luthier.gui.listeners.clientes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.ufc.dc.luthier.controllers.ClienteController;
import br.ufc.dc.luthier.exceptions.CIException;
import br.ufc.dc.luthier.gui.janelas.clientes.JanelaCadastrarCliente;
import br.ufc.dc.luthier.gui.janelas.clientes.JanelaClientes;

public class BotaoExcluirClienteListener implements ActionListener {
	private ClienteController cliente_controller;
	private String cpf;
	public BotaoExcluirClienteListener(ClienteController cliente_controller, String cpf) {
		this.cliente_controller = cliente_controller;
		this.cpf = cpf;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
		cliente_controller.remover(cpf);
		JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		JFrame janelaAtual = (JFrame) ((JButton) e.getSource()).getTopLevelAncestor(); 
        janelaAtual.dispose(); 
        new JanelaClientes(cliente_controller);
		} catch (CIException cie) {
			JOptionPane.showMessageDialog(null, "Erro: Cliente inexistente!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}

