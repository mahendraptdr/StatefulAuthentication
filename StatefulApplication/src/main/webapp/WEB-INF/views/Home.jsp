<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import = "com.StatefulApplication.StatefulApplication.model.RegistrationUser"%>
	<%@page import = "com.StatefulApplication.StatefulApplication.service.Registrationservice"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<form action = "/logout" method = "get">
    <h1>${username} welcome </h1>
    <p id="welcomeMessage"></p>
   <button class = "btn"> Logout </button>
    </form>
</body>
</html>