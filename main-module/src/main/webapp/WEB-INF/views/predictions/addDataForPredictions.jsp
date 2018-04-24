<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=utf-8" %>
<html>
    <head>
        <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
    </head>
    <body>
        <h1>Введите необходимые данные</h1>
        <c:if test="${not empty error}">
            <span class="error">${answer}</span><br />
        </c:if>
        <c:if test="${not empty errorMessage}">
            <span class="error">${errorMessage}</span><br />
        </c:if>
        <form:form method="post" action="#" modelAttribute="inputDataForTaskFromForm">
        	<table>
            	<tr>
            		<td><form:label path="sessionId">session_id</form:label></td>
            		<td><form:input path="sessionId"/></td>
            		<td><span class="error"><form:errors path="sessionId"/></span></td>
            	</tr>
            	<tr>
            		<td><form:label path="roundId">round_id</form:label></td>
            		<td><form:input path="roundId"/></td>
            		<td><span class="error"><form:errors path="roundId"/></span></td>
            	</tr>
            	<tr>
            		<td><form:label path="competitionId">competition_id</form:label></td>
            		<td><form:input path="competitionId"/></td>
            		<td><span class="error"><form:errors path="competitionId"/></span></td>
            	</tr>
            	<tr>
                    <td><form:label path="eventName">Событие (например, &quot;Англия, Премьер-лига&quot;</form:label></td>
                    <td><form:input path="eventName"/></td>
                    <td><span class="error"><form:errors path="eventName"/></span></td>
                </tr>
            	<tr>
            		<td><input type="submit" value="Добавить"/></td>
            	</tr>
            </table>
        </form:form>

    </body>
</html>