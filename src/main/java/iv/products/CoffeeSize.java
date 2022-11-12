package iv.products;

public enum CoffeeSize {
    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large");

    private String name;
    private CoffeeSize(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
