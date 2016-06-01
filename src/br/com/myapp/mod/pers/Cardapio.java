package br.com.myapp.mod.pers;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cardapio {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String periodo;
	private String InformacoesExtra;
	private Categoria categoria;
	private String descricaoSimple;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getInformacoesExtra() {
		return InformacoesExtra;
	}
	public void setInformacoesExtra(String informacoesExtra) {
		InformacoesExtra = informacoesExtra;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getDescricaoSimple() {
		return descricaoSimple;
	}
	public void setDescricaoSimple(String descricaoSimple) {
		this.descricaoSimple = descricaoSimple;
	}
		
}