package br.com.myapp.mod.pers;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@SuppressWarnings("unchecked")
public class CardapioCRUD {
	
	private EntityManager entityManager;

	public CardapioCRUD(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	public void cadastrar(Cardapio cardapio){
		entityManager.persist(cardapio);
	}
	public void alterar(Cardapio cardapio){
		entityManager.merge(cardapio);
	}
	public void excluir(Cardapio cardapio){
		entityManager.remove(entityManager.merge(cardapio));
	}
	
	public Cardapio consultar(Long id){
		return entityManager.getReference(Cardapio.class, id);
	}
	
	public List<Cardapio> listar(){
		String jpql = "Select c from Cardapio c order by c.nome";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

}
