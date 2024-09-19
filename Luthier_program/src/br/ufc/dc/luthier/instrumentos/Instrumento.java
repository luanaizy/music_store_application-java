package br.ufc.dc.luthier.instrumentos;

import br.ufc.dc.luthier.instrumentos.estados.EstadoInstrumento;
import br.ufc.dc.luthier.pessoas.Cliente;

public class Instrumento {
	private String numero_de_serie;
	private String tipo;
	private String marca;
	private EstadoInstrumento estado;
	private Cliente proprietario;
	
	public Instrumento(String numero_de_serie, String tipo, String marca,
			EstadoInstrumento estado, Cliente proprietario) {
		this.numero_de_serie = numero_de_serie;
		this.tipo = tipo;
		this.marca = marca;
		this.estado = estado;
		this.proprietario = proprietario;
	}
	public void setNumDeSerie(String numero_de_serie) {this.numero_de_serie = numero_de_serie;}
	public void setTipo(String tipo) {this.tipo = tipo;}
	public void setMarca(String marca) {this.marca = marca;}
	public void setEstado(EstadoInstrumento estado) {this.estado = estado;}
	public void setCliente(Cliente proprietario) {this.proprietario = proprietario;}
	public String getTipo() {return tipo;}
	public String getMarca() {return marca;}
	public Cliente getProprietario() {return proprietario;}
	public EstadoInstrumento getEstado() {return estado;}
	public String getNumDeSerie() {return numero_de_serie;}
}
