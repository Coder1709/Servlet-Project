<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Creation Result</title>
</head>
<body>
    <h2>User Information</h2>
    <p>Name: ${requestScope.name}</p>
    <p>Email: ${requestScope.email}</p>
    <p>Country: ${requestScope.country}</p>
    <p>${requestScope.message}</p>
</body>
</html>
