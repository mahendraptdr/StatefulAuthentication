<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div id = registrationbox>
    <h1>Registration</h1>
    <form id="registrationForm" class="form" action = "/useregister" method = "post">
        <label>Enter username:</label>
        <input type="text" name="username" id="username" required placeholder = "enter username here "/><br>

        <label>Enter emailid:</label>
        <input type="email" name="gmail" id="emailid" required placeholder = "enter email here"/><br>

        <label>Enter password:</label>
        <input type="password" name="password" id="password" required placeholder = "enter password here"/><br>

        <button type="submit">Sign Up</button>
    </form>
    <form action = "/login" method = "get">
            <button typy = "submit"  style=" width:75px; margin-left:35% ;margin-top:10%"> login </button>
            </form>
</div>
<div>
    <p id="message"></p>
</div>
</body>
</html>