package jp.co.comnic.javalesson.evian.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ORDER_DETAIL database table.
 * 
 */
@Entity
@Table(name="ORDER_DETAIL")
@NamedQuery(name="OrderDetail.findAll", query="SELECT o FROM OrderDetail o")
public class OrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderDetailPK id;

	@Column(name="sales_price")
	private float salesPrice;

	//bi-directional many-to-one association to Book
	@ManyToOne
	@JoinColumn(name="isbn")
	private Book book;

	//bi-directional many-to-one association to BookOrder
	@ManyToOne
	@JoinColumn(name="order_number")
	private BookOrder bookOrder;

	public OrderDetail() {
	}
	
	
	
	public OrderDetail(OrderDetailPK id, float salesPrice, Book book, BookOrder bookOrder) {
		super();
		this.id = id;
		this.salesPrice = salesPrice;
		this.book = book;
		this.bookOrder = bookOrder;
	}



	public OrderDetailPK getId() {
		return this.id;
	}

	public void setId(OrderDetailPK id) {
		this.id = id;
	}

	public float getSalesPrice() {
		return this.salesPrice;
	}

	public void setSalesPrice(float salesPrice) {
		this.salesPrice = salesPrice;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public BookOrder getBookOrder() {
		return this.bookOrder;
	}

	public void setBookOrder(BookOrder bookOrder) {
		this.bookOrder = bookOrder;
	}

}