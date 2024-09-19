package br.ufc.dc.luthier.repositorios.materiais;

import java.util.Vector;

import br.ufc.dc.luthier.exceptions.MatInexException;
import br.ufc.dc.luthier.materiais.Material;

public class RepositorioMateriaisVector {
private Vector<Material> materiais;
private int incrementador;
	
	public RepositorioMateriaisVector(){
		materiais = new Vector<Material>();
		incrementador = 1;
	}
	
	public void inserir(Material material) {
		material.setCodigo(String.valueOf(incrementador));
		materiais.add(material);
		incrementador++;
	}
	
	public void remover(String codigo) throws MatInexException {
		Material material = procurar(codigo);
		if (material == null) {
			throw new MatInexException();
		}
		materiais.remove(material);
	}
	
	public int procurar_index(String codigo) {
		for(int i=0; i<materiais.size(); i++) {
			if(materiais.get(i) != null && materiais.get(i).getCodigo().equals(codigo)) {
				return i;
			}
		}
		return -1;
	}
	
	public Material procurar(String codigo) {
		int i = this.procurar_index(codigo);
		if (i == -1) {
			return null;
		}
		else return materiais.get(i);
	}
	
	public Material get(int index) throws ArrayIndexOutOfBoundsException {
		return materiais.get(index);
	}
	
	//public Material[] listar() {
	//	Material[] lista_materiais = new Material[materiais.size()];
	//	for(int i=0; i<lista_materiais.length;i++) {
	//		lista_materiais[i]=materiais.get(i);
	//	}
	//	return lista_materiais;
	//}
	
	public int tamanho() {
		return materiais.size();
	}
}
