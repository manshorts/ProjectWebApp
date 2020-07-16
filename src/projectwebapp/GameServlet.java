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

        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/all":
                    listGame(request,response);
                    break;
                case "/genre":
                    listByGenre(request,response, request.getParameter("genreParam"));
                    break;
                case "/letter":
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
        List <GameDatabaseQuery> listGame = gameDAO.getAllGames();
        request.setAttribute("listGame", listGame);
        RequestDispatcher dispatcher = request.getRequestDispatcher("game-list.jsp");
        dispatcher.forward(request,response);
    }

    private void listByGenre(HttpServletRequest request, HttpServletResponse response, String genre) throws SQLException, IOException,
            ServletException{
        List <GameDatabaseQuery> listByGenre = gameDAO.getByGenre(genre);
        request.setAttribute("listByGenre", listByGenre);
        RequestDispatcher dispatcher = request.getRequestDispatcher("game-genre.jsp");
        dispatcher.forward(request,response);
    }

    private void listByLetter(HttpServletRequest request, HttpServletResponse response, String letter) throws SQLException, IOException,
            ServletException{
        List <GameDatabaseQuery> listByLetter = gameDAO.getGame(letter);
        request.setAttribute("listByLetter", listByLetter);
        RequestDispatcher dispatcher = request.getRequestDispatcher("game-letter.jsp");
        dispatcher.forward(request,response);
    }
}
