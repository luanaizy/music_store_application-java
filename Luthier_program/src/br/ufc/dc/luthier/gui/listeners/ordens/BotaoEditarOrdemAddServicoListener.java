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
import br.ufc.dc.luthier.gui.janelas.ordens.JanelaEditarOrdemAddServico;
import br.ufc.dc.luthier.gui.janelas.ordens.JanelaOrdensDeServico;
import br.ufc.dc.luthier.materiais.Material;
import br.ufc.dc.luthier.ordens.notificacoes.Notificacao;
import br.ufc.dc.luthier.servicos.ServicoAbstract;

public class BotaoEditarOrdemAddServicoListener implements ActionListener {
	private Vector<ServicoAbstract> servicos;
	private Vector<Material> materiais;
	private Vector<Notificacao> notificacoes;
	private int index;
	private JanelaOrdensDeServico owner;
	private JanelaEditarOrdem owner_cadastro;
	private ClienteController cliente_controller;
	private FuncionarioController funcionario_controller;
	private	InstrumentoController instrumento_controller;
	private MaterialController material_controller;
	private OrdemController  ordem_controller;
	
	public BotaoEditarOrdemAddServicoListener(JanelaOrdensDeServico owner, int index, JanelaEditarOrdem owner_cadastro, Vector<ServicoAbstract> servicos,
			Vector<Material> materiais, Vector<Notificacao> notificacoes, ClienteController cliente_controller, FuncionarioController funcionario_controller, 
			InstrumentoController instrumento_controller, MaterialController material_controller, OrdemController  ordem_controller) {
		this.servicos = servicos;
		this.materiais = materiais;
		this.notificacoes = notificacoes;
		this.owner = owner;
		this.index=index;
		this.owner_cadastro = owner_cadastro;
		this.cliente_controller = cliente_controller;
		this.funcionario_controller = funcionario_controller;
		this.instrumento_controller = instrumento_controller;
		this.material_controller = material_controller;
		this.ordem_controller = ordem_controller;

	}
	
	public void actionPerformed(ActionEvent e) {
		new JanelaEditarOrdemAddServico(owner,index,owner_cadastro,servicos,materiais, notificacoes, "CONSTRUCAO", cliente_controller,  funcionario_controller, 
				 instrumento_controller,  material_controller,   ordem_controller);
	}
}
