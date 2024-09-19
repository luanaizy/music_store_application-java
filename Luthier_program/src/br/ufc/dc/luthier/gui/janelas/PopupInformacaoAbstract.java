package br.ufc.dc.luthier.gui.janelas;

import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class PopupInformacaoAbstract extends JFrame {
	public PopupInformacaoAbstract(String informacao, ActionListener listener) {
		setSize(400,150);
		setLocationRelativeTo(null);
		
		JLabel label_informacao = new JLabel(informacao);
		label_informacao.setAlignmentX(CENTER_ALIGNMENT);
		JButton botao_ok = new JButton("Ok");
		botao_ok.setAlignmentX(CENTER_ALIGNMENT);
		botao_ok.addActionListener(listener);
		
		JPanel pane = new JPanel();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		pane.add(Box.createVerticalStrut(10));
		pane.add(label_informacao);
		pane.add(Box.createVerticalStrut(30));
		pane.add(botao_ok);
		setContentPane(pane);
		
		setVisible(true);
	}
}
