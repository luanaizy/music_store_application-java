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
import br.ufc.dc.luthier.gui.listeners.ordens.BotaoCadastrarOrdemActionAddServicoConsertoListener;
import br.ufc.dc.luthier.gui.listeners.ordens.BotaoCadastrarOrdemActionAddServicoConstrucaoListener;
import br.ufc.dc.luthier.gui.listeners.ordens.BotaoCadastrarOrdemActionAddServicoRegulagemListener;
import br.ufc.dc.luthier.gui.listeners.ordens.BotaoCadastrarOrdemActionAddServicoRevisaoListener;
import br.ufc.dc.luthier.gui.listeners.ordens.BotaoCadastrarOrdemActionAddServicoTrocaDePecaListener;
import br.ufc.dc.luthier.gui.listeners.ordens.ComboboxCadastrarOrdemAddServicoListener;
import br.ufc.dc.luthier.servicos.ServicoAbstract;

public class JanelaCadastrarOrdemAddServico extends JFrame {
	public JanelaCadastrarOrdemAddServico(JanelaOrdensDeServico owner,JanelaCadastrarOrdem owner_cadastro,Vector<ServicoAbstract> servicos, String servico_selecionado,
			ClienteController cliente_controller, FuncionarioController funcionario_controller, 
			InstrumentoController instrumento_controller, MaterialController material_controller, OrdemController  ordem_controller) {
		setSize(600,650);
		setLocationRelativeTo(null);
		
		JPanel pane = new JPanel();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));  

		JLabel titulo = new JLabel("Adicionar Serviço");
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		JLabel tipo_servico_label = new JLabel("Tipo de servico:");
		tipo_servico_label.setAlignmentX(Component.CENTER_ALIGNMENT);

		JComboBox<String> tipo_servico_input  = new JComboBox<>();
		tipo_servico_input.setMaximumSize(new Dimension(350, 35));		
		tipo_servico_input.addItem("CONSTRUCAO");
		tipo_servico_input.addItem("MANUTENCAO - CONSERTO");
		tipo_servico_input.addItem("MANUTENCAO - REGULAGEM");
		tipo_servico_input.addItem("MANUTENCAO - TROCA DE PECA");
		tipo_servico_input.addItem("REVISAO");
		tipo_servico_input.setSelectedItem(servico_selecionado);
		tipo_servico_input.addActionListener(new ComboboxCadastrarOrdemAddServicoListener( owner, owner_cadastro, servicos, tipo_servico_input, 
				 cliente_controller,  funcionario_controller, instrumento_controller,  material_controller,   ordem_controller));
		
		JLabel valor_label = new JLabel("Valor:");
		valor_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		JTextArea valor_input = new JTextArea();
		valor_input.setMaximumSize(new Dimension(350, 35));
		
		JLabel descricao_label = new JLabel("Descricao:");
		descricao_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		JTextArea descricao_input = new JTextArea();
		descricao_input.setMaximumSize(new Dimension(350, 35));
		
		pane.add(Box.createVerticalStrut(20));
		pane.add(titulo);
		pane.add(Box.createVerticalStrut(40));
		pane.add(tipo_servico_label);
		pane.add(tipo_servico_input);
		pane.add(Box.createVerticalStrut(10));
		pane.add(valor_label);
		pane.add(valor_input);
		pane.add(Box.createVerticalStrut(10));
		pane.add(descricao_label);
		pane.add(descricao_input);
		pane.add(Box.createVerticalStrut(10));

		if(servico_selecionado.equals("MANUTENCAO - CONSERTO")) {
			JLabel adicional_label = new JLabel("Peca consertada: ");
			adicional_label.setAlignmentX(Component.CENTER_ALIGNMENT);
			JTextArea adicional_input = new JTextArea();
			adicional_input.setMaximumSize(new Dimension(350, 35));

			JButton adicionar_button = new JButton("Adicionar");
			adicionar_button.setAlignmentX(Component.CENTER_ALIGNMENT);
			adicionar_button.addActionListener(new BotaoCadastrarOrdemActionAddServicoConsertoListener(owner,owner_cadastro,servicos, valor_input, descricao_input,adicional_input,
					  cliente_controller,  funcionario_controller, instrumento_controller,  material_controller,   ordem_controller));
			
			pane.add(adicional_label);
			pane.add(adicional_input);
			pane.add(Box.createVerticalStrut(10));
			pane.add(adicionar_button);
			
		} else if (servico_selecionado.equals("MANUTENCAO - REGULAGEM")) {
			JLabel adicional_label = new JLabel("Regulagem de: ");
			adicional_label.setAlignmentX(Component.CENTER_ALIGNMENT);
			JTextArea adicional_input = new JTextArea();
			adicional_input.setMaximumSize(new Dimension(350, 35));
			
			JButton adicionar_button = new JButton("Adicionar");
			adicionar_button.addActionListener(new BotaoCadastrarOrdemActionAddServicoRegulagemListener(owner,owner_cadastro,servicos, valor_input, descricao_input,adicional_input,
					  cliente_controller,  funcionario_controller, instrumento_controller,  material_controller,   ordem_controller));
			adicionar_button.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			pane.add(adicional_label);
			pane.add(adicional_input);
			pane.add(Box.createVerticalStrut(10));
			pane.add(adicionar_button);
			
		}else if (servico_selecionado.equals("MANUTENCAO - TROCA DE PECA")) {
			JLabel adicional_label = new JLabel("Peca trocada: ");
			adicional_label.setAlignmentX(Component.CENTER_ALIGNMENT);
			JTextArea adicional_input = new JTextArea();
			adicional_input.setMaximumSize(new Dimension(350, 35));
		
			
			JButton adicionar_button = new JButton("Adicionar");
			adicionar_button.addActionListener(new BotaoCadastrarOrdemActionAddServicoTrocaDePecaListener(owner,owner_cadastro,servicos, valor_input, descricao_input,adicional_input,
					  cliente_controller,  funcionario_controller, instrumento_controller,  material_controller,   ordem_controller));
			adicionar_button.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			pane.add(adicional_label);
			pane.add(adicional_input);
			pane.add(Box.createVerticalStrut(10));
			pane.add(adicionar_button);
			
		}else if (servico_selecionado.equals("REVISAO")) {
			JLabel adicional_label = new JLabel("Resultado: ");
			adicional_label.setAlignmentX(Component.CENTER_ALIGNMENT);
			JTextArea adicional_input = new JTextArea();
			adicional_input.setMaximumSize(new Dimension(350, 35));
			
			JLabel servico_recomendado_label = new JLabel("Servico Recomendado: ");
			servico_recomendado_label.setAlignmentX(Component.CENTER_ALIGNMENT);
			JLabel tipo_servico_recomendado_label = new JLabel("Tipo de servico:");
			tipo_servico_recomendado_label.setAlignmentX(Component.CENTER_ALIGNMENT);
			JComboBox<String> tipo_servico_recomendado_input  = new JComboBox<>();
			tipo_servico_recomendado_input.setMaximumSize(new Dimension(350, 35));		
			tipo_servico_recomendado_input.addItem("MANUTENCAO - CONSERTO");
			tipo_servico_recomendado_input.addItem("MANUTENCAO - REGULAGEM");
			tipo_servico_recomendado_input.addItem("MANUTENCAO - TROCA DE PECA");
			
			
			JLabel servico_recomendado_valor_label = new JLabel("Valor:");
			servico_recomendado_valor_label.setAlignmentX(Component.CENTER_ALIGNMENT);
			JTextArea servico_recomendado_valor_input = new JTextArea();
			servico_recomendado_valor_input.setMaximumSize(new Dimension(350, 35));
			
			JLabel servico_recomendado_descricao_label = new JLabel("Descricao:");
			servico_recomendado_descricao_label.setAlignmentX(Component.CENTER_ALIGNMENT);
			JTextArea servico_recomendado_descricao_input = new JTextArea();
			servico_recomendado_descricao_input.setMaximumSize(new Dimension(350, 35));
			
			JLabel servico_recomendado_adicional_label = new JLabel("Peca consertada / antiga/ regulada:");
			servico_recomendado_adicional_label.setAlignmentX(Component.CENTER_ALIGNMENT);
			JTextArea servico_recomendado_adicional_input = new JTextArea();
			servico_recomendado_adicional_input.setMaximumSize(new Dimension(350, 35));
			
			
			JButton adicionar_button = new JButton("Adicionar");
			adicionar_button.addActionListener(new BotaoCadastrarOrdemActionAddServicoRevisaoListener(owner,owner_cadastro,servicos, valor_input, descricao_input,adicional_input,
					tipo_servico_recomendado_input, servico_recomendado_valor_input, servico_recomendado_descricao_input,servico_recomendado_adicional_input,
					  cliente_controller,  funcionario_controller, instrumento_controller,  material_controller,   ordem_controller));
			adicionar_button.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			pane.add(adicional_label);
			pane.add(adicional_input);
			pane.add(Box.createVerticalStrut(20));
			pane.add(servico_recomendado_label);
			pane.add(tipo_servico_recomendado_label);
			pane.add(tipo_servico_recomendado_input);
			pane.add(servico_recomendado_valor_label);
			pane.add(servico_recomendado_valor_input);
			pane.add(servico_recomendado_descricao_label);
			pane.add(servico_recomendado_descricao_input);
			pane.add(servico_recomendado_adicional_label);
			pane.add(servico_recomendado_adicional_input);
			pane.add(Box.createVerticalStrut(10));
			pane.add(adicionar_button);
		} else {
			JButton adicionar_button = new JButton("Adicionar");
			adicionar_button.setAlignmentX(Component.CENTER_ALIGNMENT);
			adicionar_button.addActionListener(new BotaoCadastrarOrdemActionAddServicoConstrucaoListener(owner,owner_cadastro,servicos, valor_input, descricao_input,
					  cliente_controller,  funcionario_controller, instrumento_controller,  material_controller,   ordem_controller));
			
			pane.add(Box.createVerticalStrut(10));
			pane.add(adicionar_button);
		}
		
	
		
		setContentPane(pane);
		setVisible(true);
	}
}
