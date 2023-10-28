<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
    <link rel="stylesheet" href="./styles.css" />
</head>
<body>
    <main>
        <section class="container">
            <div class="container-profile">
               <h1>Bem vindo <strong><c:out value='${items.get("name")}'/></strong></h1>
                <p><c:out value='${items.get("email")}'/></p>
            </div>
        </section>
    </main>
</body>

</html>