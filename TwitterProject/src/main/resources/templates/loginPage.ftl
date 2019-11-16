<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/twitter/css/login.css" rel="stylesheet">

	<script type="text/javascript">
        function register(){
            window.open("http://localhost:8080/twitter/register", "_self");
        }
    </script>

</head>
<body>

    <div class="login">
        <h2>Log In</h2>
	    <div>${wrongCredentials!""}</div>
        <form action="http://localhost:8080/twitter/login" method="post">
            <input type="email" placeholder="Email" name="email" required>
            <input type="password" placeholder="Password" name = "password" required>
            <input type="submit" value="Log In">
			<input type="button" onclick="register()" value="Register" />
        </form>
    </div>
</body>
</html>