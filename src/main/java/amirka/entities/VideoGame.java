package amirka.entities;

public class VideoGame extends Games {
    private String platform;
    private int gameHours;
    private Genre genre;

    public VideoGame(String id, String title, int year, double price, String platform, int gameHours, Genre genre) {
        super(id, title, year, price);
        this.platform = platform;
        this.gameHours = gameHours;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "VideoGame{" +
                super.toString() +
                ", platform='" + platform + '\'' +
                ", gameHours=" + gameHours +
                ", genre=" + genre +
                '}';
    }
}
