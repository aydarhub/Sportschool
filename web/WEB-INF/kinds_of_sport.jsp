<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>KindsOfSport</title>
</head>
<body>
<h1>Виды спорта</h1>
<table border="1px">
    <tr>
        <th>id</th>
        <th>Вид спорта</th>
    </tr>

    <c:forEach items="${requestScope.kindsOfSport}" var="kindOfSport">
        <tr>
            <td>${kindOfSport.id}</td>
            <td>${kindOfSport.name}</td>
            <td><a href="/delete?table=KindOfSport&id=${kindOfSport.id}">Удалить</a></td>
        </tr>
    </c:forEach>

</table>

<h2>Добавить вид спорта</h2>
<form action="${pageContext.request.contextPath}/addKindOfSport" method="post">
    <table>
        <tr>
            <td><label for="name">Название:</label></td>
            <td><input id="name" name="name" type="text" required> *</td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit"></td>
        </tr>
    </table>
</form>
</body>
</html>
