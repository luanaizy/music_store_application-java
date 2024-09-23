package br.ufc.dc.luthier.gui.listeners.ordens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

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
import br.ufc.dc.luthier.servicos.ServicoManutencaoTrocaDePeca;

public class BotaoEditarOrdemActionAddServicoTrocaDePecaListener  implements ActionListener {
	private int index;
	private Vector<ServicoAbstract> servicos;
	private Vector<Material> materiais;
	private Vector<Notificacao> notificacoes;
	private JanelaOrdensDeServico owner;
	private JanelaEditarOrdem owner_cadastro;
	private JTextArea valor_input;
	private JTextArea descricao_input;
	private JTextArea adicional_input;
	private ClienteController cliente_controller;
	private FuncionarioController funcionario_controller;
	private InstrumentoController instrumento_controller;
	private MaterialController material_controller;
	private OrdemController  ordem_controller;
	public BotaoEditarOrdemActionAddServicoTrocaDePecaListener( JanelaOrdensDeServico owner,int index,JanelaEditarOrdem owner_cadastro,Vector<ServicoAbstract> servicos,
			Vector<Material> materiais,Vector<Notificacao> notificacoes,JTextArea valor_input, JTextArea descricao_input, JTextArea adicional_input,
			 ClienteController cliente_controller, FuncionarioController funcionario_controller, 
			InstrumentoController instrumento_controller, MaterialController material_controller, OrdemController  ordem_controller) {
		this.servicos = servicos;
		this.materiais = materiais;
		this.notificacoes = notificacoes;
		this.owner = owner;
		this.owner_cadastro = owner_cadastro;
		this.valor_input = valor_input;
		this.descricao_input = descricao_input;
		this.adicional_input = adicional_input;
		this.cliente_controller = cliente_controller;
		this.funcionario_controller = funcionario_controller;
		this.instrumento_controller = instrumento_controller;
		this.material_controller = material_controller;
		this.ordem_controller = ordem_controller;
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		servicos.add(new ServicoManutencaoTrocaDePeca(descricao_input.getText(), 
				Double.valueOf(valor_input.getText()),adicional_input.getText()));
		JFrame janela_add_servico = (JFrame) ((JButton)e.getSource()).getTopLevelAncestor();
		janela_add_servico.dispose();
		owner_cadastro.dispose();
		new JanelaEditarOrdem( owner, servicos, materiais,notificacoes,index,  cliente_controller,  funcionario_controller, 
			 instrumento_controller,  material_controller,   ordem_controller);
	}
}
