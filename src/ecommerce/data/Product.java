package ecommerce.data;

public class Product {

    private final int id;
    private final String name;
    private final String description;
    private final double priceInINR;
    private final Rating rating;
    private final boolean isPayOnDelivery;

    public Product(int id, String name, String description, double priceInINR, Rating rating, boolean isPayOnDelivery) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priceInINR = priceInINR;
        this.rating = rating;
        this.isPayOnDelivery = isPayOnDelivery;
    }

    public boolean isPayOnDelivery() {
        return isPayOnDelivery;
    }

    public double getPriceInINR() {
        return priceInINR;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Rating getRating() {
        return rating;
    }
}
