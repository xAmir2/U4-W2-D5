package amirka;

import amirka.entities.Genre;
import amirka.entities.TableGames;
import amirka.entities.VideoGame;

public class Application {

    public static void main(String[] args) {
        VideoGame game = new VideoGame("2523523", "CoD", 2014, 99.99, "XBOX", 23, Genre.FPS);
        System.out.println("Video game test: " + game);
        TableGames game2 = new TableGames("35423523", "UNO", 2012, 29.99, 4, 10);
        System.out.println("Table game test: " + game2);
    }
}
