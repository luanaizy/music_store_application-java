package br.ufc.dc.luthier;

import java.io.File;
import java.util.Vector;

import br.ufc.dc.luthier.exceptions.CIException;
import br.ufc.dc.luthier.exceptions.CJEException;
import br.ufc.dc.luthier.exceptions.ExisteOrdemAbertaPInstrException;
import br.ufc.dc.luthier.exceptions.FuncJaInseridoException;
import br.ufc.dc.luthier.exceptions.InstJaExisteException;
import br.ufc.dc.luthier.gui.janelas.JanelaHome;
import br.ufc.dc.luthier.instrumentos.Instrumento;
import br.ufc.dc.luthier.instrumentos.estados.EstadoInstrumento;
import br.ufc.dc.luthier.materiais.Material;
import br.ufc.dc.luthier.ordens.OrdemDeServico;
import br.ufc.dc.luthier.pessoas.Cliente;
import br.ufc.dc.luthier.pessoas.Funcionario;
import br.ufc.dc.luthier.repositorios.clientes.RepositorioClientesJson;
import br.ufc.dc.luthier.repositorios.funcionarios.RepositorioFuncionariosVector;
import br.ufc.dc.luthier.repositorios.instrumentos.RepositorioInstrumentosJson;
import br.ufc.dc.luthier.repositorios.materiais.RepositorioMateriaisVector;
import br.ufc.dc.luthier.repositorios.ordens.RepositorioOrdensJson;
import br.ufc.dc.luthier.servicos.ServicoAbstract;
import br.ufc.dc.luthier.servicos.ServicoManutencaoConserto;
import br.ufc.dc.luthier.servicos.ServicoManutencaoRegulagem;

public class Main {

	public static void main(String[] args) {
		try {
		Cliente cliente1 = new Cliente("033.654.998-87", "Luana", "Rua 1", "0978083123");
		Cliente cliente2 = new Cliente("044.624.998-87", "Claudia", "Rua 3", "097823483");
		Cliente cliente3 = new Cliente("033.654.494-87", "Gloria", "Rua 5", "092348083");
		
		RepositorioClientesJson rep_clientes_json = 
				new RepositorioClientesJson(new File("C:\\Users\\Luana\\Desktop\\Luthier"), "clientes.json" );
		
		rep_clientes_json.inserir(cliente1);
		rep_clientes_json.inserir(cliente2);
		rep_clientes_json.inserir(cliente3);
		rep_clientes_json.remover(cliente3.getCpf());
		
		
		
		Funcionario funcionario1 = new Funcionario("032.112.998-87", "Luiza", "Rua 23", "0972130233");
		Funcionario funcionario2 = new Funcionario("031.112.943-87", "Jorge", "Rua 23", "0972130233");
		Funcionario funcionario3 = new Funcionario("033.112.298-87", "Sabao", "Rua 23", "0972130233");
		
		RepositorioFuncionariosVector rep_func_vector = new RepositorioFuncionariosVector();
		
		rep_func_vector.inserir(funcionario1);
		rep_func_vector.inserir(funcionario2);
		rep_func_vector.inserir(funcionario3);
		
		
		Instrumento instrumento1 = new Instrumento("123123","Baixo", "Opa", EstadoInstrumento.RECEBIDO, cliente1);
		Instrumento instrumento2 = new Instrumento("12333123","Guitarra", "Aloa", EstadoInstrumento.RECEBIDO, cliente1);
		Instrumento instrumento3 = new Instrumento("123323","Baixo", "Opa", EstadoInstrumento.RECEBIDO, cliente3);
		
		RepositorioInstrumentosJson rep_inst_json = 
				new RepositorioInstrumentosJson(new File("C:\\Users\\Luana\\Desktop\\Luthier"), "instrumentos.json");
		
		rep_inst_json.inserir(instrumento2);
		rep_inst_json.inserir(instrumento3);
		rep_inst_json.inserir(instrumento1);
		
		
		Material material1 = new Material("Cordas", "Oti materiais", 23.59);
		Material material2 = new Material("Juliete", "Oti materiais", 24.69);
		Material material3 = new Material("Afinadores", "Oti materiais", 30.59);
		
		RepositorioMateriaisVector rep_mat_vector = new RepositorioMateriaisVector();
		
		rep_mat_vector.inserir(material1);
		rep_mat_vector.inserir(material2);
		rep_mat_vector.inserir(material3);
		
		
		
		ServicoAbstract servico1 = new ServicoManutencaoRegulagem("regulagem né", 20);
		ServicoAbstract servico2 = new ServicoManutencaoConserto("conserto de peça quebrada", 22, "cordas");
		Vector<ServicoAbstract> vector_servicos = new Vector<ServicoAbstract>();
		vector_servicos.add(servico1);
		vector_servicos.add(servico2);
		
		OrdemDeServico ordem1 = new OrdemDeServico(vector_servicos, instrumento1, "10/12/2024", funcionario1);
		
		RepositorioOrdensJson rep_ordens_json = new RepositorioOrdensJson(new File("C:\\Users\\Luana\\Desktop\\Luthier"), "ordens.json");
		rep_ordens_json.inserir(ordem1);
		ordem1.print();
				//protected OrdemDeServico( Vector<ServicoAbstract> servicos, 
				//	Instrumento instrumento, String data_prevista_entrega, Funcionario atendente )
		
		JanelaHome window = new JanelaHome();
		
		
		
		
		
		
		
		
		} catch (CJEException c_ja_existe_e){
			System.out.println(c_ja_existe_e.getMessage() + c_ja_existe_e.getCpf());
		}catch(CIException cie){
			System.out.println(cie.getMessage());
		} catch (ArrayIndexOutOfBoundsException index_invalido_e) {
			System.out.println("Tentativa de acessar index inválido!");
		} catch (FuncJaInseridoException e) {
			System.out.println(e.getMessage() + "código: " + e.getCodigo());
		} catch (InstJaExisteException e) {
			System.out.println(e.getMessage() + "num de serie: " + e.getNumDeSerie());
		} catch (ExisteOrdemAbertaPInstrException e) {
			System.out.println(e.getMessage() + "numero " + e.getNumOrdemAberta());
		}
		
	}
}
