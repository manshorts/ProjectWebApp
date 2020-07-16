package projectwebapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GameDAO {

    public static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public List<GameDatabaseQuery> getGame(String letter) {
        Transaction transaction = null;
        // Where the queried objects will be stored
        List <GameDatabaseQuery> letterList = null;

        // Opens session and begins communication with database
        try (Session session = sessionFactory.openSession()) {
            // start transaction
            transaction = session.beginTransaction();
            // get game object and assigns to collection
            // query searches for games by given letter and sorts them by name alphabetically
            letterList = session.createQuery("from GameDatabaseQuery" +
                    " where game_name like '" + letter + "%'" +
                    " order by game_name").getResultList();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        // returns the collections within the list.
        return letterList;
    }

    public List<GameDatabaseQuery> getByGenre(String genre) {
        Transaction transaction = null;
        // Objects from database will be stored in this collection
        List <GameDatabaseQuery> gameList = null;

        // Opens session to begin communication with database.
        try (Session session = sessionFactory.openSession()){
            // start transaction
            transaction = session.beginTransaction();
            // get game objects and assigns them to collection
            // query finds the games with the given genre and orders them by name
            gameList = session.createQuery("from GameDatabaseQuery " +
                    "where game_genre='" + genre + "' order by game_name").getResultList();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        // returns the objects within the collection
        return gameList;
    }

    // Pulls all of the games in the database and assigns them to a list.
    public List< GameDatabaseQuery > getAllGames() {

        Transaction transaction = null;
        // Collection where the objects will be stored.
        List <GameDatabaseQuery> gameList = null;

        // Session opened for communication with the database
        try (Session session = sessionFactory.openSession()) {
            // start transaction
            transaction = session.beginTransaction();
            // get game objects and assigns them to the collection
            // query will get all games and order them by their names
            gameList = session.createQuery("from GameDatabaseQuery order by game_name").getResultList();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        // collection with objects is returned
        return gameList;
    }

}
