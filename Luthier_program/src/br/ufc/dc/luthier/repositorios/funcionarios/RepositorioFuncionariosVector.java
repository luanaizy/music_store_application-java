package br.ufc.dc.luthier.repositorios.funcionarios;

import java.util.Vector;

import br.ufc.dc.luthier.exceptions.FuncInexistenteException;
import br.ufc.dc.luthier.exceptions.FuncJaInseridoException;
import br.ufc.dc.luthier.pessoas.Funcionario;

public class RepositorioFuncionariosVector implements IRepositorioFuncionarios {
private Vector<Funcionario> funcionarios;
private int incrementador;

	public RepositorioFuncionariosVector(){
		funcionarios = new Vector<Funcionario>();
		incrementador = 1;
	}
	
	public void inserir(Funcionario funcionario) throws FuncJaInseridoException {
		for (Funcionario funcionario_ : funcionarios) {
			if(funcionario_.getCpf().equals(funcionario.getCpf())) {
				throw new FuncJaInseridoException(funcionario_.getCodigo());
			}
		}
		funcionario.setCodigo(String.valueOf(incrementador));
		funcionarios.add(funcionario); //coloca codigo ao funcionario ao ser inserido
		incrementador++;
	}
	
	public Funcionario get(int index) throws ArrayIndexOutOfBoundsException {
		return funcionarios.get(index);
	}
	
	public void remover(String codigo) throws FuncInexistenteException {
		Funcionario funcionario = procurar(codigo);
		if (funcionario == null) {
			throw new FuncInexistenteException(codigo);
		}
		funcionarios.remove(funcionario);
	}
	
	public void modificar(int index,String cpf, String nome, String endereco, String telefone) {
		funcionarios.get(index).setCpf(cpf);
		funcionarios.get(index).setNome(nome);
		funcionarios.get(index).setEndereco(endereco);
		funcionarios.get(index).setTelefone(telefone);
	}
	
	public int procurar_index(String codigo) {
		for(int i=0; i<funcionarios.size(); i++) {
			if(funcionarios.get(i) != null && funcionarios.get(i).getCodigo().equals(codigo)) {
				return i;
			}
		}
		return -1;
	}
	
	public Funcionario procurar(String codigo) {
		int i = this.procurar_index(codigo);
		if (i == -1) {
			return null;
		}
		else return funcionarios.get(i);
	}
	

	//public Funcionario[] listar() {
	//	Funcionario[] lista_funcionarios = new Funcionario[funcionarios.size()];
	//	for(int i=0; i<lista_funcionarios.length;i++) {
	//		lista_funcionarios[i]=funcionarios.get(i);
	//	}
	//	return lista_funcionarios;
	//}
	
	public int qtd_funcionarios() {
		return funcionarios.size();
	}
}
