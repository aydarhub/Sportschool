
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1px">
        <tr>
            <th>Имя</th>
            <th>День рождения</th>
            <th>Группа</th>
            <th>Телефон</th>
            <th>Адрес</th>
            <th>Спортивный разряд</th>
            <th>Награды</th>
        </tr>
        <tr>
            <td>Макс</td>
            <td>13.02.2002</td>
            <td>Бокс-11</td>
            <td>+79991234567</td>
            <td>г. Чайка, ул. Чайковского, д. 32, кв. 2946</td>
            <td>Мастер спорта</td>
            <td>Кубок Нефтяника, Кубок Татнефти, Диплом за 1-ое место в республиканском соревновании 2015, Диплом за 1-ое место на всероссийском соревновании</td>
        </tr>
        id = <%=(request.getAttribute("id"))%>

    </table>
</body>
</html>
