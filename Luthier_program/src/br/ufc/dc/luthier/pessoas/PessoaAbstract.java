package br.ufc.dc.luthier.pessoas;

public abstract class PessoaAbstract {
	private String cpf;
	private String nome;
	private String endereco;
	private String telefone;
	
	public PessoaAbstract(String cpf, String nome, String endereco, String telefone) {
		this.cpf = cpf;
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setTelefone(telefone);
	}
	public String getCpf() {return cpf;}
	public void setCpf(String cpf) {this.cpf = cpf;}
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	public String getEndereco() {return endereco;}
	public void setEndereco(String endereco) {this.endereco = endereco;}
	public String getTelefone() {return telefone;}
	public void setTelefone(String telefone) {this.telefone = telefone;}
}
