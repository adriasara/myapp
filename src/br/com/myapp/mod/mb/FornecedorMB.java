package br.com.myapp.mod.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.myapp.mod.pers.Fornecedor;
import br.com.myapp.mod.pers.FornecedorCRUD;
import br.com.myapp.mod.pers.JPAUtil;

@ViewScoped
@ManagedBean
public class FornecedorMB {
	
		private Fornecedor fornecedor = new Fornecedor();
		
		public Fornecedor getFornecedor() {
			return fornecedor;
		}
		
		public void setFornecedor(Fornecedor fornecedor) {
			this.fornecedor = fornecedor;
		}
		
		public List<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>();
		
		public List<Fornecedor> getListaFornecedor() {
			return listaFornecedor;
		}	

		@PostConstruct
		public void carregarFornecedor(){
			EntityManager em = JPAUtil.getEntityManager();
			FornecedorCRUD crud = new FornecedorCRUD(em);
			listaFornecedor = crud.listar();
			em.close();
		}
		
		public void excluir(){
			EntityManager em = JPAUtil.getEntityManager();
			FornecedorCRUD crud = new FornecedorCRUD(em);
			em.getTransaction().begin();
			crud.excluir(fornecedor);
			em.getTransaction().commit();
			em.close();
			carregarFornecedor();
		}

		public void salvar(){
			EntityManager em = JPAUtil.getEntityManager();
			FornecedorCRUD crud = new FornecedorCRUD(em);
			em.getTransaction().begin();
			if(fornecedor.getId()!=null){
				crud.alterar(fornecedor);
			}else{
				crud.cadastrar(fornecedor);
			}
			em.getTransaction().commit();
			em.close();
			fornecedor  = new Fornecedor();
			carregarFornecedor();
		}
}
