package br.com.netgifx.dao;

import java.io.File;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.web.multipart.MultipartFile;

import br.com.netgifx.model.gif.Gif;
import br.com.netgifx.util.JpaUtil;

public class GifDao {
	EntityManager entityManager = null;

	private EntityManager getEntityManager() {
		return JpaUtil.getEntityManager();
	}

	public boolean cadastra(Gif gif, MultipartFile file) {

		entityManager = this.getEntityManager();

		boolean sucesso = false;
		try  {
			entityManager.getTransaction().begin(); 
			entityManager.persist(gif); 
			entityManager.getTransaction().commit();
			sucesso = true;
			
			String filePath = "WebContent" +
					File.separator + "gifs" +
					File.separator + gif.getId() + ".gif";
			System.out.println(filePath);

			file.transferTo(new File(filePath));

		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			entityManager.close();
		}
				
		return sucesso;
	}

	public Gif buscar(int id) {
		entityManager = this.getEntityManager();

		entityManager.getTransaction().begin();
		Gif gif = entityManager.find(Gif.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();

		return gif;

	}

	public List<Gif> listar(){
		entityManager = this.getEntityManager();
		Query query = entityManager.createQuery("SELECT f FROM Gif f"); 
		return query.getResultList();
	}

	public boolean remover(Gif gif) {
		
		entityManager = this.getEntityManager();

		boolean sucesso = false;
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(gif);
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
