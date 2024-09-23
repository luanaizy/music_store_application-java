package br.ufc.dc.luthier.gui.listeners.instrumentos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.ufc.dc.luthier.controllers.ClienteController;
import br.ufc.dc.luthier.controllers.InstrumentoController;
import br.ufc.dc.luthier.gui.janelas.instrumentos.JanelaCadastrarInstrumento;
import br.ufc.dc.luthier.gui.janelas.instrumentos.JanelaInstrumentos;

public class BotaoCadastrarInstrumentoListener implements ActionListener {
	private ClienteController cliente_controller;
	private InstrumentoController instrumento_controller;
	private JanelaInstrumentos owner;
	public BotaoCadastrarInstrumentoListener(JanelaInstrumentos owner, ClienteController cliente_controller, InstrumentoController instrumento_controller) {
		this.cliente_controller = cliente_controller;
		this.instrumento_controller = instrumento_controller;
		this.owner = owner;
	}
	
	public void actionPerformed(ActionEvent e) {
		JanelaCadastrarInstrumento janela_cadastrar_instrumento = 
				new JanelaCadastrarInstrumento(owner, cliente_controller, instrumento_controller);
	}
}
