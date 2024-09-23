package br.ufc.dc.luthier.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.ufc.dc.luthier.controllers.ClienteController;
import br.ufc.dc.luthier.controllers.FuncionarioController;
import br.ufc.dc.luthier.controllers.InstrumentoController;
import br.ufc.dc.luthier.gui.janelas.instrumentos.JanelaInstrumentos;

public class HomeBotaoInstrumentosListener implements ActionListener {
	private ClienteController cliente_controller;
	private InstrumentoController instrumento_controller;
	
	public HomeBotaoInstrumentosListener(ClienteController cliente_controller, InstrumentoController instrumento_controller) {
		this.cliente_controller = cliente_controller;
		this.instrumento_controller = instrumento_controller;
	}
	public void actionPerformed(ActionEvent evento){
		JanelaInstrumentos janela_instrumentos = new JanelaInstrumentos(cliente_controller, instrumento_controller);
	}
}
