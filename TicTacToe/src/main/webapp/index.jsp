<%@ page import="com.sda.TicTacToe, com.sda.Board"%>

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

<% out.println(TicTacToe.info); %>

<br>

<input type = "submit" name = "L0C0" value= <%=Board.L0C0%> >
<input type = "submit" name = "L0C1" value= <%=Board.L0C1%> >
<input type = "submit" name = "L0C2" value= <%=Board.L0C2%> >
<br>
<input type = "submit" name = "L1C0" value= <%=Board.L1C0%> >
<input type = "submit" name = "L1C1" value= <%=Board.L1C1%> >
<input type = "submit" name = "L1C2" value= <%=Board.L1C2%> >
<br>
<input type = "submit" name = "L2C0" value= <%=Board.L2C0%> >
<input type = "submit" name = "L2C1" value= <%=Board.L2C1%> >
<input type = "submit" name = "L2C2" value= <%=Board.L2C2%> >
</form>

<form action="Reset">
<input type = "submit" name = "reset" value="Restart Game">
</form>

</body>
</html>