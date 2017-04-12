<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1px">
        <tr>
            <th>id</th>
            <th>Имя</th>
            <th>День рождения</th>
            <th>Группа</th>
            <th>Телефон</th>
            <th>Адрес</th>
            <th>Спортивный разряд</th>
            <th>Награды</th>
        </tr>
        <c:forEach items="${requestScope.pupils}" var="pupils">
            <tr>
                <td>${pupils.id}</td>
                <td>${pupils.name}</td>
                <td>${pupils.birthday}</td>
                <td>${pupils.group.name}</td>
                <td>${pupils.phone}</td>
                <td>${pupils.address}</td>
                <td>${pupils.sportsCategory.categoryName}</td>
                <td>${pupils.rewards}</td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>
