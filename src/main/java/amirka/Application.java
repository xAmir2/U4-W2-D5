package amirka;

import amirka.entities.Collection;
import amirka.entities.Genre;
import amirka.entities.TableGames;
import amirka.entities.VideoGame;
import amirka.exception.Duplicate;
import amirka.exception.NotFound;

public class Application {

    public static void main(String[] args) throws NotFound {
        VideoGame game = new VideoGame("2523523", "CoD", 2014, 99.99, "XBOX", 23, Genre.FPS);
        System.out.println("Video game test: " + game);
        TableGames game2 = new TableGames("35423523", "UNO", 2012, 29.99, 4, 10);
        System.out.println("Table game test: " + game2);
        Collection collection = new Collection();
        try {
            collection.addGame(game);
            collection.addGame(game2);
            System.out.println("Test collection: " + collection);
        } catch (Duplicate e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Test find game using id 32456326: " + collection.findGameUsingId("2523523"));


    }
}
