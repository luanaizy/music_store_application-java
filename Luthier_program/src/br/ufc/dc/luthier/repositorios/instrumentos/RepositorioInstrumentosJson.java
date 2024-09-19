package br.ufc.dc.luthier.repositorios.instrumentos;

import java.lang.reflect.Type;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.ufc.dc.luthier.exceptions.ExisteOrdemAbertaPInstrException;
import br.ufc.dc.luthier.exceptions.InstInexException;
import br.ufc.dc.luthier.exceptions.InstJaExisteException;
import br.ufc.dc.luthier.instrumentos.Instrumento;
import br.ufc.dc.luthier.instrumentos.estados.EstadoInstrumento;
import br.ufc.dc.luthier.ordens.OrdemDeServico;
import br.ufc.dc.luthier.pessoas.Cliente;

public class RepositorioInstrumentosJson implements IRepositorioInstrumentos {
	private Vector<Instrumento> instrumentos;
	private File path_arquivo;
	private FileReader arquivo_leitura;
	private FileWriter arquivo_escrita;
	
	public RepositorioInstrumentosJson(File diretorio, String nome_novo_arquivo) {
		if (!diretorio.isDirectory()) {
			diretorio.mkdir();
		}
		instrumentos = new Vector<Instrumento>();
		path_arquivo = new File(diretorio, nome_novo_arquivo);

		if (path_arquivo.exists()) {
            try {
                arquivo_leitura = new FileReader(path_arquivo);
                Gson gson = new Gson();
 
                Type tipo_lista_de_instrumentos = new TypeToken<Vector<Instrumento>>(){}.getType();
                Vector<Instrumento> instrumentos_do_arquivo = gson.fromJson(arquivo_leitura, tipo_lista_de_instrumentos);
                arquivo_leitura.close();

                if (instrumentos_do_arquivo != null) {
                	instrumentos = instrumentos_do_arquivo; 
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
	}
	
	
	public Instrumento get(int index)  throws ArrayIndexOutOfBoundsException {
		return instrumentos.get(index);
	}
	
	
	public void inserir(Instrumento instrumento) throws InstJaExisteException {
		try {
			for (Instrumento instrumento_ : instrumentos) {
				if(instrumento_.getNumDeSerie().equals(instrumento.getNumDeSerie())) {
					throw new InstJaExisteException(instrumento_.getNumDeSerie());
				}
			}
			instrumentos.add(instrumento);
		
			arquivo_escrita = new FileWriter(path_arquivo);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			gson.toJson(instrumentos, arquivo_escrita);
			arquivo_escrita.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
	
	public void modificar(int index, String numero_de_serie, String tipo, String marca,
			EstadoInstrumento estado, Cliente proprietario) throws InstJaExisteException  {
		
		for (Instrumento instrumento_ : instrumentos) {
			if(instrumento_.getNumDeSerie().equals(instrumentos.get(index).getNumDeSerie())) {
				throw new InstJaExisteException(instrumento_.getNumDeSerie());
			}
		}
		
		instrumentos.get(index).setNumDeSerie(numero_de_serie);
		instrumentos.get(index).setTipo(tipo);
		instrumentos.get(index).setMarca(marca);
		instrumentos.get(index).setEstado(estado);
		instrumentos.get(index).setCliente(proprietario);
		
		try {
			arquivo_escrita = new FileWriter(path_arquivo);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			gson.toJson(instrumentos, arquivo_escrita);
			arquivo_escrita.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public void remover(String num_de_serie)  throws InstInexException {
		try {
			Instrumento instrumento = procurar(num_de_serie);
			if (instrumento == null) {
				throw new InstInexException(num_de_serie);
			}
			instrumentos.remove(instrumento);
		
			arquivo_escrita = new FileWriter(path_arquivo);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			gson.toJson(instrumentos, arquivo_escrita);
			arquivo_escrita.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public Instrumento procurar(String num_de_serie){
		int i = this.procurar_index(num_de_serie);
		if (i == -1) {
			return null;
		}
		else return instrumentos.get(i);
	}
	
	public int procurar_index(String num_de_serie) {
		for(int i=0; i<instrumentos.size(); i++) {
			if(instrumentos.get(i) != null && instrumentos.get(i).getNumDeSerie().equals(num_de_serie)) {
				return i;
			}
		}
		return -1;
	}
	
	public Instrumento[] listar() {
		Instrumento[] lista_instrumentos = new Instrumento[instrumentos.size()];
		for(int i=0; i<lista_instrumentos.length;i++) {
			lista_instrumentos[i]=instrumentos.get(i);
		}
		return lista_instrumentos;
	}
	
	public int qtd_instrumentos() {
		return instrumentos.size();
	}
	
	public int tamanho_arquivo() {
		long tamanho = path_arquivo.length();
		return (int)tamanho;
	}
}
