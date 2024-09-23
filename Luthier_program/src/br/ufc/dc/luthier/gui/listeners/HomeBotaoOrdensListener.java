package br.ufc.dc.luthier.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.ufc.dc.luthier.controllers.ClienteController;
import br.ufc.dc.luthier.controllers.FuncionarioController;
import br.ufc.dc.luthier.controllers.InstrumentoController;
import br.ufc.dc.luthier.controllers.MaterialController;
import br.ufc.dc.luthier.controllers.OrdemController;
import br.ufc.dc.luthier.gui.janelas.ordens.JanelaOrdensDeServico;

public class HomeBotaoOrdensListener implements ActionListener {
	private ClienteController cliente_controller;
	private FuncionarioController funcionario_controller;
	private	InstrumentoController instrumento_controller;
	private MaterialController material_controller;
	private OrdemController  ordem_controller;
	
	public HomeBotaoOrdensListener(ClienteController cliente_controller, FuncionarioController funcionario_controller, 
			InstrumentoController instrumento_controller, MaterialController material_controller, OrdemController  ordem_controller) {
		this.cliente_controller = cliente_controller;
		this.funcionario_controller = funcionario_controller;
		this.instrumento_controller = instrumento_controller;
		this.material_controller = material_controller;
		this.ordem_controller = ordem_controller;
	}
	public void actionPerformed(ActionEvent evento){
		JanelaOrdensDeServico janela_ordens = new JanelaOrdensDeServico(cliente_controller, funcionario_controller, 
				instrumento_controller,  material_controller, ordem_controller);
	}
}
