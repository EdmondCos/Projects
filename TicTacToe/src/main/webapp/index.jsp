<%@ page import="com.sda.TicTacToe, com.sda.Table"%>

<html>
<head>
</head>

<body>

<form action="TicTacToe">
Current Player:
<select name="player">
    <option value="x">Player X</option>
    <option value="0">Player 0</option>
</select>

<br>

<input type = "submit" name = "L0C0" value= <%=Table.getL0C0()%> />
<input type = "submit" name = "L0C1" value= <%=Table.getL0C1()%> />
<input type = "submit" name = "L0C2" value= <%=Table.getL0C2()%> />
<br>
<input type = "submit" name = "L1C0" value= <%=Table.getL1C0()%> />
<input type = "submit" name = "L1C1" value= <%=Table.getL1C1()%> />
<input type = "submit" name = "L1C2" value= <%=Table.getL1C2()%> />
<br>
<input type = "submit" name = "L2C0" value= <%=Table.getL2C0()%> />
<input type = "submit" name = "L2C1" value= <%=Table.getL2C1()%> />
<input type = "submit" name = "L2C2" value= <%=Table.getL2C2()%> />

</form>

</body>
</html>