package br.ufc.dc.luthier.gui.listeners.clientes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import br.ufc.dc.luthier.controllers.ClienteController;
import br.ufc.dc.luthier.exceptions.CJEException;
import br.ufc.dc.luthier.gui.janelas.clientes.JanelaClientes;
import br.ufc.dc.luthier.pessoas.Cliente;

public class BotaoActionCadastrarClienteListener implements ActionListener {
	JanelaClientes owner;
	ClienteController cliente_controller;
	private JTextArea nome_input;
	private JTextArea cpf_input;
	private JTextArea endereco_input;
	private JTextArea telefone_input;
	
	public BotaoActionCadastrarClienteListener(JanelaClientes owner, ClienteController cliente_controller, JTextArea nome_input, JTextArea cpf_input, 
			JTextArea endereco_input,JTextArea telefone_input) {
		this.owner = owner;
		this.cliente_controller = cliente_controller;
		this.nome_input = nome_input;
		this.cpf_input = cpf_input;
		this.endereco_input = endereco_input;
		this.telefone_input = telefone_input;
	}
	
	public void actionPerformed(ActionEvent e){
		try {
		 cliente_controller.inserir(new Cliente(nome_input.getText(), cpf_input.getText(), endereco_input.getText(), telefone_input.getText()));
		 JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		 JFrame janela_cadastro_atual = (JFrame) ((JButton) e.getSource()).getTopLevelAncestor(); 
		 janela_cadastro_atual.dispose();
		 owner.dispose();
		 new JanelaClientes(cliente_controller);
		} catch(CJEException cjee){
			JOptionPane.showMessageDialog(null, cjee.getMessage(), "Falha", JOptionPane.INFORMATION_MESSAGE);
		}
		
	
	}

}
