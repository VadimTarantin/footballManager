<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
    </head>
    <body>
        <h1>Hello from main page</h1>
        <a href="./rest">Receive by REST</a>

        <table>
            <c:forEach var="wideTableTeam" items="${wideTableTeams}" >
                <tr><td><c:out value="${wideTableTeam}"></td></tr>
            </c:forEach>
        </table>
    </body>
</html>