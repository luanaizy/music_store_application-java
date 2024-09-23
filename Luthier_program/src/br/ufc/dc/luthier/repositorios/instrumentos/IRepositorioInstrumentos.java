package br.ufc.dc.luthier.repositorios.instrumentos;

import br.ufc.dc.luthier.exceptions.InstInexException;
import br.ufc.dc.luthier.exceptions.InstJaExisteException;
import br.ufc.dc.luthier.instrumentos.Instrumento;
import br.ufc.dc.luthier.instrumentos.estados.EstadoInstrumento;
import br.ufc.dc.luthier.pessoas.Cliente;

public interface IRepositorioInstrumentos {
	public void inserir(Instrumento instrumento)throws InstJaExisteException;
	public void remover(String num_serie) throws InstInexException;
	public Instrumento procurar(String num_serie);
	public int procurar_index(String num_serie);
	public void modificar(int index, String num_serie, String tipo, String marca,
			EstadoInstrumento estado, Cliente proprietario) throws InstJaExisteException;
	public Instrumento get(int index) throws ArrayIndexOutOfBoundsException  ;
	public Instrumento[] listar();
	public int qtd_instrumentos();
	public int tamanho_arquivo();
}
