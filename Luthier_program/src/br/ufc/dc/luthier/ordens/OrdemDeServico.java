package br.ufc.dc.luthier.ordens;

import java.util.Vector;

import br.ufc.dc.luthier.instrumentos.Instrumento;
import br.ufc.dc.luthier.materiais.Material;
import br.ufc.dc.luthier.pessoas.Cliente;
import br.ufc.dc.luthier.pessoas.Funcionario;
import br.ufc.dc.luthier.servicos.ServicoAbstract;
import java.util.Date;

public class OrdemDeServico {
	private int numero;
	private Vector<ServicoAbstract> servicos;
	private Cliente cliente;
	private Instrumento instrumento;
	private String data_prevista_entrega ;
	private Funcionario atendente;
	
	private Vector<Material> materiais_usados;
	private double valor;
	
	private Vector<Notificacao> notificacoes;
	private Date data_de_entrada;
	
	private class Notificacao{
		private String mensagem;
		protected void setMensagem(String nova_mensagem) {mensagem = nova_mensagem;}
		protected String getMensagem() {return mensagem;}
	}
	
	protected OrdemDeServico(int numero, Vector<ServicoAbstract> servicos, Cliente cliente, 
			Instrumento instrumento, String data_prevista_entrega, Funcionario atendente ) {
		this.numero = numero;
		this.servicos = servicos;
		this.setCliente(cliente);
		this.setInstrumento(instrumento);
		this.setData_prevista_entrega(data_prevista_entrega);
		this.setAtendente(atendente);
		
		this.valor = 0;
		this.data_de_entrada = new Date();
		
		materiais_usados = new Vector<Material>();
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
	
	
	
	public int getNumero() {return numero;}
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

}
