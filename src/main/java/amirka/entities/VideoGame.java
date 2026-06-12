package amirka.entities;

public class VideoGame extends Game {
    private String platform;
    private int gameHours;
    private Genre genre;

    public VideoGame(int id, String title, int year, double price, String platform, int gameHours, Genre genre) {
        super(id, title, year, price);
        this.platform = platform;
        this.gameHours = gameHours;
        this.genre = genre;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setGameHours(int gameHours) {
        this.gameHours = gameHours;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "VideoGame: " +
                super.toString() +
                ", platform= '" + platform + '\'' +
                ", gameHours= " + gameHours +
                ", genre= " + genre;
    }
}
