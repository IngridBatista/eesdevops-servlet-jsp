package br.uece.eesdevops.aplicacao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.uece.eesdevops.aplicacao.model.BookEntity;
import br.uece.eesdevops.aplicacao.util.HibernateUtil;

@WebServlet("/books_entities")
public class BookEntityServlet extends HttpServlet {

	private EntityManager entityManager;
	
	@Override
	public void init() {
		
		entityManager = HibernateUtil.INSTANCE.getEntityManagerFactory().createEntityManager();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/plain");
		 List<BookEntity> books = new ArrayList<BookEntity>();
		
		if (entityManager != null && entityManager.isOpen()) {
			books = entityManager.createQuery("select b from EntityBook b", BookEntity.class).getResultList();
		}
		
		PrintWriter writer = res.getWriter();
		for(BookEntity book: books) {
			writer.println(book.toString());
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String resume = req.getParameter("resume");
		String releaseYear = req.getParameter("releaseYear");
		
		
		if(entityManager != null && entityManager.isOpen()) {
			
			EntityTransaction transaction = entityManager.getTransaction();
			
			try {
				transaction.begin();
				BookEntity entity = new BookEntity();
				entity.setTitle(title);
				entity.setAuthor(author);
				entity.setResume(resume);
				entity.setReleaseYear(releaseYear);
				entityManager.persist(entity);
				entityManager.flush();
				transaction.commit();
				
			} catch (Exception e) {
				if (transaction.isActive()) {
					transaction.rollback();
				}  throw new RuntimeException("Unable to save the new book: " + e.getMessage());
			}
		}
		res.sendRedirect("Listbooks.jsp");
	}
	
	@Override
	public void destroy() {
		
		if (entityManager != null && entityManager.isOpen()) {
			entityManager.close();
		}
	}
	
}
