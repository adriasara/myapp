package br.com.myapp.mod.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.myapp.mod.pers.Cardapio;
import br.com.myapp.mod.pers.CardapioCRUD;
import br.com.myapp.mod.pers.JPAUtil;

@ViewScoped
@ManagedBean
public class CardapioMB {
	
	private Cardapio cardapio;
	
	public Cardapio getCardapio() {
		return cardapio;
	}

	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}

	public List<Cardapio> listaCardapio = new ArrayList<Cardapio>();
	
	public List<Cardapio> getListaCardapio(){
		return listaCardapio;
	}
	
	@PostConstruct
	public void carregarCardapio(){
		EntityManager em = JPAUtil.getEntityManager();
		CardapioCRUD crud = new CardapioCRUD(em);
		listaCardapio = crud.listar();
		em.close();
	}
	
	public void excluir(){
		EntityManager em = JPAUtil.getEntityManager();
		CardapioCRUD crud = new CardapioCRUD(em);
		em.getTransaction().begin();
		crud.excluir(cardapio);
		em.getTransaction().commit();
		em.close();
		carregarCardapio();
	}

	public void salvar(){
		
		EntityManager em = JPAUtil.getEntityManager();
		CardapioCRUD crud = new CardapioCRUD(em);
		em.getTransaction().begin();
		if(cardapio.getId()!=null){
			crud.alterar(cardapio);
		}else{
			crud.cadastrar(cardapio);
		}
		em.getTransaction().commit();
		em.close();
		cardapio  = new Cardapio();
		carregarCardapio();
	}

}
