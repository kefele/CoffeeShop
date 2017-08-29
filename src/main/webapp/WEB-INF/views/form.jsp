
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/Resources/style.css">
    <style>

        body{
            background-image: url("/Resources/images/coffeeBackground1.jpg");
        }
    </style>

    <title>User Form</title>
</head>
<body>
${inst}<br>
<br>
<br>
<form action="addUser" method="post">
    First Name: <input type="text" name="fName"><br>
    Last Name: <input type="text" name="lName"><br>
    Email: <input type="text" name="email"><br>
    Phone: <input type="text" name="phone"><br>
    Password: <input type="password" name="password"><br>
    Re-Enter Password: <input type = "password" name= "password2" ><br>
    <input type="radio" name="preference" value="Regular" checked> Regular<br>
    <input type="radio" name="preference" value="De-Cafe">De-Cafe<br>
    <input type="submit" name="submit" value="submit"><br>
</form>
</body>
</html>
