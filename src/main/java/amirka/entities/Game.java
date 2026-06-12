package amirka.entities;

public abstract class Game {
    private String id;
    private String title;
    private int year;
    private double price;

    public Game(String id, String title, int year, double price) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Games{" +
                "id= '" + id + '\'' +
                ", title= '" + title + '\'' +
                ", year= " + year +
                ", price= " + price +
                '}';
    }
}
