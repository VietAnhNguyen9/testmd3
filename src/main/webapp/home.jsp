<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/6/2023
  Time: 8:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="create.jsp"><button>Create Student</button></a>
<h1>List Student</h1>
<table>
    <tr>
    <th>ID</th>
    <th>Name</th>
    <th>DOB</th>
    <th>Email</th>
    <th>Address</th>
    <th>Phone</th>
    <th>Class</th>
    </tr>
    <c:forEach items="${listStudent}" var="l">
    <tr>
        <td>${l.getIdStudent()}</td>
        <td>${l.getName()}</td>
        <td>${l.getDob()}</td>
        <td>${l.getEmail()}</td>
        <td>${l.getAddress()}</td>
        <td>${l.getPhone()}</td>
        <td>${l.getClassroom().getNameClass()}</td>
        <td><a href="student?action=update&&id=${l.getIdStudent()}">Update</a></td>
        <td><a href="student?action=delete&&id=${l.getIdStudent()}">Delete</a></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
