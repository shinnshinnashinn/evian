package jp.co.comnic.javalesson.evian.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the AUTHOR database table.
 * 
 */
@Entity
@NamedQuery(name="Author.findAll", query="SELECT a FROM Author a")
public class Author implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String biography;

	private String email;

	private String name;

	private String residence;

	private String title;

	//bi-directional many-to-many association to Book
	@ManyToMany(mappedBy="authors")
	private List<Book> books;

	public Author() {
	}
	
	

	public Author(int id, String biography, String email, String name, String residence, String title,
			List<Book> books) {
		super();
		this.id = id;
		this.biography = biography;
		this.email = email;
		this.name = name;
		this.residence = residence;
		this.title = title;
		this.books = books;
	}



	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBiography() {
		return this.biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResidence() {
		return this.residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Book> getBooks() {
		return this.books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}