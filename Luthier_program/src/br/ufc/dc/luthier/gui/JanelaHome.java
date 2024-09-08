package br.ufc.dc.luthier.gui;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JanelaHome extends JFrame {
	
	public JanelaHome(){
		JLabel titulo = new JLabel("Bem vindo ao Luthier");
		JButton botao_clientes = new JButton ("Clientes");
		JButton botao_instrumentos = new JButton ("Instrumentos");
		JButton botao_ordens_de_servico = new JButton ("Ordens de servico");
		
		JPanel pane = new JPanel();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS)); 
		
		OuvinteDeRota listener = new OuvinteDeRota();
		
        titulo.setAlignmentX(CENTER_ALIGNMENT);
        botao_clientes.setAlignmentX(CENTER_ALIGNMENT);
        botao_instrumentos.setAlignmentX(CENTER_ALIGNMENT);
        botao_ordens_de_servico.setAlignmentX(CENTER_ALIGNMENT);
		
		pane.add(titulo);
		pane.add(Box.createVerticalStrut(50)); 
		pane.add(botao_clientes);
		pane.add(Box.createVerticalStrut(10)); 
		pane.add(botao_instrumentos);
		pane.add(Box.createVerticalStrut(10)); 
		pane.add(botao_ordens_de_servico);
		
		botao_clientes.addActionListener(listener);
		
		setContentPane(pane);
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
//Jframe, Jpanel, JLabel(pode ter imagem dentro também), JTextArea, JButton, JTextField, JPasswordField, JRadioButton e JButtonGroup, JComboBox