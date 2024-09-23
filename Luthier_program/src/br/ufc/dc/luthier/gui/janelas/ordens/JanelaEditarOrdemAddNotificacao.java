package br.ufc.dc.luthier.gui.janelas.ordens;

import java.awt.Component;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import br.ufc.dc.luthier.controllers.ClienteController;
import br.ufc.dc.luthier.controllers.FuncionarioController;
import br.ufc.dc.luthier.controllers.InstrumentoController;
import br.ufc.dc.luthier.controllers.MaterialController;
import br.ufc.dc.luthier.controllers.OrdemController;
import br.ufc.dc.luthier.gui.listeners.ordens.BotaoEditarOrdemActionAddMaterialListener;
import br.ufc.dc.luthier.gui.listeners.ordens.BotaoEditarOrdemActionAddNotificacaoListener;
import br.ufc.dc.luthier.materiais.Material;
import br.ufc.dc.luthier.ordens.notificacoes.Notificacao;
import br.ufc.dc.luthier.servicos.ServicoAbstract;

public class JanelaEditarOrdemAddNotificacao extends JFrame {
	public JanelaEditarOrdemAddNotificacao(JanelaOrdensDeServico owner,int index_ordem, JanelaEditarOrdem owner_cadastro,
			Vector<ServicoAbstract> servicos,Vector<Material> materiais,Vector<Notificacao> notificacoes, ClienteController cliente_controller, FuncionarioController funcionario_controller, 
			InstrumentoController instrumento_controller, MaterialController material_controller, OrdemController  ordem_controller) {
		setSize(600,650);
		setLocationRelativeTo(null);
		
		JPanel pane = new JPanel();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));  

		JLabel titulo = new JLabel("Adicionar Notificacao");
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		

		JLabel mensagem_label = new JLabel("Mensagem:");
		mensagem_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		JTextArea mensagem_input = new JTextArea();
		mensagem_input.setMaximumSize(new Dimension(500, 35));
		mensagem_input.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton botao_adicionar = new JButton("Adicionar");
		botao_adicionar.setAlignmentX(Component.CENTER_ALIGNMENT);
		botao_adicionar.addActionListener(new BotaoEditarOrdemActionAddNotificacaoListener( mensagem_input, owner, index_ordem,  owner_cadastro,
				 servicos, materiais, notificacoes,  cliente_controller,  funcionario_controller, 
				 instrumento_controller,  material_controller,   ordem_controller));
		pane.add(Box.createVerticalStrut(40));
		pane.add(titulo);
		pane.add(Box.createVerticalStrut(20));
		pane.add(mensagem_label);
		pane.add(mensagem_input);
		pane.add(Box.createVerticalStrut(20));
		pane.add(botao_adicionar);
		
		setContentPane(pane);
		setVisible(true);
	}
}
