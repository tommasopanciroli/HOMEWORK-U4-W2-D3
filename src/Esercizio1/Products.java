package Esercizio1;

public class Products {
    private String title;
    private double price;

    public void Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titolo='" + title + '\'' +
                ", prezzo =" + price +
                '}';
    }
}
