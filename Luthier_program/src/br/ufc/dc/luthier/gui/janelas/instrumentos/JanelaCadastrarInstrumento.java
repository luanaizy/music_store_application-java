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

public class JanelaCadastrarInstrumento extends JFrame {
	public JanelaCadastrarInstrumento() {
		setSize(600,450);
		setLocationRelativeTo(null);
		
		JLabel titulo = new JLabel("Cadastrar Instrumento");
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel tipo_label = new JLabel("Tipo:");
		tipo_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		JTextArea tipo_input = new JTextArea();
		tipo_input.setMaximumSize(new Dimension(350, 35));
		
		JLabel marca_label = new JLabel("Marca:");
		marca_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		JTextArea marca_input = new JTextArea();
		marca_input.setMaximumSize(new Dimension(350, 35));

		
		JLabel proprietario_label = new JLabel("Proprietario:");
		proprietario_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		JComboBox proprietario_input = new JComboBox();
		proprietario_input.setMaximumSize(new Dimension(350, 35));
		
		JButton botao_cadastrar = new JButton("Cadastrar");
		botao_cadastrar.setAlignmentX(Component.CENTER_ALIGNMENT);
		

		
		JPanel pane = new JPanel();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));  
		
		pane.add(Box.createVerticalStrut(20)); 
		pane.add(titulo);
		pane.add(Box.createVerticalStrut(40)); 	
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
