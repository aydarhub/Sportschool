<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Тренеры</h1>
    <table border="1px">
        <tr>
            <th>id</th>
            <th>Имя</th>
            <th>День рождения</th>
            <th>Вид спорта</th>
            <th>Адрес</th>
            <th>Телефон</th>
            <th>Спортивный разряд</th>
        </tr>

        <c:forEach items="${requestScope.trainers}" var="trainer">
            <tr>
                <td>${trainer.id}</td>
                <td>${trainer.name}</td>
                <td>${trainer.birthday}</td>
                <td>${trainer.kindOfSport.name}</td>
                <td>${trainer.address}</td>
                <td>${trainer.phone}</td>
                <td>${trainer.sportsCategory.name}</td>
            </tr>
        </c:forEach>

    </table>

    <h2>Добавить тренера</h2>
    <form action="${pageContext.request.contextPath}/addTrainer" method="post">
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
                <td><label for="kindOfSport">Вид спорта:</label></td>
                <td>
                    <select id="kindOfSport" name="kindOfSportId" required>
                        <c:forEach items="${requestScope.kindOfSports}" var="kindOfSport">
                            <option value="${kindOfSport.id}">${kindOfSport.name}</option>
                        </c:forEach>
                    </select> *
                </td>
            </tr>
            <tr>
                <td><label for="address">Адрес:</label></td>
                <td><input id="address" name="address" type="text" required> *</td>
            </tr>
            <tr>
                <td><label for="phone">Телефон:</label></td>
                <td><input id="phone" name="phone" type="tel" pattern="^((8|\+7)[\- ]?)?(\(?\d{3}\)?[\- ]?)?[\d\- ]{7,10}$" required> *</td>
            </tr>
            <tr>
                <td><label for="sportsCategory">Спортивный разряд:</label></td>
                <td>
                    <select id="sportsCategory" name="sportsCategoryId" required>
                        <c:forEach items="${requestScope.sportsCategories}" var="category">
                            <option value="${category.id}">${category.name}</option>
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
