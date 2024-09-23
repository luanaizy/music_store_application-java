package br.ufc.dc.luthier.ordens.notificacoes;

public class Notificacao{
	private String mensagem;
	public Notificacao(String mensagem){
		this.mensagem = mensagem;
	}
	public void setMensagem(String nova_mensagem) {mensagem = nova_mensagem;}
	public String getMensagem() {return mensagem;}
}