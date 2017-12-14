package br.com.netgifx.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class JpaUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("netgifx");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
}