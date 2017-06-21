<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="ctxPath" value="/${pageContext.servletContext.servletContextName}" scope="application" />

<!DOCTYPE html>
<html>
	
	<h3>Login Management System</h3>
	
	<body>
		<div>
			<h1>Login</h1>
			<form action="login.do" method="post">
				<fieldset>
					<div>
						<label for="email">E-Mail </label>
						<input name="email" placeholder="Your email" autofocus>
					</div>
					<div>
						<label for="password">Password </label>
						<input type="password" name="password" placeholder="Your password">
					</div>
					<input type="submit" value="Login">
				</fieldset>
			</form>
			
		</div>
		
	</body>
	
</html>