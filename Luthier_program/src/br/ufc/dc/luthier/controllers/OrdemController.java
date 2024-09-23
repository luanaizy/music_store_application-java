package br.ufc.dc.luthier.controllers;

import java.util.Vector;

import javax.swing.JLabel;

import br.ufc.dc.luthier.exceptions.ExisteOrdemAbertaPInstrException;
import br.ufc.dc.luthier.exceptions.OrdemInexistenteException;
import br.ufc.dc.luthier.instrumentos.Instrumento;
import br.ufc.dc.luthier.instrumentos.estados.EstadoInstrumento;
import br.ufc.dc.luthier.materiais.Material;
import br.ufc.dc.luthier.ordens.OrdemDeServico;
import br.ufc.dc.luthier.ordens.situacao.SituacaoOrdem;
import br.ufc.dc.luthier.pessoas.Funcionario;
import br.ufc.dc.luthier.repositorios.ordens.IRepositorioOrdens;
import br.ufc.dc.luthier.servicos.ServicoAbstract;
import br.ufc.dc.luthier.servicos.ServicoConstrucao;
import br.ufc.dc.luthier.servicos.ServicoManutencaoConserto;
import br.ufc.dc.luthier.servicos.ServicoManutencaoRegulagem;
import br.ufc.dc.luthier.servicos.ServicoRevisao;

public class OrdemController {
	private IRepositorioOrdens rep_ordens;
	
	public OrdemController(IRepositorioOrdens rep_ordens) {
		this.rep_ordens = rep_ordens;
	}
	
	public void inserir(OrdemDeServico ordem) throws ExisteOrdemAbertaPInstrException{
		rep_ordens.inserir(ordem);
	}
	public void remover(String numero) throws OrdemInexistenteException{
		rep_ordens.remover(numero);
	}
	public OrdemDeServico procurar(String numero) {
		return rep_ordens.procurar(numero);
	}
	public int procurar_index(String numero) {
		return rep_ordens.procurar_index(numero);
	}
	public void modificar(int index, Vector<ServicoAbstract> servicos, 
			Instrumento instrumento, EstadoInstrumento estado_do_instrumento, 
			String data_prevista_entrega, Funcionario atendente, SituacaoOrdem situacao, 
			Vector<Material> materiais_usados) throws ExisteOrdemAbertaPInstrException{
		rep_ordens.modificar(index, servicos, instrumento, estado_do_instrumento, data_prevista_entrega, atendente, situacao, materiais_usados);
	}
	public OrdemDeServico get(int index) throws ArrayIndexOutOfBoundsException{
		return rep_ordens.get(index);
	}
	public int qtd_ordens() {
		return rep_ordens.qtd_ordens();
	}
	
	public JLabel returnServicoLabel(ServicoAbstract servico) {
		if (servico instanceof ServicoConstrucao) {
			return new JLabel("Servico de Construcao de Instrumento");
		} else if (servico instanceof ServicoRevisao) {
			return new JLabel("Servico de Revisao de Instrumento");
		} else if (servico instanceof ServicoManutencaoConserto) {
			return new JLabel("Servico de Conserto");
		} else if (servico instanceof ServicoManutencaoRegulagem) {
			return new JLabel("Servico de Regulagem");
		} else {
			return new JLabel("Servico de Troca de Peca");
		}
	}
	public EstadoInstrumento getEstadoInstrumentoEquivalente(String estadoString) {
	    switch (estadoString) {
	        case "RECEBIDO":
	            return EstadoInstrumento.RECEBIDO;
	        case "EM CONSERTO":
	            return EstadoInstrumento.EM_CONSERTO;
	        case "EM FABRICACAO":
	            return EstadoInstrumento.EM_FABRICACAO;
	        case "EM MANUTENCAO":
	            return EstadoInstrumento.EM_MANUTENCAO;
	        case "PRONTO":
	            return EstadoInstrumento.PRONTO;
	        default:
	            return EstadoInstrumento.CADASTRADO;
	    }
	}

}
