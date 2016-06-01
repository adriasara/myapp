package br.com.myapp.mod.pers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@SuppressWarnings("unchecked")
public class ItemCRUD {
	
	private EntityManager entityManager;

	public ItemCRUD(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	public void cadastrar(Item item){
		entityManager.persist(item);
	}
	public void alterar(Item item){
		entityManager.merge(item);
	}
	public void excluir(Item item){
		entityManager.remove(entityManager.merge(item));
	}
	
	public Item consultar(Long id){
		return entityManager.getReference(Item.class, id);
	}
	
	public List<Item> listar(){
		String jpql = "Select c from item c order by c.nome";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

}
