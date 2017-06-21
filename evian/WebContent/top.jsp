<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
     <head>
          <meta charset=UTF-8>
          <title>トップ画面</title>
     </head>
     <body>
		<h1>トップ画面</h1>
		    <form action="/ControllerServlet" method="post">
     		<input name="word">
     		<input type="submit" value="Serch">
     	</form>
     </body>
</html>