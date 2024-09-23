package br.ufc.dc.luthier.gui.listeners.instrumentos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.ufc.dc.luthier.controllers.ClienteController;
import br.ufc.dc.luthier.controllers.InstrumentoController;
import br.ufc.dc.luthier.gui.janelas.instrumentos.JanelaEditarInstrumento;
import br.ufc.dc.luthier.gui.janelas.instrumentos.JanelaInstrumentos;

public class BotaoEditarInstrumentoListener implements ActionListener {
	private ClienteController cliente_controller;
	private InstrumentoController instrumento_controller;
	private int index;
	private JanelaInstrumentos owner;
	
	public BotaoEditarInstrumentoListener(int index, JanelaInstrumentos owner, ClienteController cliente_controller, InstrumentoController instrumento_controller) {
		this.cliente_controller = cliente_controller;
		this.instrumento_controller = instrumento_controller;
		this.index = index;
		this.owner = owner;
	}
	
	public void actionPerformed(ActionEvent e) {
		JanelaEditarInstrumento janela_editar_instrumento = new JanelaEditarInstrumento(index, owner,  cliente_controller, instrumento_controller);
	}
}
