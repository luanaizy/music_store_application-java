package br.ufc.dc.luthier.repositorios.ordens;

import java.util.Vector;

import br.ufc.dc.luthier.exceptions.ExisteOrdemAbertaPInstrException;
import br.ufc.dc.luthier.exceptions.OrdemInexistenteException;
import br.ufc.dc.luthier.instrumentos.Instrumento;
import br.ufc.dc.luthier.instrumentos.estados.EstadoInstrumento;
import br.ufc.dc.luthier.materiais.Material;
import br.ufc.dc.luthier.ordens.OrdemDeServico;
import br.ufc.dc.luthier.ordens.situacao.SituacaoOrdem;
import br.ufc.dc.luthier.pessoas.Cliente;
import br.ufc.dc.luthier.pessoas.Funcionario;
import br.ufc.dc.luthier.servicos.ServicoAbstract;

public interface IRepositorioOrdens {
	public void inserir(OrdemDeServico ordem) throws ExisteOrdemAbertaPInstrException;
	public void remover(String numero) throws OrdemInexistenteException;
	public OrdemDeServico procurar(String numero);
	public int procurar_index(String numero);
	public void modificar(int index, Vector<ServicoAbstract> servicos,Cliente cliente, 
			Instrumento instrumento, EstadoInstrumento estado_do_instrumento, 
			String data_prevista_entrega, Funcionario atendente, SituacaoOrdem situacao, 
			Vector<Material> materiais_usados) throws ExisteOrdemAbertaPInstrException;
	public OrdemDeServico get(int index) throws ArrayIndexOutOfBoundsException;
	public OrdemDeServico[] listar();
	public int qtd_ordens();
	public int tamanho_arquivo();
}
