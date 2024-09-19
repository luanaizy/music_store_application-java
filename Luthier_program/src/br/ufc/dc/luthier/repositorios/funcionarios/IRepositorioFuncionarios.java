package br.ufc.dc.luthier.repositorios.funcionarios;

import br.ufc.dc.luthier.exceptions.FuncInexistenteException;
import br.ufc.dc.luthier.exceptions.FuncJaInseridoException;
import br.ufc.dc.luthier.pessoas.Funcionario;

public interface IRepositorioFuncionarios {
	public void inserir(Funcionario instrumento) throws FuncJaInseridoException;
	public void remover(String codigo) throws FuncInexistenteException;
	public Funcionario procurar(String codigo);
	public void modificar(int index,String cpf, String nome, String endereco, String telefone);
	public Funcionario get(int index) throws ArrayIndexOutOfBoundsException;
	public int qtd_funcionarios();
}
