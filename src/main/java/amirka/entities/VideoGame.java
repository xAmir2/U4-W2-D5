package amirka.entities;

public class VideoGame extends Game {
    private String platform;
    private int gameHours;
    private Genre genre;

    public VideoGame(String id, String title, int year, double price, String platform, int gameHours, Genre genre) {
        super(id, title, year, price);
        this.platform = platform;
        this.gameHours = gameHours;
        this.genre = genre;
    }

    public String getPlatform() {
        return platform;
    }

    public int getGameHours() {
        return gameHours;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "VideoGame{" +
                super.toString() +
                ", platform= '" + platform + '\'' +
                ", gameHours= " + gameHours +
                ", genre= " + genre +
                '}';
    }
}
