package jp.co.comnic.javalesson.evian.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * <p>DAOクラスの共通となる基底クラス。</p>
 * 
 * @author M.Yoneyama
 * @version 2.0
 */
public class BaseDao {
	
	// EntityManagerはスレッド・セーフではないため、サーブレットで利用する場合、本来はインスタンス変数として
	// 用いるべきではない (EntityManagerFactoryはスレッドセーフであり共有可能)
	protected EntityManager em = Persistence.createEntityManagerFactory("evian").createEntityManager();
	protected EntityTransaction tx = em.getTransaction();
	protected CriteriaBuilder builder = em.getCriteriaBuilder();
	
	/**
	 * <p>全件検索</p>
	 * 
	 * @param query 
	 * @param root
	 * @return 検索結果のエンティティ・オブジェクトが格納されたリスト
	 */
	protected <T> List<T> findAll(CriteriaQuery<T> query, Root<T> root) {
		return em.createQuery(query.select(root)).getResultList();
	}
	
	/**
	 * <p>主キー検索</p>
	 * 
	 * @param entityClass 検索対象のテーブルに対応するエンティティ・クラス
	 * @param id 検索に用いる主キー
	 * @return 検索結果のエンティティ・オブジェクト
	 * @throws DaoException
	 */
	public <T> T findById(Class<T> entityClass, Serializable id) {
		return em.find(entityClass, id);
	}
	
	
	public <T> T findByEmail(Class<T> entityClass, Serializable email) {
		return em.find(entityClass, email);
	}
		
	/**
	 * <p>新規レコードの挿入</p>
	 * 
	 * @param entity
	 * @throws DaoException
	 */
	public void insert(Object entity) throws DaoException {

		try {
			tx.begin();
			em.persist(entity);
			tx.commit();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	/**
	 * <p>既存レコードの削除</p>
	 * 
	 * @param entityClass 削除するレコードに対応するエンティティ・クラス
	 * @param id 削除するレコードのID
	 * @throws DaoException
	 */
	public <T> void remove(Class<T> entityClass, Serializable id) throws DaoException {
		// エンティティ・オブジェクトを取得して削除
		remove(em.find(entityClass, id));
	}
	
	/**
	 * <p>既存レコードの削除</p>
	 * 
	 * @param entity 削除するエンティティ・オブジェクト
	 * @throws DaoException
	 */
	public void remove(Object entity) throws DaoException {
		
		try {
			tx.begin();
			em.remove(entity);
			tx.commit();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	/**
	 * <p>既存レコードの更新</p>
	 * 
	 * @param entity 更新するEntityオブジェクト
	 * @throws DaoException
	 */
	public void update(Object entity) throws DaoException {
		try {
			tx.begin();
			// JPAでは更新専用のメソッドは用意されておらず、EntityManagerによって管理対象と
			// なっているエンティティ・オブジェクトはsetterメソッドによって値を変更すれば、自動的に
			// データベースと同期更新される仕組みになっているが、管理対象となっていないエンティティ
			// オブジェクトはmergeメソッドを使用して管理対象とする必要がある
			em.merge(entity);
			tx.commit();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
}