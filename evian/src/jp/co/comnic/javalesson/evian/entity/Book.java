package jp.co.comnic.javalesson.evian.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the BOOK database table.
 * 
 */
@Entity
@NamedQuery(name="Book.findAll", query="SELECT b FROM Book b")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String isbn;

	private String description;

	@Column(name="early_release")
	private byte earlyRelease;

	@Temporal(TemporalType.DATE)
	@Column(name="final_release_date")
	private Date finalReleaseDate;

	private String formats;

	private int pages;

	private float price;

	private String title;

	//bi-directional many-to-one association to Category
	@ManyToOne
	private Category category;

	//bi-directional many-to-one association to Publisher
	@ManyToOne
	private Publisher publisher;

	//bi-directional many-to-many association to Author
	@ManyToMany
//	@JoinTable(
//		name="BOOK_AUTHOR"
//		, joinColumns={
//			@JoinColumn(name="isbn")
//			}
//		, inverseJoinColumns={
//			@JoinColumn(name="author_id")
//			}
//		)
	private List<Author> authors;

	//bi-directional many-to-many association to Account
	@ManyToMany
//	@JoinTable(
//		name="CART"
//		, joinColumns={
//			@JoinColumn(name="isbn")
//			}
//		, inverseJoinColumns={
//			@JoinColumn(name="email")
//			}
//		)
	private List<Account> accounts;

	//bi-directional many-to-one association to OrderDetail
	@OneToMany(mappedBy="book")
	private List<OrderDetail> orderDetails;

	public Book() {
	}
	
	

	public Book(String isbn, String description, byte earlyRelease, Date finalReleaseDate, String formats, int pages,
			float price, String title, Category category, Publisher publisher, List<Author> authors,
			List<Account> accounts, List<OrderDetail> orderDetails) {
		super();
		this.isbn = isbn;
		this.description = description;
		this.earlyRelease = earlyRelease;
		this.finalReleaseDate = finalReleaseDate;
		this.formats = formats;
		this.pages = pages;
		this.price = price;
		this.title = title;
		this.category = category;
		this.publisher = publisher;
		this.authors = authors;
		this.accounts = accounts;
		this.orderDetails = orderDetails;
	}



	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte getEarlyRelease() {
		return this.earlyRelease;
	}

	public void setEarlyRelease(byte earlyRelease) {
		this.earlyRelease = earlyRelease;
	}

	public Date getFinalReleaseDate() {
		return this.finalReleaseDate;
	}

	public void setFinalReleaseDate(Date finalReleaseDate) {
		this.finalReleaseDate = finalReleaseDate;
	}

	public String getFormats() {
		return this.formats;
	}

	public void setFormats(String formats) {
		this.formats = formats;
	}

	public int getPages() {
		return this.pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Publisher getPublisher() {
		return this.publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public List<Author> getAuthors() {
		return this.authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public List<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public OrderDetail addOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().add(orderDetail);
		orderDetail.setBook(this);

		return orderDetail;
	}

	public OrderDetail removeOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().remove(orderDetail);
		orderDetail.setBook(null);

		return orderDetail;
	}

}