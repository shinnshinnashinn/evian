<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8>
        <title>Search</title>
    </head>
    <body>
        <h1>Search</h1>
        
        <table>
            <tr>
                <th>isbn</th>
                <th>title</th>
                <th>price</th>
                <th>final_release_date</th>
                <th>pages</th>
                <th>description</th>
                <th>formats</th>
                <th>category_id</th>
                <th>publisher_id</th>
                <th>early_release</th>
            </tr>
            <c:forEach var="book" items="${bookList}">
                <tr>
                    <td>${book.isbn}</td>
                    <td>${book.title}</td>
                    <td>${book.final_release_date}</td>
                    <td>${book.pages}</td>
                    <td>${book.description}</td>
                    <td>${book.formats}</td>
                    <td>${book.category_id}</td>
                    <td>${book.publisher_id}</td>
                    <td>${book.early_release}</td>
                </tr>
            </c:forEach>
        </table>
        
    </body>
</html>