package jp.co.comnic.javalesson.evian.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import jp.co.comnic.javalesson.evian.entity.Book;

public class BookDao extends BaseDao{
	public BookDao() throws DaoException {}
	private CriteriaQuery<Book> query = builder.createQuery(Book.class);
	private Root<Book> root = query.from(Book.class);
	
	public List<Book> findAll() {
		return super.findAll(query, root);
	}
	
	public Book findById(String isbn) {
		return super.findByEmail(Book.class, isbn);
	}
	
	public Book loginAuthenticate(String email, String password)  {

		Book Book = null;
		
		try {
			// Criteria APIを使用して以下SQLを生成する
			// SELECT * FROM Book WHERE email = [email] AND password = [password]
			query.select(root)
				 .where(builder.equal(root.get("email"), email), 
						builder.equal(root.get("password"), password));
			
			// SQLを実行して結果を単一のエンティティ・オブジェクトとして取得
			Book = em.createQuery(query).getSingleResult();
			
		} catch (NoResultException e) {
			// getSingleResultメソッドは結果がなかった場合にNoResultExceptionをthrow
			// するため、この例外処理は不要
		}
		
		return Book;
	}
}
