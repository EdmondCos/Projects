<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/twitter/css/login.css" rel="stylesheet">
	<script src="/twitter/js/main.js"></script>
</head>
<body>
    <div class="login">
        <h2>Log In</h2>
        <form action="http://localhost:8080/twitter/login">
            <input type="email" placeholder="Email" name="email" required>
            <input type="password" placeholder="Password" name = "password" required>
            <input type="submit" value="Log In">
			<input type="button" onclick="register()" value="Register" />
        </form>
    </div>
</body>
</html>