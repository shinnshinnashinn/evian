package jp.co.comnic.javalesson.evian.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.comnic.javalesson.evian.controller.ControllerUtils;
import jp.co.comnic.javalesson.evian.dao.BookDao;
import jp.co.comnic.javalesson.evian.dao.DaoException;

public class BookAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		String servletPath = request.getServletPath();
		String word = request.getParameter("word");
		
//		String redirectPath = "./"; // 正常処理のリダイレクト先（一覧画面）
		String forwardPath = "searchresult"; // 例外発生時のフォワード先（元の登録画面）
		
		try {
			
			request.setAttribute("bookList", new BookDao().findByTitle(word));
			
//			response.sendRedirect(forwardPath); 
			response.sendRedirect("/" + request.getServletContext().getServletContextName() + "/searchResult.jsp");
			forwardPath = null;
		} catch (DaoException e) {
			request.setAttribute("error", "[ERROR]: " + 
			                      ControllerUtils.getShortMessage(e));
		} catch (Exception e) {
			throw new ServletException(e);
		} 
		
		return forwardPath;
	}

}
