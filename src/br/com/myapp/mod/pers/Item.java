package br.com.myapp.mod.pers;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item {
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String descricaoSilmple;
	private String descricaoCompleta;
	private float preco;
	
	// comencando get e set
	
	public String getNome() {
		return nome;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricaoSilmple() {
		return descricaoSilmple;
	}
	public void setDescricaoSilmple(String descricaoSilmple) {
		this.descricaoSilmple = descricaoSilmple;
	}
	public String getDescricaoCompleta() {
		return descricaoCompleta;
	}
	public void setDescricaoCompleta(String descricaoCompleta) {
		this.descricaoCompleta = descricaoCompleta;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
}
