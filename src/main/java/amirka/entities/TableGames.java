package amirka.entities;

public class TableGames extends Game {
    private int players;
    private int gameDurationMin;

    public TableGames(int id, String title, int year, double price, int players, int gameDurationMin) {
        super(id, title, year, price);
        this.players = players;
        this.gameDurationMin = gameDurationMin;
    }

    public int getPlayers() {
        return players;
    }

    public void setPlayers(int players) {
        this.players = players;
    }

    public int getGameDurationMin() {
        return gameDurationMin;
    }

    public void setGameDurationMin(int gameDurationMin) {
        this.gameDurationMin = gameDurationMin;
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
