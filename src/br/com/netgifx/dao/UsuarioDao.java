package br.com.netgifx.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.netgifx.model.Usuario;
import br.com.netgifx.util.JpaUtil;

public class UsuarioDao {
	EntityManager entityManager = null;

	private EntityManager getEntityManager() {
		return JpaUtil.getEntityManager();
	}

	public boolean cadastra(Usuario usuario) {

		entityManager = this.getEntityManager();

		boolean sucesso = false;
		try  {
			entityManager.getTransaction().begin(); 
			entityManager.persist(usuario); 
			entityManager.getTransaction().commit();
			sucesso = true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			entityManager.close();
		}
		
		return sucesso;
	}

	public Usuario buscar(int id) {
		entityManager = this.getEntityManager();

		entityManager.getTransaction().begin();
		Usuario usuario = entityManager.find(Usuario.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();

		return usuario;

	}
	
	public Usuario buscarEmail(String email) {
		entityManager = this.getEntityManager();

		entityManager.getTransaction().begin();
		Usuario usuario = (Usuario) entityManager.createQuery("SELECT u FROM Usuario u WHERE u.email = :email")
				.setParameter("email", email).getSingleResult();
		entityManager.getTransaction().commit();
		entityManager.close();

		return usuario;

	}

	public List<Usuario> listar(){
		entityManager = this.getEntityManager();
		Query query = entityManager.createQuery("SELECT f FROM Usuario f"); 
		return query.getResultList();
	}

	public boolean remover(Usuario usuario) {
		
		entityManager = this.getEntityManager();

		boolean sucesso = false;
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(usuario);
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
