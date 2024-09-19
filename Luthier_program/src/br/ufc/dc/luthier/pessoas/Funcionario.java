package br.ufc.dc.luthier.pessoas;

public class Funcionario extends PessoaAbstract { //sem codigo por enquanto, colocar ao entrar no repositorio
	private String codigo_funcionario;
	public Funcionario(String cpf, String nome, String endereco, String telefone) {
		super(cpf, nome, endereco, telefone);
	}
	public String getCodigo() {return codigo_funcionario;}
	public void setCodigo(String codigo_funcionario) {this.codigo_funcionario = codigo_funcionario;}
}
