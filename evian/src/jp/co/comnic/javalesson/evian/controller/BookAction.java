package jp.co.comnic.javalesson.evian.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.comnic.javalesson.evian.controller.ControllerUtils;
import jp.co.comnic.javalesson.evian.dao.BaseDao;
import jp.co.comnic.javalesson.evian.dao.DaoException;

public class BookAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String servletPath = request.getServletPath();
		
		String redirectPath = "./"; // 正常処理のリダイレクト先（一覧画面）
		String forwardPath = "new"; // 例外発生時のフォワード先（元の登録画面）
		
		try {
			
			// リクエスト・パス文字列から空のエンティティ・オブジェクトを生成
			Object entity = Class.forName(ControllerUtils.getFullyQualifiedClassName(servletPath)).newInstance();
			
			// リクエスト・パラメータの値を使用してエンティティ・オブジェクトのフィールド値を設定
			ControllerUtils.populateEntity(request, entity);
			
			// エンティティ・オブジェクトをDAOに渡すことで新規レコードをDBに挿入
			new BaseDao().insert(entity);
			
			forwardPath = null;
			response.sendRedirect(redirectPath); 
			
		} catch (DaoException e) {
			request.setAttribute("error", "[ERROR]: " + 
			                      ControllerUtils.getShortMessage(e));
		} catch (Exception e) {
			throw new ServletException(e);
		} 
		
		return forwardPath;
	}

}
