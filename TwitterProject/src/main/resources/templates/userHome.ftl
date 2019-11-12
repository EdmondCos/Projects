<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <link href="/twitter/css/userHome.css" rel="stylesheet">
</head>
<body class="title">

	<div class = "message"
		<h2>Hello User</h2>
		<form action="http://localhost:8080/twitter/save-message" method="post">
            <textarea id = "myTextarea" rows = "100" name="text" placeholder="What are you thinking about?"></textarea>
            <input type="submit" value="Post">
        </form>
	</div>

</body>
</html>