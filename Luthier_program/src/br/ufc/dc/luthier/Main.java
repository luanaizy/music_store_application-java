package br.ufc.dc.luthier;

import java.io.File;

import br.ufc.dc.luthier.controllers.ClienteController;
import br.ufc.dc.luthier.controllers.FuncionarioController;
import br.ufc.dc.luthier.controllers.InstrumentoController;
import br.ufc.dc.luthier.controllers.MaterialController;
import br.ufc.dc.luthier.controllers.OrdemController;
import br.ufc.dc.luthier.exceptions.FuncJaInseridoException;
import br.ufc.dc.luthier.gui.janelas.JanelaHome;
import br.ufc.dc.luthier.materiais.Material;
import br.ufc.dc.luthier.pessoas.Funcionario;
import br.ufc.dc.luthier.repositorios.clientes.RepositorioClientesJson;
import br.ufc.dc.luthier.repositorios.funcionarios.RepositorioFuncionariosVector;
import br.ufc.dc.luthier.repositorios.instrumentos.RepositorioInstrumentosJson;
import br.ufc.dc.luthier.repositorios.materiais.RepositorioMateriaisVector;
import br.ufc.dc.luthier.repositorios.ordens.RepositorioOrdensJson;

public class Main {

	public static void main(String[] args) {

		try {
			RepositorioClientesJson rep_clientes = 
					new RepositorioClientesJson(new File("C:\\Users\\Luana\\Desktop\\Luthier"), "clientes.json" );
			
			RepositorioFuncionariosVector rep_funcionarios = new RepositorioFuncionariosVector();
			rep_funcionarios.inserir(new Funcionario("032.112.998-87", "Luiza", "Rua 23", "0972130233"));
			rep_funcionarios.inserir(new Funcionario("031.112.943-87", "Jorge", "Rua 23", "0972130233"));
			rep_funcionarios.inserir(new Funcionario("033.112.298-87", "Sabao", "Rua 23", "0972130233"));
			
			
			RepositorioInstrumentosJson rep_instrumentos = 
							new RepositorioInstrumentosJson(new File("C:\\Users\\Luana\\Desktop\\Luthier"), "instrumentos.json");	
			
			RepositorioMateriaisVector rep_materiais = new RepositorioMateriaisVector();		
			rep_materiais.inserir(new Material("Cordas", "Oti materiais", 23.59));
			rep_materiais.inserir(new Material("Juliete", "Oti materiais", 24.69));
			rep_materiais.inserir(new Material("Afinadores", "Tmj materiais", 30.59));
			
			
			RepositorioOrdensJson rep_ordens = new RepositorioOrdensJson(new File("C:\\Users\\Luana\\Desktop\\Luthier"), "ordens.json");	
			
			
			ClienteController cliente_controller = new ClienteController(rep_clientes);
			FuncionarioController funcionario_controller = new FuncionarioController(rep_funcionarios);
			InstrumentoController instrumento_controller = new InstrumentoController(rep_instrumentos);
			MaterialController material_controller = new MaterialController(rep_materiais);
			OrdemController ordem_controller = new OrdemController(rep_ordens);
			
			
			
			new JanelaHome(cliente_controller, funcionario_controller, 
					instrumento_controller, material_controller,ordem_controller );
		
		} catch (FuncJaInseridoException e) {
			System.out.println(e.getMessage() + "código: " + e.getCodigo());
		}


}
}
