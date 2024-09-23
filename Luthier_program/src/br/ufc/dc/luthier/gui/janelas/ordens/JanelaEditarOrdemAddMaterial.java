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

import br.ufc.dc.luthier.controllers.ClienteController;
import br.ufc.dc.luthier.controllers.FuncionarioController;
import br.ufc.dc.luthier.controllers.InstrumentoController;
import br.ufc.dc.luthier.controllers.MaterialController;
import br.ufc.dc.luthier.controllers.OrdemController;
import br.ufc.dc.luthier.gui.listeners.ordens.BotaoEditarOrdemActionAddMaterialListener;
import br.ufc.dc.luthier.materiais.Material;
import br.ufc.dc.luthier.ordens.notificacoes.Notificacao;
import br.ufc.dc.luthier.servicos.ServicoAbstract;

public class JanelaEditarOrdemAddMaterial extends JFrame{
	public JanelaEditarOrdemAddMaterial( JanelaOrdensDeServico owner,int index_ordem, JanelaEditarOrdem owner_cadastro,
			Vector<ServicoAbstract> servicos,Vector<Material> materiais,Vector<Notificacao> notificacoes, ClienteController cliente_controller, FuncionarioController funcionario_controller, 
			InstrumentoController instrumento_controller, MaterialController material_controller, OrdemController  ordem_controller) {
		setSize(600,650);
		setLocationRelativeTo(null);
		
		JPanel pane = new JPanel();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));  

		JLabel titulo = new JLabel("Adicionar Material");
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel material_label = new JLabel("Material:");
		material_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		JComboBox<String> material_input = new JComboBox<>();
		material_input.setMaximumSize(new Dimension(350, 35));
		material_input.setAlignmentX(Component.CENTER_ALIGNMENT);
		for (int i=0;i<material_controller.qtd_materiais();i++) {
			Material material = material_controller.get(i);
			String material_info = material.getCodigo() + " - " + material.getTipo() + ", " + material.getMarca();
			material_input.addItem(material_info);

		}
		pane.add(Box.createVerticalStrut(40));
		pane.add(titulo);
		pane.add(Box.createVerticalStrut(20));
		pane.add(material_label);
		pane.add(material_input);
		
		JButton botao_adicionar = new JButton("Adicionar");
		botao_adicionar.setAlignmentX(Component.CENTER_ALIGNMENT);
		botao_adicionar.addActionListener(new BotaoEditarOrdemActionAddMaterialListener( material_input,  owner, index_ordem,  owner_cadastro,
				 servicos, materiais, notificacoes,  cliente_controller,  funcionario_controller, 
				 instrumento_controller,  material_controller,   ordem_controller));
		pane.add(Box.createVerticalStrut(20));
		pane.add(botao_adicionar);
		
		setContentPane(pane);
		setVisible(true);
	}
}
