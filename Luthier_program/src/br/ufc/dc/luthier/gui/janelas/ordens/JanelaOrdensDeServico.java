package br.ufc.dc.luthier.gui.janelas.ordens;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JanelaOrdensDeServico extends JFrame {
	public JanelaOrdensDeServico() {
		setSize(800,700);
		setLocationRelativeTo(null);
		
		JPanel pane = new JPanel();
		setContentPane(pane);
		setVisible(true);
	}
}
