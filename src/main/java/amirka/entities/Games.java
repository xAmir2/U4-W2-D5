package amirka.entities;

public abstract class Games {
    private String id;
    private String title;
    private int year;
    private double price;

    public Games(String id, String title, int year, double price) {
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

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
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
