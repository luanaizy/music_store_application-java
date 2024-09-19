package br.ufc.dc.luthier.gui.janelas.clientes;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import br.ufc.dc.luthier.gui.listeners.clientes.BotaoActionSalvarClienteListener;

public class JanelaEditarCliente extends JFrame {
	public JanelaEditarCliente() {
		setSize(600,450);
		setLocationRelativeTo(null);
		
		JLabel titulo = new JLabel("Editar Cliente");
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel nome_label = new JLabel("Nome:");
		nome_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		JTextArea nome_input = new JTextArea();
		nome_input.setMaximumSize(new Dimension(350, 35));
		
		JLabel cpf_label = new JLabel("CPF:");
		cpf_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		JTextArea cpf_input = new JTextArea();
		cpf_input.setMaximumSize(new Dimension(350, 35));

		
		JLabel endereco_label = new JLabel("Endereco:");
		endereco_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		JTextArea endereco_input = new JTextArea();
		endereco_input.setMaximumSize(new Dimension(350, 35));

		
		JLabel telefone_label = new JLabel("Telefone:");
		telefone_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		JTextArea telefone_input = new JTextArea();
		telefone_input.setMaximumSize(new Dimension(350, 35));
		
		JButton botao_salvar = new JButton("Salvar");
		botao_salvar.setAlignmentX(Component.CENTER_ALIGNMENT);
		botao_salvar.addActionListener(new BotaoActionSalvarClienteListener());
		
		JPanel pane = new JPanel();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));  
		
		pane.add(Box.createVerticalStrut(20)); 
		pane.add(titulo);
		pane.add(Box.createVerticalStrut(40)); 	
		pane.add(nome_label);
		pane.add(nome_input);
		pane.add(Box.createVerticalStrut(10));
		pane.add(cpf_label);
		pane.add(cpf_input);
		pane.add(Box.createVerticalStrut(10)); 
		pane.add(endereco_label);
		pane.add(endereco_input);
		pane.add(Box.createVerticalStrut(10)); 
		pane.add(telefone_label);
		pane.add(telefone_input);
		pane.add(Box.createVerticalStrut(30)); 
		pane.add(botao_salvar);
	
		

		
		setContentPane(pane);
		setVisible(true);
	}
}
