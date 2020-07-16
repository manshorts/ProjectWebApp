<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 7/14/2020
  Time: 12:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>PS1 Game Database</title>
</head>
<body>
<h2 style="text-align: center">Sample Playstation 1 Game Database</h2>
<p style="text-align: center">This is a sample database where a user might want to <br>
    find simple information regarding a Playstation 1 game.  Through searching via different <br>
    methods on this web application, a user will be able to discover a game's ID Code, Actual Name, <br>
    and the basic genre of the game.</p>

<center>
    <h3>
        <a href="index.jsp">Home</a>
        &nbsp;&nbsp;&nbsp;
        <a href="game-list.jsp">Show All Games</a>
        &nbsp;&nbsp;&nbsp;
        <a href="game-letter.jsp">Games by Letter</a>
        &nbsp;&nbsp;&nbsp;
        <a href="game-genre.jsp">Games by Genre</a>
    </h3>
</center>

</center>

<center>
    <form name="dropdownLetter" action="letter">
        <label><h4>Choose a letter to view the games that start with that letter:</h4></label><br>
        <select name="letterParam" id="letterParam">
            <option value="a">A</option>
            <option value="b">B</option>
            <option value="c">C</option>
            <option value="d">D</option>
            <option value="e">E</option>
            <option value="f">F</option>
            <option value="g">G</option>
            <option value="h">H</option>
            <option value="i">I</option>
            <option value="j">J</option>
            <option value="k">K</option>
            <option value="l">L</option>
            <option value="m">M</option>
            <option value="n">N</option>
            <option value="o">O</option>
            <option value="p">P</option>
            <option value="q">Q</option>
            <option value="r">R</option>
            <option value="s">S</option>
            <option value="t">T</option>
            <option value="u">U</option>
            <option value="v">V</option>
            <option value="w">W</option>
            <option value="x">X</option>
            <option value="y">Y</option>
            <option value="z">Z</option>
        </select>
        <input type="submit">
    </form>
</center>

<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>Game ID</th>
            <th>Game Name</th>
            <th>Genre</th>
        </tr>
        <c:forEach var="game" items="${listByLetter}">
            <tr>
                <td><c:out value="${game.game_id}" /> </td>
                <td><c:out value="${game.game_name}"/> </td>
                <td><c:out value="${game.game_genre}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>

