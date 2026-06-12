package amirka.entities;

import amirka.exception.Duplicate;
import amirka.exception.NotFound;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Collection {
    private List<Game> games;

    public Collection() {
        games = new ArrayList<>();
    }

    public void addGame(Game game) throws Duplicate {
        for (Game g : games) {
            if (g.getId()
                    == game.getId()) {
                throw new Duplicate("A game with the same ID exists. Choose a different ID.");
            }
        }
        games.add(game);
    }

    public Game findGameUsingId(int id) throws NotFound {
        for (Game g : games) {
            if (g.getId() == id) {
                return g;
            }
        }
        throw new NotFound("Game not found.");
    }

    public List<Game> findGameUsingPrice(double price) {
        return games.stream()
                .filter(game -> game.getPrice() < price)
                .toList();
    }

    public List<TableGames> findTableGamesUsingPlayers(int players) {
        return games.stream()
                .filter(game -> game instanceof TableGames)
                .map(game -> (TableGames) game)
                .filter(tableGames -> tableGames.getPlayers() == players)
                .toList();
    }

    public void removeGame(int id) throws NotFound {
        Game game = findGameUsingId(id);
        games.remove(game);
    }

    public void updateGameParams(int id, double price, String title, int year) throws NotFound {
        Game game = findGameUsingId(id);
        game.setPrice(price);
        game.setTitle(title);
        game.setYear(year);
    }

    public void updateVideoGame(int id, String platform, int gameHours, Genre genre) throws NotFound {
        Game game = findGameUsingId(id);

        if (!(game instanceof VideoGame video)) {
            throw new IllegalArgumentException("Game with the ID " + id + "is not a VideoGame");
        }
        video.setPlatform(platform);
        video.setGameHours(gameHours);
        video.setGenre(genre);
    }

    public void updateTableGames(int id, int players, int gameDurationMin) throws NotFound {
        Game game = findGameUsingId(id);

        if (!(game instanceof TableGames table)) {
            throw new IllegalArgumentException("Game with the ID " + id + "is not a TableGame");
        }
        table.setPlayers(players);
        table.setGameDurationMin(gameDurationMin);
    }

    public void stats() {
        long videoGames = games.stream()
                .filter(game -> game instanceof VideoGame)
                .count();
        long tableGames = games.stream()
                .filter(game -> game instanceof TableGames)
                .count();
        double averagePrice = games.stream()
                .mapToDouble(Game::getPrice)
                .average()
                .orElse(0);
        Game mostExpensive = games.stream()
                .max(Comparator.comparing(Game::getPrice))
                .orElse(null);

        System.out.println("Total amount video games: " + videoGames);
        System.out.println("Total amount table games " + tableGames);
        System.out.println("Average price: " + averagePrice);
        System.out.println("Most expensive: " + mostExpensive);
    }

    @Override
    public String toString() {
        return "" + games;
    }
}
