<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=utf-8" %>
<html>
    <head>
    </head>
    <body>
        <h1>Введите необходимые данные</h1>
        <br />
        ${answer}
        <form:form method="post" action="#" modelAttribute="inputDataForTaskFromForm">
        	<table>
            	<tr>
            		<td><form:label path="sessionId">session_id</form:label></td>
            		<td><form:input path="sessionId"/></td>
            	</tr>
            	<tr>
            		<td><form:label path="roundId">round_id</form:label></td>
            		<td><form:input path="roundId"/></td>
            	</tr>
            	<tr>
            		<td><form:label path="competitionId">competition_id</form:label></td>
            		<td><form:input path="competitionId"/></td>
            	</tr>
            	<tr>
                    <td><form:label path="eventName">Событие (например, &quot;Англия, Премьер-лига&quot;</form:label></td>
                    <td><form:input path="eventName"/></td>
                </tr>
            	<tr>
            		<td><input type="submit" value="Добавить"/></td>
            	</tr>
            </table>
        </form:form>

    </body>
</html>