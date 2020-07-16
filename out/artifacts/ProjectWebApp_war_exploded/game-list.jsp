<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 7/13/2020
  Time: 9:51 PM
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

    <center>
        <h4>
            <a href="all">Show All Games</a>
        </h4>
    </center>

    <div align="center">
        <table border="1" cellpadding="5">
            <tr>
                <th>Game ID</th>
                <th>Game Name</th>
                <th>Genre</th>
            </tr>
            <c:forEach var="game" items="${listGame}">
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
