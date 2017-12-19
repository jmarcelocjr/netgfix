package br.com.netgifx.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.netgifx.model.Usuario;
import br.com.netgifx.model.gif.Categoria;
import br.com.netgifx.util.JpaUtil;

public class CategoriaDao {
	EntityManager entityManager = null;

	private EntityManager getEntityManager() {
		return JpaUtil.getEntityManager();
	}

	public boolean cadastra(Categoria categoria) {

		entityManager = this.getEntityManager();

		boolean sucesso = false;
		try  {
			entityManager.getTransaction().begin(); 
			entityManager.persist(categoria); 
			entityManager.getTransaction().commit();
			sucesso = true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			entityManager.close();
		}
		
		return sucesso;
	}

	public Categoria buscar(String descricao) {
		entityManager = this.getEntityManager();

		entityManager.getTransaction().begin();
		Categoria categoria = entityManager.find(Categoria.class, descricao);
		entityManager.getTransaction().commit();
		entityManager.close();

		return categoria;

	}

	public List<Categoria> listar(){
		entityManager = this.getEntityManager();
		Query query = entityManager.createQuery("SELECT f FROM Categoria f"); 
		return query.getResultList();
	}

	public boolean remover(Categoria categoria) {
		
		entityManager = this.getEntityManager();

		boolean sucesso = false;
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(categoria);
			entityManager.getTransaction().commit();
			sucesso = true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			entityManager.close();
		}
		
		return sucesso;
		
	}

}
