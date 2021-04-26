import java.util.*;

public class Products {
    private Map<String, Product> productsBase;

    public Products() {
        productsBase = new HashMap<>();
    }

    public Map<String, Product> getProductsBase() {
        return productsBase;
    }

    public void fill() {
        Product product1 = new Product ("Монитор", "Samsung", 9350, "Максимальное разрешение: 1920x1080, широкоформатный", 5);
        Product product2 = new Product ("Холодильник", "Atlant", 22790, "Управление электронное", 4);
        Product product3 = new Product ("Плита", "Flama", 7190, "Рабочая поверхность - эмаль", 3);
        Product product4 = new Product ("Холодильник ", "Bosch", 38990, "Управление электронное", 5);
        Product product5 = new Product ("Молоко", "Клевер", 100, "Пастеризованное", 1);
        Product product6 = new Product ("Хлеб", "Fazer", 93, "Из твердых сортов пшеницы", 5);
        Product product7 = new Product ("Диван", "Аскона", 19350, "Еврокнижка", 2);
        Product product8 = new Product ("Плита", "Bosch", 11190, "Рабочая поверхность - эмаль", 4);
        productsBase.put("id000100", product1);
        productsBase.put("id000101", product2);
        productsBase.put("id000102", product3);
        productsBase.put("id000103", product4);
        productsBase.put("id000104", product5);
        productsBase.put("id000105", product6);
        productsBase.put("id000106", product7);
        productsBase.put("id000107", product8);
    }

    public void printProductsBase() {
        for (Map.Entry<String, Product> entry : productsBase.entrySet())
            System.out.println("Код: " + entry.getKey() + ", " + entry.getValue());
    }
}