<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Ученики</h1>
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
    <h2>Добавить ученика</h2>
    <form action="/add" method="post">
        <table>
            <tr>
                <td><label for="name">Имя:</label></td>
                <td><input id="name" name="name" type="text"></td>
            </tr>
            <tr>
                <td><label for="birthday">День рождения:</label></td>
                <td><input id="birthday" name="birthday" type="text"></td>
            </tr>
            <tr>
                <td><label for="group">Группа:</label></td>
                <td><input id="group" name="groupId" type="text"></td>
            </tr>
            <tr>
                <td><label for="phone">Телефон:</label></td>
                <td><input id="phone" name="phone" type="text"></td>
            </tr>
            <tr>
                <td><label for="address">Адрес:</label></td>
                <td><input id="address" name="address" type="text"></td>
            </tr>
            <tr>
                <td><label for="sportsCategory">Спортивная категория:</label></td>
                <td><input id="sportsCategory" name="sportsCategoryId" type="text"></td>
            </tr>
            <tr>
                <td><label for="rewards">Награды:</label></td>
                <td><input id="rewards" name="rewards" type="text"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit"></td>
            </tr>
        </table>
    </form>
</body>
</html>
