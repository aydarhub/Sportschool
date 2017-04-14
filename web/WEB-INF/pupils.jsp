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
        <c:forEach items="${requestScope.pupils}" var="pupil">
            <tr>
                <td>${pupil.id}</td>
                <td>${pupil.name}</td>
                <td>${pupil.birthday}</td>
                <td>${pupil.group.name}</td>
                <td>${pupil.phone}</td>
                <td>${pupil.address}</td>
                <td>${pupil.sportsCategory.name}</td>
                <td>${pupil.rewards}</td>
            </tr>
        </c:forEach>

    </table>
    <h2>Добавить ученика</h2>
    <form action="${pageContext.request.contextPath}/addPupil" method="post">
        <table>
            <tr>
                <td><label for="name">Имя:</label></td>
                <td><input id="name" name="name" type="text" required> *</td>
            </tr>
            <tr>
                <td><label for="birthday">День рождения:</label></td>
                <td><input id="birthday" name="birthday" type="text" required> *</td>
            </tr>
            <tr>
                <td><label for="group">Группа:</label></td>
                <td>
                    <select id="group" name="groupId">
                        <c:forEach items="${requestScope.groups}" var="group">
                            <option value="${group.id}">${group.name}</option>
                        </c:forEach>
                    </select> *
                </td>
            </tr>
            <tr>
                <td><label for="phone">Телефон:</label></td>
                <td><input id="phone" name="phone" type="tel" pattern="^((8|\+7)[\- ]?)?(\(?\d{3}\)?[\- ]?)?[\d\- ]{7,10}$"></td>
            </tr>
            <tr>
                <td><label for="address">Адрес:</label></td>
                <td><input id="address" name="address" type="text"></td>
            </tr>
            <tr>
                <td><label for="sportsCategory">Спортивная категория:</label></td>
                <td>
                    <select id="sportsCategory" name="sportsCategoryId">
                    <c:forEach items="${requestScope.sportsCategories}" var="category">
                        <option value="${category.id}">${category.name}</option>
                    </c:forEach>
                    </select>
                </td>
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
