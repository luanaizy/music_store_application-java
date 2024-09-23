package br.ufc.dc.luthier.pessoas;

public class Cliente extends PessoaAbstract{
	public Cliente(String nome, String cpf, String endereco, String telefone) {
		super(cpf, nome, endereco, telefone);
	}
}
