public class Product {
    private String id;
    private String name;
    private String manufacturer;
    private int cost;
    private String specifications;
    private int rating;

    public Product(String id, String name, String manufacturer, int cost, String specifications, int rating) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.cost = cost;
        this.specifications = specifications;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getCost() {
        return cost;
    }

    public String getSpecifications() {
        return specifications;
    }

    public int getRating() {
        return rating;
    }



    public String toString() {
        return "Товар " + name + ", производитель: " + manufacturer + ", цена " + cost;
    }
}