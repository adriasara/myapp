package br.com.myapp.mod.pers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@SuppressWarnings("unchecked")
public class CategoriaCRUD<T> {

	private EntityManager entityManager;

	public CategoriaCRUD(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	public void cadastrar(Categoria categoria){
		entityManager.persist(categoria);
	}
	public void alterar(Categoria categoria){
		entityManager.merge(categoria);
	}
	public void excluir(Categoria categoria){
		entityManager.remove(entityManager.merge(categoria));
	}
	
	public Categoria consultar(Long id){
		return entityManager.getReference(Categoria.class, id);
	}
	
	public List<Categoria> listar(){
		String jpql = "Select c from Categoria c order by c.nome";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
}
