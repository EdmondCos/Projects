<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/twitter/css/userHome.css" rel="stylesheet">

  	<script type="text/javascript">
  	    var name = '${name!"Admin"}' ;

        function setName() {
            document.getElementById("userId").innerText = "Hello " + name + "!" ;
            document.getElementById("writer").innerText = name ;
        }

    </script>

</head>
<body class="title" onload="setName()">

	<div class = "message">
		<div>${okMessage!""}</div>
	    <div id="userId">Hello ${name!"User"}!</div>
		<form action="http://localhost:8080/twitter/save-message" method="post">
            <textarea id = "myTextarea" rows = "100" name="text" placeholder="What are you thinking about?"></textarea>
            <input type="hidden" name="username" value='${name!"admin"}'>
            <input type="submit" value="Post">
        </form>
	</div>

    <#list messages as message>
	<div class = "messageList">
	    <div id=${message.username!"Admin"}></div>
	    <div>${message.posting!"N/A"}</div>
	    <div>${message.text!"You haven't posted anything"}</div>
	</div>
	</#list>

</body>
</html>