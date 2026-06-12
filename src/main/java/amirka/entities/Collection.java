package amirka.entities;

import amirka.exception.Duplicate;

import java.util.ArrayList;
import java.util.List;

public class Collection {
    private List<Game> games;

    public Collection() {
        games = new ArrayList<>();
    }

    public void addGame(Game game) throws Duplicate {
        for (Game g : games) {
            if (g.getId()
                    .equals(game.getId())) {
                throw new Duplicate("A game with the same ID exists. Choose a different ID.");
            }
            games.add(game);
        }
    }


}
