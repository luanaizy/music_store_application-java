package br.ufc.dc.luthier.gui.listeners.ordens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import br.ufc.dc.luthier.controllers.ClienteController;
import br.ufc.dc.luthier.controllers.FuncionarioController;
import br.ufc.dc.luthier.controllers.InstrumentoController;
import br.ufc.dc.luthier.controllers.MaterialController;
import br.ufc.dc.luthier.controllers.OrdemController;
import br.ufc.dc.luthier.gui.janelas.ordens.JanelaCadastrarOrdem;
import br.ufc.dc.luthier.gui.janelas.ordens.JanelaCadastrarOrdemAddServico;
import br.ufc.dc.luthier.gui.janelas.ordens.JanelaOrdensDeServico;
import br.ufc.dc.luthier.servicos.ServicoAbstract;

public class BotaoCadastrarOrdemAddServicoListener implements ActionListener {
	private Vector<ServicoAbstract> servicos;
	private JanelaOrdensDeServico owner;
	private JanelaCadastrarOrdem owner_cadastro;
	private ClienteController cliente_controller;
	private FuncionarioController funcionario_controller;
	private	InstrumentoController instrumento_controller;
	private MaterialController material_controller;
	private OrdemController  ordem_controller;
	
	public BotaoCadastrarOrdemAddServicoListener(JanelaOrdensDeServico owner, JanelaCadastrarOrdem owner_cadastro, Vector<ServicoAbstract> servicos, ClienteController cliente_controller, FuncionarioController funcionario_controller, 
			InstrumentoController instrumento_controller, MaterialController material_controller, OrdemController  ordem_controller) {
		this.servicos = servicos;
		this.owner = owner;
		this.owner_cadastro = owner_cadastro;
		this.cliente_controller = cliente_controller;
		this.funcionario_controller = funcionario_controller;
		this.instrumento_controller = instrumento_controller;
		this.material_controller = material_controller;
		this.ordem_controller = ordem_controller;

	}
	
	public void actionPerformed(ActionEvent e) {
		new JanelaCadastrarOrdemAddServico(owner,owner_cadastro,servicos, "CONSTRUCAO", cliente_controller,  funcionario_controller, 
				 instrumento_controller,  material_controller,   ordem_controller);
	}
}
