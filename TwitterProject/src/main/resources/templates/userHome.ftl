<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="/twitter/css/userHome.css" rel="stylesheet">

	<script type="text/javascript">
		var name = '${name!"N/A"}' ;
		function setName() {
			document.getElementById("writer").innerText = name ;
		}

		function editPage(){
			window.open("http://localhost:8080/twitter/userEditPage", "_self");
		}
	</script>

</head>
<body class="title" onload="setName()">

<table class = "header">
	<th>${okMessage!""}</th>
	<tr>
		<th>Hello ${name!"N/A"}!</th>
		<th id="editDetails">
			<form action="http://google.com">
				<input id="search" type="text" name="account" placeholder="Search accounts "/>
				<input id="button" type="button" onclick="editPage()" value="Account Settings"/>
			</form>
		</th>
	</tr>
</table>


<div class = "message">
	<form action="http://localhost:8080/twitter/save-message" method="post">
		<textarea id = "myTextarea" rows = "100" name="text" placeholder="What are you thinking about?"></textarea>
		<input type="hidden" name="username" value="${name!"N/A"}">
		<input id="post" type="submit" value="Post">
	</form>
</div>

<#list messages as message>
	<div class = "messageList">
		<div>${message.username!"N/A"}</div>
		<div>${message.posting!"N/A"}</div>
		<div>${message.text!"You haven't posted anything"}</div>
	</div>
</#list>

</body>
</html>