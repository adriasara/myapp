package br.com.myapp.mod.pers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
		
		private static EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("myapp");

		public static EntityManager getEntityManager() {
			return emf.createEntityManager();
	}
}
