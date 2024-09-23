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
import br.ufc.dc.luthier.gui.listeners.ordens.BotaoActionEditarOrdemListener;
import br.ufc.dc.luthier.gui.listeners.ordens.BotaoCadastrarOrdemActionExcluirServicoListener;
import br.ufc.dc.luthier.gui.listeners.ordens.BotaoCadastrarOrdemAddServicoListener;
import br.ufc.dc.luthier.gui.listeners.ordens.BotaoEditarOrdemActionExcluirMaterialListener;
import br.ufc.dc.luthier.gui.listeners.ordens.BotaoEditarOrdemActionExcluirNotificacaoListener;
import br.ufc.dc.luthier.gui.listeners.ordens.BotaoEditarOrdemActionExcluirServicoListener;
import br.ufc.dc.luthier.gui.listeners.ordens.BotaoEditarOrdemAddMaterialListener;
import br.ufc.dc.luthier.gui.listeners.ordens.BotaoEditarOrdemAddNotificacaoListener;
import br.ufc.dc.luthier.gui.listeners.ordens.BotaoEditarOrdemAddServicoListener;
import br.ufc.dc.luthier.instrumentos.Instrumento;
import br.ufc.dc.luthier.materiais.Material;
import br.ufc.dc.luthier.ordens.OrdemDeServico;
import br.ufc.dc.luthier.ordens.notificacoes.Notificacao;
import br.ufc.dc.luthier.pessoas.Funcionario;
import br.ufc.dc.luthier.servicos.ServicoAbstract;
import br.ufc.dc.luthier.servicos.ServicoManutencao;
import br.ufc.dc.luthier.servicos.ServicoManutencaoConserto;
import br.ufc.dc.luthier.servicos.ServicoManutencaoTrocaDePeca;
import br.ufc.dc.luthier.servicos.ServicoRevisao;

public class JanelaEditarOrdem extends JFrame {
	private Vector<ServicoAbstract> servicos;
	private Vector<Material> materiais;
	private Vector<Notificacao> notificacoes;
	public JanelaEditarOrdem(JanelaOrdensDeServico owner,Vector<ServicoAbstract> servicos,Vector<Material> materiais, Vector<Notificacao> notificacoes, int index, ClienteController cliente_controller, FuncionarioController funcionario_controller, 
   			InstrumentoController instrumento_controller, MaterialController material_controller, OrdemController  ordem_controller) {
		this.servicos = servicos;
		this.materiais = materiais;
		this.notificacoes = notificacoes;
		setSize(600,450);
		setLocationRelativeTo(null);
		
		OrdemDeServico ordem = ordem_controller.get(index);
		JLabel titulo = new JLabel("Editar Ordem De Serviço");
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel situacao_label = new JLabel("Situação:");
		situacao_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		JComboBox<String> situacao_input = new JComboBox<>();
		situacao_input.setMaximumSize(new Dimension(350, 35));
		situacao_input.addItem("ABERTA");
		situacao_input.addItem("CONCLUIDA");
		situacao_input.setSelectedItem(ordem.getSituacao().toString());
		
		JLabel atendente_label = new JLabel("Atendente:");
		atendente_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		JComboBox<String> atendente_input = new JComboBox<>();
		atendente_input.setMaximumSize(new Dimension(350, 35));
		for (int i=0;i<funcionario_controller.qtd_funcionarios();i++) {
			Funcionario funcionario = funcionario_controller.get(i);
			String atendente_info = funcionario.getCodigo() + " - " + funcionario.getNome();
			atendente_input.addItem(atendente_info);
			
			if (ordem.getCliente().getCpf().equals(funcionario.getCpf())) {
				atendente_input.setSelectedItem(atendente_info);
			}
		}

		
		JLabel instrumento_label = new JLabel("Instrumento:");
		instrumento_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		JComboBox<String> instrumento_input = new JComboBox<>();
		instrumento_input.setMaximumSize(new Dimension(350, 35));
		for (int i=0;i<instrumento_controller.qtd_instrumentos();i++) {
			Instrumento instrumento = instrumento_controller.get(i);
			String instrumento_info = instrumento.getNumDeSerie() + " - " + instrumento.getTipo();
			instrumento_input.addItem(instrumento_info);
			if (ordem.getInstrumento().getNumDeSerie().equals(instrumento.getNumDeSerie())) {
				atendente_input.setSelectedItem(instrumento_info);
			}
		}
		
		JLabel instrumento_estado_label = new JLabel("Estado do instrumento:");
		instrumento_estado_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		JComboBox<String> instrumento_estado_input  = new JComboBox<>();
		instrumento_estado_input.setMaximumSize(new Dimension(350, 35));		
		instrumento_estado_input.addItem("RECEBIDO");
		instrumento_estado_input.addItem("EM CONSERTO");
		instrumento_estado_input.addItem("EM FABRICACAO");
		instrumento_estado_input.addItem("EM MANUTENCAO");
		instrumento_estado_input.addItem("PRONTO");
		instrumento_estado_input.addItem("EM FABRICACAO");
		instrumento_estado_input.addItem("CADASTRADO");
		switch(ordem.getInstrumento().getEstado()) {
		case CADASTRADO:
			instrumento_estado_input.setSelectedItem("RECEBIDO");
		case EM_CONSERTO:
			instrumento_estado_input.setSelectedItem("EM CONSERTO");
		case EM_FABRICACAO:
			instrumento_estado_input.setSelectedItem("EM FABRICACAO");
		case EM_MANUTENCAO:
			instrumento_estado_input.setSelectedItem("EM MANUTENCAO");
		case PRONTO:
			instrumento_estado_input.setSelectedItem("PRONTO");
		default:
			instrumento_estado_input.setSelectedItem("CADASTRADO");
		}
		
		JLabel data_prevista_label = new JLabel("Data prevista para entrega:");
		data_prevista_label.setAlignmentX(Component.CENTER_ALIGNMENT);
		JTextArea data_prevista_input = new JTextArea(ordem.getDataPrevistaEntrega());
		data_prevista_input.setMaximumSize(new Dimension(350, 35));
		
		
	      JPanel materiais_pane = new JPanel();
          materiais_pane.setLayout(new BoxLayout(materiais_pane, BoxLayout.Y_AXIS));
          materiais_pane.add(new JLabel("Materiais usados:"));
          materiais_pane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
          if(materiais.size() == 0){
        		 materiais_pane.add(new JLabel("[Nenhum material foi usado]"));
	        }else {
		         for(int i=0; i<materiais.size();i++) {
		        	 Material material = materiais.get(i);
		        	 JLabel label_material_codigo = new JLabel("Codigo: " + material.getCodigo());
		        	 JLabel label_material_tipo = new JLabel("Tipo: " + material.getTipo());
		        	 JLabel label_material_marca = new JLabel("Marca: " + material.getMarca());
		        	 JLabel label_material_valor = new JLabel("Valor: " + material.getValor());
		        	 materiais_pane.add(Box.createVerticalStrut(5));
		        	 materiais_pane.add(label_material_codigo);
		        	 materiais_pane.add(label_material_tipo);
		        	 materiais_pane.add(label_material_marca);
		        	 materiais_pane.add(label_material_valor);
		        	 JButton excluir_material_button = new JButton("Excluir Material");
		        	 excluir_material_button.addActionListener(new BotaoEditarOrdemActionExcluirMaterialListener(i,  index, owner,this,  servicos,materiais, notificacoes,  cliente_controller,  funcionario_controller, 
		 		    			 instrumento_controller,  material_controller,   ordem_controller));
		 		     materiais_pane.add(excluir_material_button);
		         }
	         }
	        materiais_pane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));   
	        JButton botao_adicionar_material = new JButton("Adicionar Material");
	        botao_adicionar_material.setAlignmentX(Component.CENTER_ALIGNMENT);
	        botao_adicionar_material.addActionListener(new BotaoEditarOrdemAddMaterialListener(owner,index, this, servicos, materiais, notificacoes, cliente_controller,  funcionario_controller, 
	 				 instrumento_controller, material_controller, ordem_controller));
	        materiais_pane.add(botao_adicionar_material);
	         
	         
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
	 		       	excluir_servico_button.addActionListener(new BotaoEditarOrdemActionExcluirServicoListener(i,index, owner,this,  servicos,materiais, notificacoes,  cliente_controller,  funcionario_controller, 
	 		    			 instrumento_controller,  material_controller,   ordem_controller));
	 		       	servicos_pane.add(excluir_servico_button);
	 	       	 } 
	 		}
	         servicos_pane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));	
	 		JButton botao_adicionar_servico = new JButton("Adicionar servico");
	 		botao_adicionar_servico.setAlignmentX(Component.CENTER_ALIGNMENT);
	 		botao_adicionar_servico.addActionListener(new BotaoEditarOrdemAddServicoListener(owner,index, this, servicos, materiais, notificacoes, cliente_controller,  funcionario_controller, 
	 				 instrumento_controller, material_controller, ordem_controller));
	 		servicos_pane.add(botao_adicionar_servico);

	         
	 		
	 		
	        JPanel notificacoes_pane = new JPanel();
	        notificacoes_pane.setLayout(new BoxLayout(notificacoes_pane, BoxLayout.Y_AXIS));
	        notificacoes_pane.add(new JLabel("Notificacoes:"));	
	        
	        if(notificacoes.size()==0){
		        notificacoes_pane.add(Box.createVerticalStrut(5));
		        notificacoes_pane.add(new JLabel("[Nenhuma notificacao]"));
			 }else {
			    for(int i=0;i<notificacoes.size();i++) {
				   	Notificacao notificacao = notificacoes.get(i);
				   	JLabel label_notificacao_numero = new JLabel("Numero: " + i+1);
				   	JLabel label_notificacao_mensagem = new JLabel("Mensagem: " + notificacao.getMensagem());
				   	notificacoes_pane.add(Box.createVerticalStrut(5));
				   	notificacoes_pane.add(label_notificacao_numero);
				   	notificacoes_pane.add(label_notificacao_mensagem);
				   	JButton excluir_notificacao_button = new JButton("Excluir Notificacao");
				   	excluir_notificacao_button.addActionListener(new BotaoEditarOrdemActionExcluirNotificacaoListener(i,index, owner,this,  servicos,materiais,notificacoes,  cliente_controller,  funcionario_controller, 
	 		    			 instrumento_controller,  material_controller,   ordem_controller));
				   	notificacoes_pane.add(excluir_notificacao_button);
			    }
			}	 
	        notificacoes_pane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));	
	        JButton botao_adicionar_notificacao = new JButton("Adicionar notificacao");
	        botao_adicionar_notificacao.setAlignmentX(Component.CENTER_ALIGNMENT);
	        botao_adicionar_notificacao.addActionListener(new BotaoEditarOrdemAddNotificacaoListener(owner,index,this,servicos, materiais, notificacoes,
	        		cliente_controller,  funcionario_controller, instrumento_controller, material_controller, ordem_controller));
	        notificacoes_pane.add(botao_adicionar_notificacao);
	        
	        
		JButton botao_salvar = new JButton("Salvar");
		botao_salvar.setAlignmentX(Component.CENTER_ALIGNMENT);
		botao_salvar.addActionListener(new BotaoActionEditarOrdemListener(owner,index, atendente_input, instrumento_input, instrumento_estado_input,
				data_prevista_input,situacao_input, servicos,materiais,notificacoes, cliente_controller, funcionario_controller, instrumento_controller, material_controller,  ordem_controller));

		
		JPanel pane = new JPanel();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));  
		

		
		pane.add(Box.createVerticalStrut(20)); 
		pane.add(titulo);
		pane.add(Box.createVerticalStrut(40));
		pane.add(servicos_pane);
		pane.add(Box.createVerticalStrut(10));
		pane.add(materiais_pane);
		pane.add(Box.createVerticalStrut(10));
		pane.add(notificacoes_pane);
		pane.add(Box.createVerticalStrut(10));
		pane.add(situacao_label);
		pane.add(situacao_input);
		pane.add(Box.createVerticalStrut(10));
		pane.add(atendente_label);
		pane.add(atendente_input);
		pane.add(Box.createVerticalStrut(10)); 
		pane.add(instrumento_estado_label);
		pane.add(instrumento_estado_input);
		pane.add(Box.createVerticalStrut(10)); 
		pane.add(data_prevista_label);
		pane.add(data_prevista_input);
		pane.add(Box.createVerticalStrut(10)); 
		pane.add(instrumento_estado_label);
		pane.add(instrumento_estado_input);
		pane.add(Box.createVerticalStrut(30)); 
		pane.add(botao_salvar);
	
		JScrollPane scroll_pane = new JScrollPane(pane);
        scroll_pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		
		setContentPane(scroll_pane);
		setVisible(true);
	}
}
