package br.ufc.dc.luthier.controllers;

import br.ufc.dc.luthier.exceptions.InstInexException;
import br.ufc.dc.luthier.exceptions.InstJaExisteException;
import br.ufc.dc.luthier.instrumentos.Instrumento;
import br.ufc.dc.luthier.instrumentos.estados.EstadoInstrumento;
import br.ufc.dc.luthier.pessoas.Cliente;
import br.ufc.dc.luthier.repositorios.instrumentos.IRepositorioInstrumentos;

public class InstrumentoController {
	private IRepositorioInstrumentos rep_instrumentos;
	
	public InstrumentoController(IRepositorioInstrumentos rep_instrumentos) {
		this.rep_instrumentos = rep_instrumentos;
	}
	
	public int qtd_instrumentos() {
		return rep_instrumentos.qtd_instrumentos();
	}
	
	public Instrumento procurar(String num_serie) {
		return rep_instrumentos.procurar(num_serie);
	}
	
	public Instrumento get(int index) throws ArrayIndexOutOfBoundsException  {
		return rep_instrumentos.get(index);
	}
	
	public void inserir(Instrumento instrumento) throws InstJaExisteException {
		rep_instrumentos.inserir(instrumento);
	}
	
	public void remover(String num_de_serie) throws  InstInexException {
		rep_instrumentos.remover(num_de_serie);
	}
	
	public void modificar(int index, String num_serie, String tipo, String marca,
			EstadoInstrumento estado, Cliente proprietario) throws InstJaExisteException{
		rep_instrumentos.modificar(index, num_serie, tipo, marca, estado, proprietario);
	}
}
