package br.ufc.dc.luthier.gui.listeners.instrumentos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.ufc.dc.luthier.controllers.ClienteController;
import br.ufc.dc.luthier.controllers.InstrumentoController;
import br.ufc.dc.luthier.exceptions.InstInexException;
import br.ufc.dc.luthier.gui.janelas.instrumentos.JanelaInstrumentos;

public class BotaoExcluirInstrumentoListener implements ActionListener {
	private InstrumentoController instrumento_controller;
	ClienteController cliente_controller;
	private String num_serie;
	
	public BotaoExcluirInstrumentoListener(String num_serie, ClienteController cliente_controller, InstrumentoController instrumento_controller) {
		this.instrumento_controller = instrumento_controller;
		this.cliente_controller = cliente_controller;
		this.num_serie = num_serie;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			instrumento_controller.remover(num_serie);
			JOptionPane.showMessageDialog(null,  "Instrumento removido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			JFrame janela_instrumentos = (JFrame) ((JButton)e.getSource()).getTopLevelAncestor();
			janela_instrumentos.dispose();
			new JanelaInstrumentos(cliente_controller, instrumento_controller);
		} catch (InstInexException iie) {
			JOptionPane.showMessageDialog(null,  iie.getMessage() + iie.getCodigo(), "Falha", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
