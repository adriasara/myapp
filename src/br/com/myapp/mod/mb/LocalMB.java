package br.com.myapp.mod.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.myapp.mod.pers.Local;
import br.com.myapp.mod.pers.LocalCRUD;
import br.com.myapp.mod.pers.JPAUtil;

@ViewScoped
@ManagedBean
public class LocalMB {
	
		private Local local = new Local();
		
		public Local getLocal() {
			return local;
		}
		
		public void setLocal(Local local) {
			this.local = local;
		}
		
		public List<Local> listaLocal = new ArrayList<Local>();
		
		public List<Local> getListaLocal() {
			return listaLocal;
		}	

		@PostConstruct
		public void carregarLocal(){
			EntityManager em = JPAUtil.getEntityManager();
			LocalCRUD crud = new LocalCRUD(em);
			listaLocal = crud.listar();
			em.close();
		}
		
		public void excluir(){
			EntityManager em = JPAUtil.getEntityManager();
			LocalCRUD crud = new LocalCRUD(em);
			em.getTransaction().begin();
			crud.excluir(local);
			em.getTransaction().commit();
			em.close();
			carregarLocal();
		}

		public void salvar(){
			EntityManager em = JPAUtil.getEntityManager();
			LocalCRUD crud = new LocalCRUD(em);
			em.getTransaction().begin();
			if(local.getId()!=null){
				crud.alterar(local);
			}else{
				crud.cadastrar(local);
			}
			em.getTransaction().commit();
			em.close();
			local  = new Local();
			carregarLocal();
		}
}
