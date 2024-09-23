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
import br.ufc.dc.luthier.gui.janelas.ordens.JanelaCadastrarOrdem;
import br.ufc.dc.luthier.gui.janelas.ordens.JanelaOrdensDeServico;
import br.ufc.dc.luthier.servicos.ServicoAbstract;
import br.ufc.dc.luthier.servicos.ServicoConstrucao;
import br.ufc.dc.luthier.servicos.ServicoManutencaoTrocaDePeca;

public class BotaoCadastrarOrdemActionAddServicoConstrucaoListener implements ActionListener {
	private Vector<ServicoAbstract> servicos;
	private JanelaOrdensDeServico owner;
	private  JanelaCadastrarOrdem owner_cadastro;
	private JTextArea valor_input;
	private JTextArea descricao_input;
	private ClienteController cliente_controller;
	private FuncionarioController funcionario_controller;
	private InstrumentoController instrumento_controller;
	private MaterialController material_controller;
	private OrdemController  ordem_controller;
	public BotaoCadastrarOrdemActionAddServicoConstrucaoListener( JanelaOrdensDeServico owner,JanelaCadastrarOrdem owner_cadastro,Vector<ServicoAbstract> servicos,
			JTextArea valor_input, JTextArea descricao_input, ClienteController cliente_controller, FuncionarioController funcionario_controller, 
			InstrumentoController instrumento_controller, MaterialController material_controller, OrdemController  ordem_controller) {
		this.servicos = servicos;
		this.owner = owner;
		this.owner_cadastro = owner_cadastro;
		this.valor_input = valor_input;
		this.descricao_input = descricao_input;
		this.cliente_controller = cliente_controller;
		this.funcionario_controller = funcionario_controller;
		this.instrumento_controller = instrumento_controller;
		this.material_controller = material_controller;
		this.ordem_controller = ordem_controller;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		servicos.add(new ServicoConstrucao(descricao_input.getText(), 
				Double.valueOf(valor_input.getText())));
		JFrame janela_add_servico = (JFrame) ((JButton)e.getSource()).getTopLevelAncestor();
		janela_add_servico.dispose();
		owner_cadastro.dispose();
		new JanelaCadastrarOrdem( owner, servicos,  cliente_controller,  funcionario_controller, 
			 instrumento_controller,  material_controller,   ordem_controller);
	}
}
