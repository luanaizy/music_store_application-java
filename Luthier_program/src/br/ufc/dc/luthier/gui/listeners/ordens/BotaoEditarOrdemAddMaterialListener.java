package br.ufc.dc.luthier.gui.listeners.ordens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import br.ufc.dc.luthier.controllers.ClienteController;
import br.ufc.dc.luthier.controllers.FuncionarioController;
import br.ufc.dc.luthier.controllers.InstrumentoController;
import br.ufc.dc.luthier.controllers.MaterialController;
import br.ufc.dc.luthier.controllers.OrdemController;
import br.ufc.dc.luthier.gui.janelas.ordens.JanelaEditarOrdem;
import br.ufc.dc.luthier.gui.janelas.ordens.JanelaEditarOrdemAddMaterial;
import br.ufc.dc.luthier.gui.janelas.ordens.JanelaEditarOrdemAddNotificacao;
import br.ufc.dc.luthier.gui.janelas.ordens.JanelaOrdensDeServico;
import br.ufc.dc.luthier.materiais.Material;
import br.ufc.dc.luthier.ordens.notificacoes.Notificacao;
import br.ufc.dc.luthier.servicos.ServicoAbstract;

public class BotaoEditarOrdemAddMaterialListener implements ActionListener {
	private int index_ordem;
	private Vector<ServicoAbstract> servicos;
	private Vector<Material> materiais;
	private Vector<Notificacao> notificacoes;
	private JanelaOrdensDeServico owner;
	private JanelaEditarOrdem owner_cadastro;
	private ClienteController cliente_controller;
	private FuncionarioController funcionario_controller;
	private	InstrumentoController instrumento_controller;
	private MaterialController material_controller;
	private OrdemController  ordem_controller;
	
	public BotaoEditarOrdemAddMaterialListener( JanelaOrdensDeServico owner,int index_ordem, JanelaEditarOrdem owner_cadastro,
			Vector<ServicoAbstract> servicos,Vector<Material> materiais,Vector<Notificacao> notificacoes, ClienteController cliente_controller, FuncionarioController funcionario_controller, 
			InstrumentoController instrumento_controller, MaterialController material_controller, OrdemController  ordem_controller) {
		this.servicos = servicos;
		this.materiais = materiais;
		this.notificacoes = notificacoes;
		this.owner = owner;
		this.owner_cadastro = owner_cadastro;
		this.cliente_controller = cliente_controller;
		this.funcionario_controller = funcionario_controller;
		this.instrumento_controller = instrumento_controller;
		this.material_controller = material_controller;
		this.ordem_controller = ordem_controller;
	
	}
	public void actionPerformed(ActionEvent e) {
		new JanelaEditarOrdemAddMaterial( owner, index_ordem,  owner_cadastro,
				 servicos, materiais, notificacoes,  cliente_controller,  funcionario_controller, 
				 instrumento_controller,  material_controller,   ordem_controller);
	}
}