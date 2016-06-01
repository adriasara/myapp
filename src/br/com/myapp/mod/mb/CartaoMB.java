package br.com.myapp.mod.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.myapp.mod.pers.Cartao;
import br.com.myapp.mod.pers.CartaoCRUD;
import br.com.myapp.mod.pers.JPAUtil;

@ViewScoped
@ManagedBean
public class CartaoMB {
	
		private Cartao cartao = new Cartao();
		
		public Cartao getCartao() {
			return cartao;
		}
		
		public void setCartao(Cartao cartao) {
			this.cartao = cartao;
		}
		
		public List<Cartao> listaCartao = new ArrayList<Cartao>();
		
		public List<Cartao> getListaCartao() {
			return listaCartao;
		}	

		@PostConstruct
		public void carregarCartao(){
			EntityManager em = JPAUtil.getEntityManager();
			CartaoCRUD crud = new CartaoCRUD(em);
			listaCartao = crud.listar();
			em.close();
		}
		
		public void excluir(){
			EntityManager em = JPAUtil.getEntityManager();
			CartaoCRUD crud = new CartaoCRUD(em);
			em.getTransaction().begin();
			crud.excluir(cartao);
			em.getTransaction().commit();
			em.close();
			carregarCartao();
		}

		public void salvar(){
			
			EntityManager em = JPAUtil.getEntityManager();
			CartaoCRUD crud = new CartaoCRUD(em);
			em.getTransaction().begin();
			if(cartao.getId()!=null){
				crud.alterar(cartao);
			}else{
				crud.cadastrar(cartao);
			}
			em.getTransaction().commit();
			em.close();
			cartao  = new Cartao();
			carregarCartao();
		}
}
