package br.ufc.dc.luthier.gui.listeners.instrumentos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import br.ufc.dc.luthier.controllers.ClienteController;
import br.ufc.dc.luthier.controllers.InstrumentoController;
import br.ufc.dc.luthier.exceptions.InstJaExisteException;
import br.ufc.dc.luthier.gui.janelas.instrumentos.JanelaInstrumentos;

public class BotaoActionSalvarInstrumentoListener implements ActionListener {
	private int index;
	private JTextArea num_serie_input;
	private JTextArea tipo_input;
	private JTextArea marca_input;
	private JComboBox<String> proprietario_input;
	private ClienteController cliente_controller;
	private InstrumentoController instrumento_controller;
	private JanelaInstrumentos owner;
	
	public BotaoActionSalvarInstrumentoListener(int index, JTextArea num_serie_input, JTextArea tipo_input, JTextArea marca_input, JComboBox<String> proprietario_input,
			ClienteController cliente_controller, InstrumentoController instrumento_controller, JanelaInstrumentos owner) {
		this.index = index;
		this.owner = owner;
		this.num_serie_input = num_serie_input;
		this.tipo_input = tipo_input;
		this.marca_input = marca_input;
		this.proprietario_input = proprietario_input;
		this.cliente_controller = cliente_controller;
		this.instrumento_controller = instrumento_controller;
	}
	public void actionPerformed(ActionEvent e){
		String proprietario = (String) proprietario_input.getSelectedItem();
		String cpf = proprietario.split(" - ")[0];
		try {
			instrumento_controller.modificar(index, num_serie_input.getText(), tipo_input.getText(), marca_input.getText(),
					instrumento_controller.get(index).getEstado(), cliente_controller.procurar(cpf));
			JOptionPane.showMessageDialog(null,  "Instrumento modificado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			JFrame janela_cadastro = (JFrame) ((JButton)e.getSource()).getTopLevelAncestor();
			janela_cadastro.dispose();
			owner.dispose();
			new JanelaInstrumentos(cliente_controller, instrumento_controller);
		} catch (InstJaExisteException ije) {
			JOptionPane.showMessageDialog(null,  ije.getMessage() + ije.getNumDeSerie(), "Falha", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
