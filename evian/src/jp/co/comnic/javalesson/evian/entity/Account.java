package jp.co.comnic.javalesson.evian.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ACCOUNT database table.
 * 
 */
@Entity
@NamedQuery(name="Account.findAll", query="SELECT a FROM ACCOUNT a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String email;

	@Column(name="discount_code")
	private String discountCode;

	@Column(name="display_name")
	private String displayName;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	private String password;

	//bi-directional many-to-one association to BookOrder
	@OneToMany(mappedBy="account")
	private List<BookOrder> bookOrders;

	//bi-directional many-to-many association to Book
	@ManyToMany(mappedBy="accounts")
	private List<Book> books;

	public Account() {
	}
	
	
	
	public Account(String email, String discountCode, String displayName, String firstName, String lastName,
			String password, List<BookOrder> bookOrders, List<Book> books) {
		super();
		this.email = email;
		this.discountCode = discountCode;
		this.displayName = displayName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.bookOrders = bookOrders;
		this.books = books;
	}



	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiscountCode() {
		return this.discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<BookOrder> getBookOrders() {
		return this.bookOrders;
	}

	public void setBookOrders(List<BookOrder> bookOrders) {
		this.bookOrders = bookOrders;
	}

	public BookOrder addBookOrder(BookOrder bookOrder) {
		getBookOrders().add(bookOrder);
		bookOrder.setAccount(this);

		return bookOrder;
	}

	public BookOrder removeBookOrder(BookOrder bookOrder) {
		getBookOrders().remove(bookOrder);
		bookOrder.setAccount(null);

		return bookOrder;
	}

	public List<Book> getBooks() {
		return this.books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}