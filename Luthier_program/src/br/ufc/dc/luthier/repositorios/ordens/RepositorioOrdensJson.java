package br.ufc.dc.luthier.repositorios.ordens;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

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

public class RepositorioOrdensJson implements IRepositorioOrdens {
	private Vector<OrdemDeServico> ordens;
	private File path_arquivo;
	private FileReader arquivo_leitura;
	private FileWriter arquivo_escrita;
	private int incrementador;
	
	public RepositorioOrdensJson(File diretorio, String nome_novo_arquivo) {
		incrementador = 1;
		
		if (!diretorio.isDirectory()) {
			diretorio.mkdir();
		}
		ordens = new Vector<OrdemDeServico>();
		path_arquivo = new File(diretorio, nome_novo_arquivo);

		if (path_arquivo.exists()) {
            try {
                arquivo_leitura = new FileReader(path_arquivo);
                Gson gson = new Gson();
 
                Type tipo_lista_de_ordens = new TypeToken<Vector<OrdemDeServico>>(){}.getType();
                Vector<OrdemDeServico> ordens_do_arquivo = gson.fromJson(arquivo_leitura, tipo_lista_de_ordens);
                arquivo_leitura.close();

                if (ordens_do_arquivo != null) {
                    ordens = ordens_do_arquivo; 
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            
            for (OrdemDeServico ordem : ordens) {
            	int numero = Integer.parseInt(ordem.getNumero());
            	if(numero > incrementador) {
            		incrementador = numero;
            	}
            }
            incrementador++;
        }
	}
	
	
	public OrdemDeServico get(int index) {
		return ordens.get(index);
	}
	
	
	public void inserir(OrdemDeServico ordem) throws ExisteOrdemAbertaPInstrException {
		try {
			for (OrdemDeServico ordem_ : ordens) {
				if(ordem.getInstrumento().getNumDeSerie().equals(ordem_.getInstrumento().getNumDeSerie())) {
					throw new ExisteOrdemAbertaPInstrException(ordem_.getNumero());
				}
			}
			ordem.setNumero(String.valueOf(incrementador));
			ordens.add(ordem);
			incrementador++;
		
			arquivo_escrita = new FileWriter(path_arquivo);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			gson.toJson(ordens, arquivo_escrita);
			arquivo_escrita.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
	
	public void remover(String numero)throws OrdemInexistenteException {
		OrdemDeServico ordem = procurar(numero);
		if (ordem == null) {
			throw new OrdemInexistenteException(numero);
		}
		ordens.remove(ordem);
		try {
			arquivo_escrita = new FileWriter(path_arquivo);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			gson.toJson(ordens, arquivo_escrita);
			arquivo_escrita.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public void modificar(int index, Vector<ServicoAbstract> servicos,Cliente cliente, 
			Instrumento instrumento, EstadoInstrumento estado_do_instrumento, 
			String data_prevista_entrega, Funcionario atendente, SituacaoOrdem situacao, 
			Vector<Material> materiais_usados) throws ExisteOrdemAbertaPInstrException {
		
		for (OrdemDeServico ordem_ : ordens) {
			if(ordens.get(index).getInstrumento().getNumDeSerie().equals(ordem_.getInstrumento().getNumDeSerie())) {
				throw new ExisteOrdemAbertaPInstrException(ordem_.getNumero());
			}
		}
			
		ordens.get(index).setServicos(servicos);
		ordens.get(index).setCliente(cliente);
		ordens.get(index).setInstrumento(instrumento);
		ordens.get(index).setEstadoDoInstrumento(estado_do_instrumento);
		ordens.get(index).setData_prevista_entrega(data_prevista_entrega);
		ordens.get(index).setAtendente(atendente);
		ordens.get(index).setSituacao(situacao);
		
		try {
			arquivo_escrita = new FileWriter(path_arquivo);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			gson.toJson(ordens, arquivo_escrita);
			arquivo_escrita.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public OrdemDeServico procurar(String numero){
		int i = this.procurar_index(numero);
		if (i == -1) {
			System.out.println("ops");
			return null;
		}
		else return ordens.get(i);
	}
	
	public int procurar_index(String numero) {
		for(int i=0; i<ordens.size(); i++) {
			if(ordens.get(i) != null && ordens.get(i).getNumero().equals(numero)) {
				return i;
			}
		}
		return -1;
	}
	
	public OrdemDeServico[] listar() {
		OrdemDeServico[] lista_ordens = new OrdemDeServico[ordens.size()];
		for(int i=0; i<lista_ordens.length;i++) {
			lista_ordens[i]=ordens.get(i);
		}
		return lista_ordens;
	}
	
	public int qtd_ordens() {
		return ordens.size();
	}
	
	public int tamanho_arquivo() {
		long tamanho = path_arquivo.length();
		return (int)tamanho;
	}
}
