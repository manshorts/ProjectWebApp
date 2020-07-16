<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 7/1/2020
  Time: 11:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- This library is being used to create the foreach statements in my tables--%>
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
    <!-- dropdown menu where values will be passed to the servlet -->
    <form name="dropdownGenre" action="genre">
        <label><h4>Pick a Genre to view all of the games in that genre:</h4></label><br>
        <!-- the servlet will look for the selected value when the submit button is pressed. -->
        <select name="genreParam" id="genreParam">
            <option value="action">Action</option>
            <option value="adventure">Adventure</option>
            <option value="fighting">Fighting</option>
            <option value="first person shooter">First Person Shooter</option>
            <option value="puzzle">Puzzle</option>
            <option value="racing">Racing</option>
            <option value="role playing game">Role Playing Game</option>
            <option value="simulation">Simulation</option>
            <option value="sports">Sports</option>
            <option value="strategy">Strategy</option>
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
        <%-- The forEach statement will create a row for each object in the collection --%>
        <c:forEach var="game" items="${listByGenre}">
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
