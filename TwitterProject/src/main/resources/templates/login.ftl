<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
      <script src="/twitter/js/main.js"></script>
</head>
<body>

<table>
    <form action="http://localhost:8080/twitter/login">
        <tr>
            <td>Email</td>
            <td><input type="text" name="email"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td><button type="submit"/>Login</td>
        </tr>
    </form>
        <tr>
            <td><button onclick="register()">Register</button></td>
        </tr>
</table>

</body>
</html>