package br.ufc.dc.luthier.gui.janelas.ordens;

import java.awt.Color;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import br.ufc.dc.luthier.controllers.OrdemController;
import br.ufc.dc.luthier.materiais.Material;
import br.ufc.dc.luthier.ordens.OrdemDeServico;
import br.ufc.dc.luthier.ordens.notificacoes.Notificacao;
import br.ufc.dc.luthier.servicos.ServicoAbstract;
import br.ufc.dc.luthier.servicos.ServicoManutencao;
import br.ufc.dc.luthier.servicos.ServicoManutencaoConserto;
import br.ufc.dc.luthier.servicos.ServicoManutencaoTrocaDePeca;
import br.ufc.dc.luthier.servicos.ServicoRevisao;

public class JanelaVerOrdem extends JFrame{
	public JanelaVerOrdem(int index, OrdemController ordem_controller) {
	
		setSize(800,700);
		setLocationRelativeTo(null);
		JPanel pane = new JPanel();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));  
		JLabel titulo = new JLabel ("Ordem de Servico");
		
		OrdemDeServico ordem = ordem_controller.get(index);
		
		 JLabel label_numero = new JLabel("Número: " + ordem.getNumero());
		 JLabel label_situacao = new JLabel("Situacao: " + ordem.getSituacao());
		 JLabel label_criada_em = new JLabel("Criada em: " + ordem.getDataDeEntrada());
		 JLabel label_atendente = new JLabel("Atendente: " + ordem.getAtendente().getCodigo() + " - " + ordem.getAtendente().getNome());
         JLabel label_cliente = new JLabel("Cliente: " + ordem.getCliente().getCpf() + " - " + ordem.getCliente().getNome());
         JLabel label_tipo_do_instrumento = new JLabel("Instrumento: " + ordem.getInstrumento().getNumDeSerie() + " - " + ordem.getInstrumento().getTipo());
         JLabel label_estado_do_instrumento = new JLabel("Estado do Instrumento: " + ordem.getInstrumento().getEstado().toString());
         JLabel label_data_prevista_entrega = new JLabel("Data prevista para entrega: " + ordem.getDataPrevistaEntrega());
         
         JPanel materiais_pane = new JPanel();
         materiais_pane.setLayout(new BoxLayout(materiais_pane, BoxLayout.Y_AXIS));
         materiais_pane.add(new JLabel("Materiais usados:"));
         materiais_pane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
         Vector<Material> materiais = ordem.getMateriais();
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
	         }
         }
         materiais_pane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));   
	         
	         
         JPanel servicos_pane = new JPanel();
         servicos_pane.setLayout(new BoxLayout(servicos_pane, BoxLayout.Y_AXIS));
         servicos_pane.add(new JLabel("Servicos:"));
         Vector<ServicoAbstract> servicos = ordem.getServicos();
         
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
        		 servicos_pane.add(new JLabel("Servico Recomendado:"));
        		 
        		 ServicoManutencao servico_recomendado = ((ServicoRevisao) servico).getServicoRecomendado();
        		 if (servico_recomendado == null) {
        			 servicos_pane.add(new JLabel("[Não há servicos recomendados]"));
        		 } else {
    				  servicos_pane.add(ordem_controller.returnServicoLabel(servico_recomendado));
    				  servicos_pane.add(new JLabel("Valor: " + servico_recomendado.getValor()));
    				  servicos_pane.add(new JLabel("Descricao: " + servico_recomendado.getDescricao()));
    				  if (servico_recomendado instanceof ServicoManutencaoConserto) {
    		        		 servicos_pane.add(new JLabel("Peca consertada: " + ((ServicoManutencaoConserto)servico_recomendado).getPecaConsertada()));
    		        	 } else if (servico_recomendado instanceof ServicoManutencaoTrocaDePeca) {
    		        		 servicos_pane.add(new JLabel("Peca antiga: " + ((ServicoManutencaoTrocaDePeca)servico_recomendado).getPecaAntiga()));
    			  }
        		
        		 
        		 servicos_pane.add(servicos_recomendados_pane);
        		 }
        	 }
         } 
         servicos_pane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));	
         
         
        JPanel notificacoes_pane = new JPanel();
        notificacoes_pane.setLayout(new BoxLayout(notificacoes_pane, BoxLayout.Y_AXIS));
        notificacoes_pane.add(new JLabel("Notificacoes:"));	
        Vector<Notificacao> notificacoes = ordem.getNotificacoes();
        
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
		    }
		}	 
        notificacoes_pane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));	
        
        JLabel label_valor = new JLabel("Valor: " + ordem.getValor());
		
	    pane.add(Box.createVerticalStrut(20)); 
  		pane.add(titulo);
  		pane.add(Box.createVerticalStrut(40)); 	
  		pane.add(label_numero);
  		pane.add(Box.createVerticalStrut(10));
  		pane.add(label_situacao);
  		pane.add(Box.createVerticalStrut(10)); 
  		pane.add(label_criada_em);
  		pane.add(Box.createVerticalStrut(10)); 
  		pane.add(label_atendente);
  		pane.add(Box.createVerticalStrut(10)); 
  		pane.add(label_cliente);
  		pane.add(Box.createVerticalStrut(10)); 
  		pane.add(label_tipo_do_instrumento);
  		pane.add(Box.createVerticalStrut(10)); 
  		pane.add(label_estado_do_instrumento);
  		pane.add(Box.createVerticalStrut(10)); 
  		pane.add(label_data_prevista_entrega);
  		pane.add(Box.createVerticalStrut(10)); 
  		pane.add(materiais_pane);
  		pane.add(Box.createVerticalStrut(10)); 
  		pane.add(servicos_pane);
  		pane.add(Box.createVerticalStrut(10)); 
  		pane.add(notificacoes_pane);
  		pane.add(Box.createVerticalStrut(10)); 
  		pane.add(label_valor);
  		pane.add(Box.createVerticalStrut(10)); 
	
		JScrollPane scroll_pane = new JScrollPane(pane);
        scroll_pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		
		setContentPane(scroll_pane);
		setVisible(true);
	}
}
