package br.ufc.dc.luthier.gui.janelas.instrumentos;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JanelaInstrumentos extends JFrame {
	public JanelaInstrumentos() {
		setSize(800,700);
		setLocationRelativeTo(null);
		
		JPanel pane = new JPanel();
		setContentPane(pane);
		setVisible(true);
	}

}
