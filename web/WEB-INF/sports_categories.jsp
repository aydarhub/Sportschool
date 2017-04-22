<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sport's categories</title>
</head>
<body>
<h1>Спортивные разряды</h1>
<table border="1px">
    <tr>
        <th>id</th>
        <th>Разряд</th>
    </tr>
    <c:forEach items="${requestScope.sportsCategories}" var="sportsCategory">
        <tr>
            <td>${sportsCategory.id}</td>
            <td>${sportsCategory.name}</td>
            <td><a href="/delete?table=SportsCategory&id=${sportsCategory.id}">Удалить</a></td>
        </tr>
    </c:forEach>

</table>

<h2>Добавить разряд</h2>
<form action="${pageContext.request.contextPath}/addSportsCategory" method="post">
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
