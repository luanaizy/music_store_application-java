package br.ufc.dc.luthier.repositorios.materiais;

import br.ufc.dc.luthier.exceptions.MatInexException;
import br.ufc.dc.luthier.materiais.Material;

public interface IRepositorioMateriais {
	public void inserir(Material material);
	public void remover(String codigo) throws MatInexException;
	public Material procurar(String codigo);
	public Material get(int index) throws ArrayIndexOutOfBoundsException;
	public int qtd_funcionarios();
}
