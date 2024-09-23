package br.ufc.dc.luthier.gui.listeners.ordens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import br.ufc.dc.luthier.controllers.ClienteController;
import br.ufc.dc.luthier.controllers.FuncionarioController;
import br.ufc.dc.luthier.controllers.InstrumentoController;
import br.ufc.dc.luthier.controllers.MaterialController;
import br.ufc.dc.luthier.controllers.OrdemController;
import br.ufc.dc.luthier.gui.janelas.ordens.JanelaEditarOrdem;
import br.ufc.dc.luthier.gui.janelas.ordens.JanelaOrdensDeServico;
import br.ufc.dc.luthier.materiais.Material;
import br.ufc.dc.luthier.ordens.notificacoes.Notificacao;
import br.ufc.dc.luthier.servicos.ServicoAbstract;

public class BotaoEditarOrdemActionAddMaterialListener implements ActionListener {
	private JComboBox<String> material_input;
	private JanelaOrdensDeServico owner;
	private int index_ordem;
	private JanelaEditarOrdem owner_cadastro;
	private	Vector<ServicoAbstract> servicos;
	private Vector<Material> materiais;
	private Vector<Notificacao> notificacoes;
	private ClienteController cliente_controller;
	private FuncionarioController funcionario_controller;
	private InstrumentoController instrumento_controller;
	private MaterialController material_controller;
	private OrdemController  ordem_controller;
	public BotaoEditarOrdemActionAddMaterialListener(JComboBox<String> material_input, JanelaOrdensDeServico owner,int index_ordem, JanelaEditarOrdem owner_cadastro,
				Vector<ServicoAbstract> servicos,Vector<Material> materiais,Vector<Notificacao> notificacoes, ClienteController cliente_controller, FuncionarioController funcionario_controller, 
				InstrumentoController instrumento_controller, MaterialController material_controller, OrdemController  ordem_controller) {
		this.material_input = material_input;
		this.owner = owner;
		this.index_ordem = index_ordem;
		this.owner_cadastro = owner_cadastro;
		this.servicos = servicos;
		this.materiais = materiais;
		this.notificacoes = notificacoes;
		this.cliente_controller = cliente_controller;
		this.funcionario_controller = funcionario_controller;
		this.instrumento_controller = instrumento_controller;
		this.material_controller = material_controller;
		this.ordem_controller = ordem_controller;
	}
	public void actionPerformed(ActionEvent e) {

			String material_selecionado = (String) material_input.getSelectedItem();
			String codigo = material_selecionado.split(" - ")[0];
			materiais.add(material_controller.procurar(codigo));
			JFrame janela_cadastro = (JFrame) ((JButton)e.getSource()).getTopLevelAncestor();
			janela_cadastro.dispose();
			owner_cadastro.dispose();
			new JanelaEditarOrdem( owner, servicos,materiais,  notificacoes,  index_ordem,  cliente_controller,  funcionario_controller, 
		   			 instrumento_controller,  material_controller,   ordem_controller);

	}
}
