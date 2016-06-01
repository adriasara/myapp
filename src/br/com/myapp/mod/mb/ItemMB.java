package br.com.myapp.mod.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.myapp.mod.pers.Item;
import br.com.myapp.mod.pers.ItemCRUD;
import br.com.myapp.mod.pers.JPAUtil;

@ViewScoped
@ManagedBean
public class ItemMB {
	
	private Item item;
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public List<Item> listaItem = new ArrayList<Item>();
	
	public List<Item> getListaItem(){
		return listaItem;
	}
	
	@PostConstruct
	public void carregarItem(){
		EntityManager em = JPAUtil.getEntityManager();
		ItemCRUD crud = new ItemCRUD(em);
		listaItem = crud.listar();
		em.close();
	}
	
	public void excluir(){
		EntityManager em = JPAUtil.getEntityManager();
		ItemCRUD crud = new ItemCRUD(em);
		em.getTransaction().begin();
		crud.excluir(item);
		em.getTransaction().commit();
		em.close();
		carregarItem();
	}

	public void salvar(){
		
		EntityManager em = JPAUtil.getEntityManager();
		ItemCRUD crud = new ItemCRUD(em);
		em.getTransaction().begin();
		if(item.getId()!=null){
			crud.alterar(item);
		}else{
			crud.cadastrar(item);
		}
		em.getTransaction().commit();
		em.close();
		item  = new Item();
		carregarItem();
	}

}
