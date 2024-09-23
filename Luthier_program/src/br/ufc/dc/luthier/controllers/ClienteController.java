package br.ufc.dc.luthier.controllers;

import br.ufc.dc.luthier.exceptions.CIException;
import br.ufc.dc.luthier.exceptions.CJEException;
import br.ufc.dc.luthier.pessoas.Cliente;
import br.ufc.dc.luthier.repositorios.clientes.IRepositorioClientes;

public class ClienteController {
	private IRepositorioClientes rep_clientes;
	
	public ClienteController(IRepositorioClientes rep_clientes) {
		this.rep_clientes = rep_clientes;
	}
		
	public void inserir(Cliente cliente) throws CJEException{
		rep_clientes.inserir(cliente);
	}
	public void remover(String cpf) throws CIException{
		rep_clientes.remover(cpf);
	}
	public void modificar(int index,String cpf, String nome, String endereco, 
			String telefone)  throws CJEException{
		rep_clientes.modificar(index, cpf, nome, endereco, telefone);
	}
	public Cliente procurar(String cpf) {
		return rep_clientes.procurar(cpf);
	}
	public int procurar_index(String cpf) {
		return rep_clientes.procurar_index(cpf);
	}
	public Cliente get(int index) throws ArrayIndexOutOfBoundsException {
		return rep_clientes.get(index);
	}
	public Cliente[] listar() {
		return rep_clientes.listar();
	}
	public int qtd_clientes() {
		return rep_clientes.qtd_clientes();
	}
	public int tamanho_arquivo() {
		return rep_clientes.tamanho_arquivo();
	}
	
	
}
