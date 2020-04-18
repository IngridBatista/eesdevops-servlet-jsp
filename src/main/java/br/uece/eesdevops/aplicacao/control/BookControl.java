package br.uece.eesdevops.aplicacao.control;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.uece.eesdevops.aplicacao.model.BookEntity;

public class BookControl {
  
  private static EntityManager entityManager;
  
  static EntityManagerFactory factory = Persistence.createEntityManagerFactory("eesdevops");
    
  
  public static List<BookEntity> list(){
      entityManager = factory.createEntityManager();
     List<BookEntity> books = new ArrayList<BookEntity>();
     if (entityManager != null && entityManager.isOpen()) {
     books = entityManager.createQuery("select b from BookEntity b", BookEntity.class).getResultList();
     }
    System.out.println("Chegou aqui!");
     return books;
   }

}