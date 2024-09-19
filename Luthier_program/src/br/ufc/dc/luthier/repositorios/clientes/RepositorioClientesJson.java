package br.ufc.dc.luthier.repositorios.clientes;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.ufc.dc.luthier.exceptions.CIException;
import br.ufc.dc.luthier.exceptions.CJEException;
import br.ufc.dc.luthier.exceptions.ExisteOrdemAbertaPInstrException;
import br.ufc.dc.luthier.instrumentos.Instrumento;
import br.ufc.dc.luthier.ordens.OrdemDeServico;
import br.ufc.dc.luthier.pessoas.Cliente;

public class RepositorioClientesJson implements IRepositorioClientes {
	private Vector<Cliente> clientes;
	private File path_arquivo;
	private FileReader arquivo_leitura;
	private FileWriter arquivo_escrita;
	
	public RepositorioClientesJson(File diretorio, String nome_novo_arquivo) {
		if (!diretorio.isDirectory()) {
			diretorio.mkdir();
		}
		clientes = new Vector<Cliente>();
		path_arquivo = new File(diretorio, nome_novo_arquivo);

		if (path_arquivo.exists()) {
            try {
                arquivo_leitura = new FileReader(path_arquivo);
                Gson gson = new Gson();
 
                Type tipo_lista_de_clientes = new TypeToken<Vector<Cliente>>(){}.getType();
                Vector<Cliente> clientes_do_arquivo = gson.fromJson(arquivo_leitura, tipo_lista_de_clientes);
                arquivo_leitura.close();

                if (clientes_do_arquivo != null) {
                    clientes = clientes_do_arquivo; 
                }
                
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
	}
	
	public Cliente get(int index) throws ArrayIndexOutOfBoundsException  {
		return clientes.get(index);
	}
	
	
	public void inserir(Cliente cliente) throws CJEException {
		try {
			for (Cliente cliente_ : clientes) {
				if(cliente.getCpf().equals(cliente_.getCpf())) {
					throw new CJEException(cliente_.getCpf());
				}
			}
			clientes.add(cliente);

			arquivo_escrita = new FileWriter(path_arquivo);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			gson.toJson(clientes, arquivo_escrita);
			arquivo_escrita.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
	
	public void remover(String cpf) throws CIException {
		try {
			Cliente cliente = procurar(cpf);
			if (cliente == null) {
				throw new CIException(cpf);
			}
			clientes.remove(cliente);
		
			arquivo_escrita = new FileWriter(path_arquivo);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			gson.toJson(clientes, arquivo_escrita);
			arquivo_escrita.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public void modificar(int index,String cpf, String nome, String endereco, String telefone) throws CJEException {
		
		for (Cliente cliente_ : clientes) {
			if(clientes.get(index).getCpf().equals(cliente_.getCpf())) {
				throw new CJEException(cliente_.getCpf());
			}
		}
		
		clientes.get(index).setCpf(cpf);
		clientes.get(index).setNome(nome);
		clientes.get(index).setEndereco(endereco);
		clientes.get(index).setTelefone(telefone);
		
		try {
			arquivo_escrita = new FileWriter(path_arquivo);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			gson.toJson(clientes, arquivo_escrita);
			arquivo_escrita.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public Cliente procurar(String cpf){
		int i = this.procurar_index(cpf);
		if (i == -1) {
			return null;
		}
		else return clientes.get(i);
	}
	
	public Cliente[] listar() {
		Cliente[] lista_clientes = new Cliente[clientes.size()];
		for(int i=0; i<lista_clientes.length;i++) {
			lista_clientes[i]=clientes.get(i);
		}
		return lista_clientes;
	}
	
	public int tamanho_arquivo() {
		long tamanho = path_arquivo.length();
		return (int)tamanho;
	}
	
	public int qtd_clientes() {
		return clientes.size();
	}

	public int procurar_index(String cpf) {
		for(int i=0; i<clientes.size(); i++) {
			if(clientes.get(i) != null && clientes.get(i).getCpf().equals(cpf)) {
				return i;
			}
		}
		return -1;
	}
}
