package br.ufc.dc.luthier.ordens;

import java.util.Vector;

import br.ufc.dc.luthier.instrumentos.Instrumento;
import br.ufc.dc.luthier.instrumentos.estados.EstadoInstrumento;
import br.ufc.dc.luthier.materiais.Material;
import br.ufc.dc.luthier.ordens.situacao.SituacaoOrdem;
import br.ufc.dc.luthier.pessoas.Cliente;
import br.ufc.dc.luthier.pessoas.Funcionario;
import br.ufc.dc.luthier.servicos.ServicoAbstract;
import java.util.Date;

public class OrdemDeServico {

	private String numero;
	private Vector<ServicoAbstract> servicos;
	private Cliente cliente; //vem com instrumento
	private Instrumento instrumento;
	private EstadoInstrumento estado_do_instrumento; //vem com instrumento
	private String data_prevista_entrega ;
	private Funcionario atendente;
	private SituacaoOrdem situacao;
	private Vector<Material> materiais_usados;
	private double valor;
	
	private Vector<Notificacao> notificacoes;
	private Date data_de_entrada;
	
	private class Notificacao{
		private String mensagem;
		protected void setMensagem(String nova_mensagem) {mensagem = nova_mensagem;}
		protected String getMensagem() {return mensagem;}
	}
	
	public OrdemDeServico( Vector<ServicoAbstract> servicos, 
			Instrumento instrumento, String data_prevista_entrega, Funcionario atendente ) {

		this.servicos = servicos;
		this.setSituacao(SituacaoOrdem.ABERTA);
		this.setInstrumento(instrumento);
		this.setCliente(this.instrumento.getProprietario());
		estado_do_instrumento = instrumento.getEstado();
		this.setData_prevista_entrega(data_prevista_entrega);
		this.setAtendente(atendente);
		
		this.valor = 0;
		this.data_de_entrada = new Date();
		
		materiais_usados = new Vector<Material>();
		notificacoes = new Vector<Notificacao>();
		calcularValor();
		
		Notificacao notificacao1 = new Notificacao();
		String servicos_msg = new String("");
		for (int i=0; i<servicos.size(); i++) {
			servicos_msg = servicos_msg + servicos.get(i).getDescricao() + ", ";
		}
		String materiais_msg = new String("não necessitou de material/pecas.");
		if (materiais_usados.size() > 0) {
			materiais_msg = "os materiais usados são: ";
			for (int i=0; i<materiais_usados.size(); i++) {
				materiais_msg = materiais_msg + materiais_usados.get(i).getTipo() + ", da marca " +
						materiais_usados.get(i).getMarca() + ", ";
			}
		}
		notificacao1.setMensagem("O instrumento " + instrumento.getTipo() + " " + instrumento.getMarca() + 
				" está em: " + servicos_msg + "e tem previsao de ser entregue dia " + data_prevista_entrega + 
				". Segundo a ordem de servico de numero " + numero + ", " + materiais_msg + " obrigado!");
		notificacoes.add(notificacao1);
	}
	
	protected void calcularValor() {
		for (int i=0 ; i<servicos.size(); i++ ) {
			valor = valor + servicos.get(i).getValor();
		}
		for (int i=0 ; i<materiais_usados.size(); i++) {
			valor = valor + materiais_usados.get(i).getValor();
		}
	}
	
	
	public void setNumero(String numero) {this.numero = numero;}
	public String getNumero() {return numero;}
	
	public Vector<ServicoAbstract> getServicos(){return servicos;}
	public void setServicos(Vector<ServicoAbstract> servicos) {this.servicos = servicos;}
	
	public Cliente getCliente() {return cliente;}
	public void setCliente(Cliente cliente) {this.cliente = cliente;}
	
	public Instrumento getInstrumento() {return instrumento;}
	public void setInstrumento(Instrumento instrumento) {this.instrumento = instrumento;}
	
	public String getData_prevista_entrega() {return data_prevista_entrega;}
	public void setData_prevista_entrega(String data_prevista_entrega) {
		this.data_prevista_entrega = data_prevista_entrega;
	}
	
	public Funcionario getAtendente() {	return atendente;}
	public void setAtendente(Funcionario atendente) {this.atendente = atendente;}
	
	//pode ser vazio
	public Vector<Material> getMateriais(){return materiais_usados;}
	public void setMateriais(Vector<Material>materiais_usados) {this.materiais_usados = materiais_usados;}
	
	public double getValor() {return valor;}

	public String getDataDeEntrada() {
		return data_de_entrada.toString();
	}

	public SituacaoOrdem getSituacao() {return situacao;}
	public void setSituacao(SituacaoOrdem situacao) {this.situacao = situacao;}

	public void setEstadoDoInstrumento(EstadoInstrumento estado) {
		this.instrumento.setEstado(estado);
	}
	
	public void print() {
	    System.out.println("Número da Ordem de Serviço: " + numero);
	    System.out.println("Cliente: " + cliente.getNome());
	    System.out.println("Instrumento: " + instrumento.getTipo() + " - " + instrumento.getMarca());
	    System.out.println("Estado do Instrumento: " + estado_do_instrumento.name());
	    System.out.println("Data Prevista de Entrega: " + data_prevista_entrega);
	    System.out.println("Atendente: " + atendente.getNome());
	    System.out.println("Situação da Ordem: " + situacao);
	    
	    System.out.println("Serviços:");
	    for (ServicoAbstract servico : servicos) {
	        System.out.println(" - " + servico.getDescricao() + " (R$ " + servico.getValor() + ")");
	    }

	    System.out.println("Materiais Usados:");
	    if (materiais_usados.isEmpty()) {
	        System.out.println(" - Nenhum material utilizado.");
	    } else {
	        for (Material material : materiais_usados) {
	            System.out.println(" - " + material.getTipo() + " da marca " + material.getMarca() + " (R$ " + material.getValor() + ")");
	        }
	    }
	    
	    System.out.println("Valor Total: R$ " + valor);
	    System.out.println("Data de Entrada: " + data_de_entrada);
	    
	    System.out.println("Notificações:");
	    if (notificacoes.isEmpty()) {
	        System.out.println(" - Nenhuma notificação.");
	    } else {
	        for (Notificacao notificacao : notificacoes) {
	            System.out.println(" - " + notificacao.getMensagem());
	        }
	    }
	}

}
