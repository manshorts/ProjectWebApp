package projectwebapp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class GameServlet extends HttpServlet {

    private GameDAO gameDAO;

    public void init() {
        gameDAO = new GameDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // everything is being rerouted to doGet() for simplicity.
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        // switches that will activate when certain actions are performed on the web client.
        try {
            switch (action) {
                // executes when the "all" action is called in the web client.
                case "/all":
                    listGame(request,response);
                    break;
                // executes when the "genre" action is called in the web client.
                case "/genre":
                    // the last parameter passed requests the value from the parameter named
                    listByGenre(request,response, request.getParameter("genreParam"));
                    break;
                // executes when the "letter" action is called in the web client.
                case "/letter":
                    // the last parameter passed requests the value from the parameter named
                    listByLetter(request,response,request.getParameter("letterParam"));
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }

    }

    private void listGame(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException,
            ServletException{
        // creates a collection using information pulled from the database.
        List <GameDatabaseQuery> listGame = gameDAO.getAllGames();
        // creates an interaction within a table on the web client, searches for "listGame"
        request.setAttribute("listGame", listGame);
        // creates a dispatcher
        RequestDispatcher dispatcher = request.getRequestDispatcher("game-list.jsp");
        // forwards request objects to the web client via the dispatcher
        dispatcher.forward(request,response);
    }

    private void listByGenre(HttpServletRequest request, HttpServletResponse response, String genre) throws SQLException, IOException,
            ServletException{
        // creates a collection using information pulled from the database.
        List <GameDatabaseQuery> listByGenre = gameDAO.getByGenre(genre);
        // creates an interaction within a table on the web client, searches for "listByGenre"
        request.setAttribute("listByGenre", listByGenre);
        // creates a dispatcher
        RequestDispatcher dispatcher = request.getRequestDispatcher("game-genre.jsp");
        // forwards request objects to the web client via the dispatcher
        dispatcher.forward(request,response);
    }

    private void listByLetter(HttpServletRequest request, HttpServletResponse response, String letter) throws SQLException, IOException,
            ServletException{
        // creates a collection using information pulled from the database.
        List <GameDatabaseQuery> listByLetter = gameDAO.getGame(letter);
        // creates an interaction within a table on the web client, searches for "listByLetter"
        request.setAttribute("listByLetter", listByLetter);
        // creates a dispatcher
        RequestDispatcher dispatcher = request.getRequestDispatcher("game-letter.jsp");
        // forwards request objects to the web client via the dispatcher
        dispatcher.forward(request,response);
    }
}
