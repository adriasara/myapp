package br.com.myapp.mod.pers;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.myapp.mod.pers.Fornecedor;

@SuppressWarnings("unchecked")

public class FornecedorCRUD {
	private EntityManager entityManager;

	public FornecedorCRUD(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	public void cadastrar(Fornecedor fornecedor){
		entityManager.persist(fornecedor);
	}
	public void alterar(Fornecedor fornecedor){
		entityManager.merge(fornecedor);
	}
	public void excluir(Fornecedor fornecedor){
		entityManager.remove(entityManager.merge(fornecedor));
	}
	
	public Fornecedor consultar(Long id){
		return entityManager.getReference(Fornecedor.class, id);
	}
	
	public List<Fornecedor> listar(){
		String jpql = "Select f from Fornecedor f order by f.nome";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
}
