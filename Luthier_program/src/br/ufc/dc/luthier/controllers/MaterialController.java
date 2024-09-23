package br.ufc.dc.luthier.controllers;

import br.ufc.dc.luthier.exceptions.MatInexException;
import br.ufc.dc.luthier.materiais.Material;
import br.ufc.dc.luthier.repositorios.materiais.IRepositorioMateriais;

public class MaterialController {
private IRepositorioMateriais rep_materiais;
	
	public MaterialController(IRepositorioMateriais rep_materiais) {
		this.rep_materiais = rep_materiais;
	}
	public void inserir(Material material) {
		rep_materiais.inserir(material);
	}
	public void remover(String codigo) throws MatInexException{
		rep_materiais.remover(codigo);
	}
	public Material procurar(String codigo) {
		return rep_materiais.procurar(codigo);
	}
	public Material get(int index) throws ArrayIndexOutOfBoundsException{
		return rep_materiais.get(index);
	}
	public int qtd_materiais() {
		return rep_materiais.qtd_materiais();
	}
}
