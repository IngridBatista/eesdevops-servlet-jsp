package br.uece.eesdevops.aplicacao.model;

import javax.persistence.*;

@Entity
@Table(name = "books") 
public class BookEntity {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "auhor", nullable = false)
	private String author;
	
	@Column(name = "resume", nullable = false)
	private String resume;

	@Column(name = "releaseYear", nullable = false)
	private String releaseYear;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	@Override
	public String toString() {
		return "BookEntity{" +
	            "id=" + id +
	            ", title='" + title + '\'' +
	            ", author='" + author + '\'' +
	            ", resume='" + resume + '\'' +
	            ", releaseYear='" + releaseYear + '\'' +
	            '}';
	}
}
