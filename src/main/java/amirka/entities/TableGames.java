package amirka.entities;

public class TableGames extends Games {
    private int players;
    private int gameDurationMin;

    public TableGames(String id, String title, int year, double price, int players, int gameDurationMin) {
        super(id, title, year, price);
        this.players = players;
        this.gameDurationMin = gameDurationMin;
    }

    public int getPlayers() {
        return players;
    }

    public int getGameDurationMin() {
        return gameDurationMin;
    }

    @Override
    public String toString() {
        return "TableGames{" +
                super.toString() +
                ", players= " + players +
                ", gameDurationMin= " + gameDurationMin +
                '}';
    }
}
