<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <link href="/twitter/css/register.css" rel="stylesheet">
</head>

<body>
	<div class = "register">
		<div>${dataAlreadyRegistered!""}</div>
		<form action="http://localhost:8080/twitter/register-account" method="post">
		    <input type="text" placeholder="Username" name="username" required>
		    <input type="email" placeholder="Email" name="email" required>
            <input type="password" placeholder="Password" name="password" required>
            <input type="submit" value="Register">
		</form>
	</div>
</body>
</html>