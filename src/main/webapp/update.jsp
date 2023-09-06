<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/6/2023
  Time: 11:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/student?action=update" method="post">
  <p>Name</p>
  <input type="text" name="name">
  <p>Dob</p>
  <input type="text" name="dob">
  <p>Email</p>
  <input type="text" name="email">
  <p>Address</p>
  <input type="text" name="address">
  <p>Phone</p>
  <input type="text" name="phone">
  <p>Classroom</p>
  <input type="text" name="idClass">
</form>
</body>
</html>
