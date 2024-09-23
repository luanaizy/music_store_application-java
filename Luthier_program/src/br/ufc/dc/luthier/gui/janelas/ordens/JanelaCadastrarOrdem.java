package br.ufc.dc.luthier.gui.janelas.ordens;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import br.ufc.dc.luthier.controllers.ClienteController;
import br.ufc.dc.luthier.controllers.FuncionarioController;
import br.ufc.dc.luthier.controllers.InstrumentoController;
import br.ufc.dc.luthier.controllers.MaterialController;
import br.ufc.dc.luthier.controllers.OrdemController;
import br.ufc.dc.luthier.gui.listeners.ordens.BotaoActionCadastrarOrdemListener;
import br.ufc.dc.luthier.gui.listeners.ordens.BotaoCadastrarOrdemActionExcluirServicoListener;
import br.ufc.dc.luthier.gui.listeners.ordens.BotaoCadastrarOrdemAddServicoListener;
import br.ufc.dc.luthier.instrumentos.Instrumento;
import br.ufc.dc.luthier.instrumentos.estados.EstadoInstrumento;
import br.ufc.dc.luthier.pessoas.Cliente;
import br.ufc.dc.luthier.pessoas.Funcionario;
import br.ufc.dc.luthier.servicos.ServicoAbstract;
import br.ufc.dc.luthier.servicos.ServicoManutencao;
import br.ufc.dc.luthier.servicos.ServicoManutencaoConserto;
import br.ufc.dc.luthier.servicos.ServicoManutencaoTrocaDePeca;
import br.ufc.dc.luthier.servicos.ServicoRevisao;

public class JanelaCadastrarOrdem extends JFrame {
	private Vector<ServicoAbstract> servicos;
	public JanelaCadastrarOrdem( JanelaOrdensDeServico owner, Vector<ServicoAbstract> servicos, ClienteController cliente_controller, FuncionarioController funcionario_controller, 
			InstrumentoController instrumento_controller, MaterialController material_controller, OrdemController  ordem_controller) {
		this.servicos = servicos;
		setSize(600,450);
		setLocationRelativeTo(null);
		
		JLabel titulo = new JLabel("Criar Ordem De Serviço");
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel atendente_label = new JLabel("Atendente:");
		atendente_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		JComboBox<String> atendente_input = new JComboBox<>();
		atendente_input.setMaximumSize(new Dimension(350, 35));
		for (int i=0;i<funcionario_controller.qtd_funcionarios();i++) {
			Funcionario funcionario = funcionario_controller.get(i);
			atendente_input.addItem(funcionario.getCodigo() + " - " + funcionario.getNome());
		}
		
		
		JLabel instrumento_label = new JLabel("Instrumento:");
		instrumento_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		JComboBox<String> instrumento_input = new JComboBox<>();
		instrumento_input.setMaximumSize(new Dimension(350, 35));
		for (int i=0;i<instrumento_controller.qtd_instrumentos();i++) {
			Instrumento instrumento = instrumento_controller.get(i);
			instrumento_input.addItem(instrumento.getNumDeSerie() + " - " + instrumento.getTipo());
		}
		
		JLabel instrumento_estado_label = new JLabel("Estado do instrumento:");
		instrumento_estado_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		JComboBox<String> instrumento_estado_input  = new JComboBox<>();
		instrumento_estado_input.setMaximumSize(new Dimension(350, 35));		
		instrumento_estado_input.addItem("CADASTRADO");
		instrumento_estado_input.addItem("RECEBIDO");
		instrumento_estado_input.addItem("EM CONSERTO");
		instrumento_estado_input.addItem("EM FABRICACAO");
		instrumento_estado_input.addItem("EM MANUTENCAO");
		instrumento_estado_input.addItem("PRONTO");
		instrumento_estado_input.addItem("EM FABRICACAO");
		
		
		JLabel data_prevista_label = new JLabel("Data prevista para entrega:");
		data_prevista_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		JTextArea data_prevista_input = new JTextArea();
		data_prevista_input.setMaximumSize(new Dimension(350, 35));
		
		JPanel servicos_pane = new JPanel();
		servicos_pane.setLayout(new BoxLayout(servicos_pane, BoxLayout.Y_AXIS));
		JLabel servicos_label = new JLabel("Servicos:");
		servicos_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		servicos_pane.add(servicos_label);

		if(servicos.size()==0) {
			JLabel nao_ha_servico_label = new JLabel("[Não há servico]");
			nao_ha_servico_label.setAlignmentX(Component.CENTER_ALIGNMENT);
			servicos_pane.add(nao_ha_servico_label);
		} else {
	        for(int i=0; i<servicos.size();i++) {
		       	 ServicoAbstract servico = servicos.get(i);
		       	 servicos_pane.add(Box.createVerticalStrut(5)); 
		       	 servicos_pane.add( ordem_controller.returnServicoLabel(servico));
		       	 servicos_pane.add(new JLabel("Valor: " + servico.getValor()));
		       	 servicos_pane.add(new JLabel("Descricao: " + servico.getDescricao()));
		       	 if (servico instanceof ServicoManutencaoConserto) {
		       		 servicos_pane.add(new JLabel("Peca consertada: " + ((ServicoManutencaoConserto)servico).getPecaConsertada()));
		       	 } else if (servico instanceof ServicoManutencaoTrocaDePeca) {
		       		 servicos_pane.add(new JLabel("Peca antiga: " + ((ServicoManutencaoTrocaDePeca)servico).getPecaAntiga()));
		       	 } else if (servico instanceof ServicoRevisao) {
		       		 servicos_pane.add(new JLabel("Resultado : " + ((ServicoRevisao) servico).getResultado()));
		       		 JPanel servicos_recomendados_pane = new JPanel();
		       		 servicos_recomendados_pane.setLayout(new BoxLayout(servicos_recomendados_pane, BoxLayout.Y_AXIS));
		       		 servicos_pane.add(new JLabel("Servicos Recomendados:"));
		       		 
		       		 ServicoManutencao servico_recomendado = ((ServicoRevisao) servico).getServicoRecomendado();
		       		 if (servico_recomendado == null) {
		       			 JLabel nao_ha_servico_rec_label = new JLabel("[Não há servico recomendado]");
		       			servicos_pane.add(nao_ha_servico_rec_label);
		       			 nao_ha_servico_rec_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		       		 } else {
		   				  servicos_pane.add(ordem_controller.returnServicoLabel(servico_recomendado));
		   				  servicos_pane.add(new JLabel("Valor: " + servico_recomendado.getValor()));
		   				  servicos_pane.add(new JLabel("Descricao: " + servico_recomendado.getDescricao()));
		   				  if (servico_recomendado instanceof ServicoManutencaoConserto) {
		   		        		 servicos_pane.add(new JLabel("Peca consertada: " + ((ServicoManutencaoConserto)servico_recomendado).getPecaConsertada()));
		   		        	 } else if (servico_recomendado instanceof ServicoManutencaoTrocaDePeca) {
		   		        		 servicos_pane.add(new JLabel("Peca antiga: " + ((ServicoManutencaoTrocaDePeca)servico_recomendado).getPecaAntiga()));
		   		        	 }
		   			  }	       		 
		       		 servicos_pane.add(servicos_recomendados_pane);
		         }
		       	 JButton excluir_servico_button = new JButton("Excluir servico");
		       	excluir_servico_button.addActionListener(new BotaoCadastrarOrdemActionExcluirServicoListener(i, owner,this,  servicos,  cliente_controller,  funcionario_controller, 
		    			 instrumento_controller,  material_controller,   ordem_controller));
		       	servicos_pane.add(excluir_servico_button);
	       	 } 
		}
        servicos_pane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));	
		JButton botao_adicionar_servico = new JButton("Adicionar servico");
		botao_adicionar_servico.setAlignmentX(Component.CENTER_ALIGNMENT);
		botao_adicionar_servico.addActionListener(new BotaoCadastrarOrdemAddServicoListener(owner, this, servicos, cliente_controller,  funcionario_controller, 
				 instrumento_controller, material_controller, ordem_controller));
		servicos_pane.add(botao_adicionar_servico);
		
		JButton botao_cadastrar = new JButton("Cadastrar");
		botao_cadastrar.setAlignmentX(Component.CENTER_ALIGNMENT);
		botao_cadastrar.addActionListener(new BotaoActionCadastrarOrdemListener(owner, atendente_input, instrumento_input, instrumento_estado_input,
				data_prevista_input, servicos, cliente_controller, funcionario_controller, instrumento_controller, material_controller,  ordem_controller));

		
		JPanel pane = new JPanel();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));  
		

		
		pane.add(Box.createVerticalStrut(20)); 
		pane.add(titulo);
		pane.add(Box.createVerticalStrut(40)); 
		pane.add(servicos_pane);
		pane.add(Box.createVerticalStrut(10));	
		pane.add(atendente_label);
		pane.add(atendente_input);
		pane.add(Box.createVerticalStrut(10));
		pane.add(instrumento_label);
		pane.add(instrumento_input);
		pane.add(Box.createVerticalStrut(10)); 
		pane.add(instrumento_estado_label);
		pane.add(instrumento_estado_input);
		pane.add(Box.createVerticalStrut(10)); 
		pane.add(data_prevista_label);
		pane.add(data_prevista_input);
		
		
		pane.add(Box.createVerticalStrut(30)); 
		pane.add(botao_cadastrar);
	
		JScrollPane scroll_pane = new JScrollPane(pane);
        scroll_pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		
		setContentPane(scroll_pane);
		setVisible(true);
	}
}
