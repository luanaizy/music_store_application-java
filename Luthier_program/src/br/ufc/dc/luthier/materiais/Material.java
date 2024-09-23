package br.ufc.dc.luthier.materiais;

public class Material {
	private String codigo;
	private String tipo;
	private String marca;
	private double valor;
	
	public Material(String tipo, String marca, double valor) {
		this.tipo = tipo;
		this.marca = marca;
		this.valor = valor;
	}
	
	public void setCodigo(String codigo) {this.codigo = codigo;}
	public double getValor() {return valor;}
	public String getTipo() {return tipo;}
	public String getMarca() {return marca;}
	public String getCodigo() {return codigo;}
	
	public void print() {
		System.out.println("tipo: " + tipo + " codigo: " + codigo);
	}
}
