<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h1>Login</h1>
    <form id="loginForm" class="form" action="/veryfication" method = "post">
        <label>Enter Email:</label>
        <input type="email" name="gmail" id="username" required/><br>
        <label>Enter password:</label>
        <input type="password" name="password1" id="password" required/><br>

        <button id = login-btn type="submit" href="home">Login</button>
</form>
<form action = "/registration" method = "get">
               <button typy = "submit"> sign up </button>
               </form>
    <p id="message"></p>
</body>
</html>