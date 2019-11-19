<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/twitter/css/searchPage.css" rel="stylesheet">
</head>
<body>

<table class="results">
    <h2>We have found the users below!</h2>
    <br>
    <#list followers as follower>
        <tr>
    	    <td>${follower.name!"nume"}</td>
    	    <td>

<form action="http://localhost:8080/twitter/following" method="post">
    <input type="submit" name="symbol" value="${follower.symbol!"simbol"}"/>
    <input type="hidden" name="name" value="${follower.name}"/>
    <input type="hidden" name="username" value="${name}"/>
</form>
    	    </td>
    	</tr>
    </#list>

</table>

</body>
</html>