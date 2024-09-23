package br.ufc.dc.luthier.controllers;

import br.ufc.dc.luthier.pessoas.Funcionario;
import br.ufc.dc.luthier.repositorios.funcionarios.IRepositorioFuncionarios;

public class FuncionarioController {
private IRepositorioFuncionarios rep_funcionarios;
	
	public FuncionarioController(IRepositorioFuncionarios rep_funcionarios) {
		this.rep_funcionarios = rep_funcionarios;
	}
	public Funcionario procurar (String cod_funcionario) {
		return rep_funcionarios.procurar(cod_funcionario);
	}
	public int qtd_funcionarios() {
		return rep_funcionarios.qtd_funcionarios();
	}
	public Funcionario get(int index) throws ArrayIndexOutOfBoundsException{
		return rep_funcionarios.get(index);
	}
}
