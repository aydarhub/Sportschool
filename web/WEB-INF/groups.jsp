<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Группы</h1>
    <table border="1px">
        <tr>
            <th>id</th>
            <th>Название группы</th>
            <th>Тренер</th>
        </tr>

        <c:forEach items="${requestScope.groups}" var="group">
            <tr>
                <td>${group.id}</td>
                <td>${group.name}</td>
                <td>${group.trainer.name}</td>
                <td><a href="/delete?table=Group&id=${group.id}">Удалить</a></td>
            </tr>
        </c:forEach>

    </table>

    <h2>Добавить группу</h2>
    <form action="${pageContext.request.contextPath}/addGroup" method="post">
        <table>
            <tr>
                <td><label for="name">Имя:</label></td>
                <td><input id="name" name="name" type="text" required> *</td>
            </tr>
            <tr>
                <td><label for="trainer">Тренер:</label></td>
                <td>
                    <select id="trainer" name="trainerId" required>
                        <c:forEach items="${requestScope.trainers}" var="trainer">
                            <option value="${trainer.id}">${trainer.name}</option>
                        </c:forEach>
                    </select> *
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit"></td>
            </tr>
        </table>
    </form>
</body>
</html>
