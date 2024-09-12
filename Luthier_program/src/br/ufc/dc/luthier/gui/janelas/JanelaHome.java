package br.ufc.dc.luthier.gui.janelas;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.ufc.dc.luthier.gui.listeners.HomeBotaoClientesListener;
import br.ufc.dc.luthier.gui.listeners.HomeBotaoInstrumentosListener;
import br.ufc.dc.luthier.gui.listeners.HomeBotaoOrdensListener;

public class JanelaHome extends JFrame {
	
	public JanelaHome(){

		JLabel titulo = new JLabel("Bem vindo ao Luthier");
		JButton botao_clientes = new JButton ("Clientes");
		JButton botao_instrumentos = new JButton ("Instrumentos");
		JButton botao_ordens_de_servico = new JButton ("Ordens de servico");
		
		JPanel pane = new JPanel();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));  
		
		HomeBotaoClientesListener botao_clientes_listener = new HomeBotaoClientesListener();
		HomeBotaoInstrumentosListener botao_instrumentos_listener = new HomeBotaoInstrumentosListener();
		HomeBotaoOrdensListener botao_ordens_listener = new HomeBotaoOrdensListener();

        titulo.setAlignmentX(CENTER_ALIGNMENT);
        botao_clientes.setAlignmentX(CENTER_ALIGNMENT);
        botao_instrumentos.setAlignmentX(CENTER_ALIGNMENT);
        botao_ordens_de_servico.setAlignmentX(CENTER_ALIGNMENT);
	
        pane.add(Box.createVerticalStrut(20)); 
		pane.add(titulo);
		pane.add(Box.createVerticalStrut(40)); 
		pane.add(botao_clientes);
		pane.add(Box.createVerticalStrut(10));
		pane.add(botao_instrumentos);
		pane.add(Box.createVerticalStrut(10)); 
		pane.add(botao_ordens_de_servico);
		
		botao_clientes.addActionListener(botao_clientes_listener);
		botao_instrumentos.addActionListener(botao_instrumentos_listener);
		botao_ordens_de_servico.addActionListener(botao_ordens_listener);
		
		setSize(300, 250); 
		setLocationRelativeTo(null); 
		setContentPane(pane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); 
	}
}
//Jframe, Jpanel, JLabel(pode ter imagem dentro também), JTextArea, JButton, JTextField, JPasswordField, JRadioButton e JButtonGroup, JComboBox