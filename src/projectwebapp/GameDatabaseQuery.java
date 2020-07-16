package projectwebapp;

import javax.persistence.*;

@Entity
// name of the table in the database
@Table (name = "games")

public class GameDatabaseQuery {

    // Names assigned are those that are in the table for the database
    @Id @Column (name = "GAME_ID")
    private String game_id;
    @Column (name = "GAME_NAME")
    private String game_name;
    @Column (name = "GAME_GENRE")
    private String game_genre;

    public String getGame_id() {
        return game_id;
    }

    public void setGame_id(String game_id) {
        this.game_id = game_id;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public String getGame_genre() {
        return game_genre;
    }

    public void setGame_genre(String game_genre) {
        this.game_genre = game_genre;
    }

}
