package jp.co.comnic.javalesson.evian.dao;

import javax.persistence.criteria.CriteriaQuery;

import jp.co.comnic.javalesson.evian.entity.Book;

public class CartDao extends BaseDao{
	
	public CartDao() throws DaoException{}
	
	private CriteriaQuery<Book> query = builder.createQuery(Book.class);
	

}
