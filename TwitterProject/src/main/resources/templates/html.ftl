<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <link href="/twitter/css/main.css" rel="stylesheet">
   <script src="/twitter/js/main.js"></script>
</head>
<body class="title">
    <table>
        <tr>
            <th>Username</th>
            <th>Password</th>
            <th>Email</th>
        </tr>
        <#list accounts as account>
                <tr>
                    <td>${account.username}</td>
                    <td>${account.password}</td>
                    <td>${account.email}</td>

                    <td>
<form action="/twitter/mvc/delete" method="get">
    <input type="hidden" name="username" value="${account.username}"/>
    <input type="submit" value="X"/>
</form>
                    </td>

                </tr>
        </#list>
    </table>

   <h2 class = "hello">Hello Users</h2>
   <button onclick="myFunction()">Buton</button>
</body>
</html>