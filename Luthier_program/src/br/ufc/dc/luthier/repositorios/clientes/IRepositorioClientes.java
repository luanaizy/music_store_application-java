package br.ufc.dc.luthier.repositorios.clientes;

import br.ufc.dc.luthier.exceptions.CIException;
import br.ufc.dc.luthier.exceptions.CJEException;
import br.ufc.dc.luthier.pessoas.Cliente;

public interface IRepositorioClientes {
		public void inserir(Cliente cliente) throws CJEException;
		public void remover(String cpf) throws CIException;
		public void modificar(int index,String cpf, String nome, String endereco, 
				String telefone)  throws CJEException;
		public Cliente procurar(String cpf);
		public int procurar_index(String cpf);
		public Cliente get(int index) throws ArrayIndexOutOfBoundsException ;
		public Cliente[] listar();
		public int qtd_clientes();
		public int tamanho_arquivo();
}
