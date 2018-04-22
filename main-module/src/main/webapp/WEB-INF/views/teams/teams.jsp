<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<html>
    <head>
    </head>
    <body>
        <h1>Зарегистрированные команды</h1>
        <a href="./index">На главную</a>

        <table>
            <tr>
                <th>ID</th>
                <th>Команда</th>
            <c:forEach var="team" items="${teams}" >
                <tr>
                    <td>"${team.id}"</td>
                    <td>"${team.name}"</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>