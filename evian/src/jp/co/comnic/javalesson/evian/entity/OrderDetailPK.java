package jp.co.comnic.javalesson.evian.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ORDER_DETAIL database table.
 * 
 */
@Embeddable
public class OrderDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="order_number", insertable=false, updatable=false)
	private int orderNumber;

	@Column(insertable=false, updatable=false)
	private String isbn;

	public OrderDetailPK() {
	}
	
	
	
	public OrderDetailPK(int orderNumber, String isbn) {
		super();
		this.orderNumber = orderNumber;
		this.isbn = isbn;
	}



	public int getOrderNumber() {
		return this.orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getIsbn() {
		return this.isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OrderDetailPK)) {
			return false;
		}
		OrderDetailPK castOther = (OrderDetailPK)other;
		return 
			(this.orderNumber == castOther.orderNumber)
			&& this.isbn.equals(castOther.isbn);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.orderNumber;
		hash = hash * prime + this.isbn.hashCode();
		
		return hash;
	}
}