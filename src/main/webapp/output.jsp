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
    <p>Name: ${not empty requestScope.name ? requestScope.name : "Name not provided"}</p>
    <p>Email: ${not empty requestScope.email ? requestScope.email : "Email not provided"}</p>
    <p>Country: ${not empty requestScope.country ? requestScope.country : "Country not provided"}</p>
    <p>${not empty requestScope.message ? requestScope.message : ""}</p>
</body>
</html>
