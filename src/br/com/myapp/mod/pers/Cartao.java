package br.com.myapp.mod.pers;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 
public class Cartao {
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	private Double parcela;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getParcela() {
		return parcela;
	}
	public void setParcela(Double parcela) {
		this.parcela = parcela;
	}
}
