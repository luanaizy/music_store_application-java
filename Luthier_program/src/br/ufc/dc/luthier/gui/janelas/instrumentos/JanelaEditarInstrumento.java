package br.ufc.dc.luthier.gui.janelas.instrumentos;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import br.ufc.dc.luthier.controllers.ClienteController;
import br.ufc.dc.luthier.controllers.InstrumentoController;
import br.ufc.dc.luthier.gui.janelas.clientes.JanelaClientes;
import br.ufc.dc.luthier.gui.listeners.instrumentos.BotaoActionSalvarInstrumentoListener;
import br.ufc.dc.luthier.instrumentos.Instrumento;
import br.ufc.dc.luthier.pessoas.Cliente;

public class JanelaEditarInstrumento extends JFrame {
	public JanelaEditarInstrumento(int index, JanelaInstrumentos owner, ClienteController cliente_controller, InstrumentoController instrumento_controller) {
		setSize(600,450);
		setLocationRelativeTo(null);
		
		Instrumento instrumento = instrumento_controller.get(index);
		
		JLabel titulo = new JLabel("Editar Instrumento");
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel num_serie_label = new JLabel("Numero de Serie:");
		num_serie_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		JTextArea num_serie_input = new JTextArea(instrumento.getNumDeSerie());
		num_serie_input.setMaximumSize(new Dimension(350, 35));

		JLabel tipo_label = new JLabel("Tipo:");
		tipo_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		JTextArea tipo_input = new JTextArea(instrumento.getTipo());
		tipo_input.setMaximumSize(new Dimension(350, 35));
		
		JLabel marca_label = new JLabel("Marca:");
		marca_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		JTextArea marca_input = new JTextArea(instrumento.getMarca());
		marca_input.setMaximumSize(new Dimension(350, 35));

		
		JLabel proprietario_label = new JLabel("Proprietario:");
		proprietario_label.setAlignmentX(Component.CENTER_ALIGNMENT);		
		JComboBox<String> proprietario_input = new JComboBox<>();
		
		for (int i=0;i<cliente_controller.qtd_clientes();i++) {
			Cliente cliente = cliente_controller.get(i);
			String cliente_info = cliente.getCpf() + " - " + cliente.getNome();
			proprietario_input.addItem(cliente_info);
			
			if (instrumento.getProprietario().getCpf().equals(cliente.getCpf())) {
				proprietario_input.setSelectedItem(cliente_info);
			}
		}
		
		proprietario_input.setMaximumSize(new Dimension(350, 35));
		
		JButton botao_cadastrar = new JButton("Salvar");
		botao_cadastrar.setAlignmentX(Component.CENTER_ALIGNMENT);
		botao_cadastrar.addActionListener(new BotaoActionSalvarInstrumentoListener( index,num_serie_input, tipo_input,marca_input,proprietario_input, 
				cliente_controller,instrumento_controller, owner));

		
		JPanel pane = new JPanel();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));  
		
		pane.add(Box.createVerticalStrut(20)); 
		pane.add(titulo);
		pane.add(Box.createVerticalStrut(40)); 	
		pane.add(num_serie_label);
		pane.add(num_serie_input);
		pane.add(Box.createVerticalStrut(10));
		pane.add(tipo_label);
		pane.add(tipo_input);
		pane.add(Box.createVerticalStrut(10));
		pane.add(marca_label);
		pane.add(marca_input);
		pane.add(Box.createVerticalStrut(10)); 
		pane.add(proprietario_label);
		pane.add(proprietario_input);
		pane.add(Box.createVerticalStrut(30)); 
		pane.add(botao_cadastrar);
	
		

		
		setContentPane(pane);
		setVisible(true);
	}
}
