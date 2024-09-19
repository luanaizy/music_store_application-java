package br.ufc.dc.luthier.gui.janelas.ordens;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JanelaCadastrarOrdem extends JFrame {
	public JanelaCadastrarOrdem() {
		setSize(600,450);
		setLocationRelativeTo(null);
		
		JLabel titulo = new JLabel("Criar Ordem De Serviço");
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel numero_label = new JLabel("Número:");
		numero_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel numero_input = new JLabel();

		
		JLabel situacao_label = new JLabel("Situação:");
		situacao_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		JComboBox situacao_input = new JComboBox();
		situacao_input.setMaximumSize(new Dimension(350, 35));
		
		JLabel proprietario_label = new JLabel("Cliente:");
		proprietario_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		JComboBox proprietario_input = new JComboBox();
		proprietario_input.setMaximumSize(new Dimension(350, 35));
		
		JLabel instrumento_codigo_label = new JLabel("Código do Instrumento:");
		instrumento_codigo_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		JComboBox instrumento_codigo_input = new JComboBox();
		instrumento_codigo_input.setMaximumSize(new Dimension(350, 35));
		
		JLabel instrumento_estado_label = new JLabel("Estado do instrumento:");
		instrumento_estado_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel instrumento_estado_input = new JLabel();
		
		JLabel servicos_label = new JLabel("Serviços:");
		servicos_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		JComboBox servicos_input = new JComboBox();
		servicos_input.setMaximumSize(new Dimension(350, 35));
		
		JLabel materiais_adicionais_label = new JLabel("Materiais Adicionais:");
		materiais_adicionais_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		JComboBox materiais_adicionais_input = new JComboBox(); //colocar na main
		materiais_adicionais_input.setMaximumSize(new Dimension(350, 35));	
		
		
		JButton botao_cadastrar = new JButton("Cadastrar");
		botao_cadastrar.setAlignmentX(Component.CENTER_ALIGNMENT);
		

		
		JPanel pane = new JPanel();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));  
		

		
		pane.add(Box.createVerticalStrut(20)); 
		pane.add(titulo);
		pane.add(Box.createVerticalStrut(40)); 	
		pane.add(numero_label);
		pane.add(numero_input);
		pane.add(Box.createVerticalStrut(10));
		pane.add(situacao_label);
		pane.add(situacao_input);
		pane.add(Box.createVerticalStrut(10)); 
		pane.add(proprietario_label);
		pane.add(proprietario_input);
		pane.add(Box.createVerticalStrut(10)); 
		pane.add(instrumento_codigo_label);
		pane.add(instrumento_codigo_input);
		pane.add(Box.createVerticalStrut(10)); 
		pane.add(instrumento_estado_label);
		pane.add(instrumento_estado_input);
		pane.add(Box.createVerticalStrut(10)); 
		pane.add(servicos_label);
		pane.add(servicos_input);
		pane.add(Box.createVerticalStrut(10)); 
		pane.add(materiais_adicionais_label);
		pane.add(materiais_adicionais_input);
		pane.add(Box.createVerticalStrut(30)); 
		pane.add(botao_cadastrar);
	
		JScrollPane scroll_pane = new JScrollPane(pane);
        scroll_pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		
		setContentPane(scroll_pane);
		setVisible(true);
	}
}
