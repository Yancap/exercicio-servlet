<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Exemplo de Lista com jstl</title>
</head>
<body>
    <h1>Lista de items</h1>

    <ul>
        <c:forEach var="item" items="${items}">
            <li>
                ${item}
            </li>
        </c:forEach>
    </ul>
</body>
</html>