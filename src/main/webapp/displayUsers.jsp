<title>All Users</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
    </tr>
    <c:forEach items="${users}" var="u">
        <tr>
            <td>${u.id }</td>
            <td>${u.firstName }</td>
            <td>${u.lastName }</td>
        </tr>
    </c:forEach>
</table>
