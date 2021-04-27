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
        Product product1 = new Product ("id000100", "Монитор", "Samsung", 9350, "Максимальное разрешение: 1920x1080, широкоформатный", 5);
        Product product2 = new Product ("id000101", "Холодильник", "Atlant", 22790, "Управление электронное", 4);
        Product product3 = new Product ("id000102", "Плита", "Flama", 7190, "Рабочая поверхность - эмаль", 3);
        Product product4 = new Product ("id000103", "Холодильник ", "Bosch", 38990, "Управление электронное", 5);
        Product product5 = new Product ("id000104", "Молоко", "Клевер", 100, "Пастеризованное", 1);
        Product product6 = new Product ("id000105", "Хлеб", "Fazer", 93, "Из твердых сортов пшеницы", 5);
        Product product7 = new Product ("id000106", "Диван", "Аскона", 19350, "Еврокнижка", 2);
        Product product8 = new Product ("id000107", "Плита", "Bosch", 11190, "Рабочая поверхность - эмаль", 4);
        productsBase.put(product1.getId(), product1);
        productsBase.put(product2.getId(), product2);
        productsBase.put(product3.getId(), product3);
        productsBase.put(product4.getId(), product4);
        productsBase.put(product5.getId(), product5);
        productsBase.put(product6.getId(), product6);
        productsBase.put(product7.getId(), product7);
        productsBase.put(product8.getId(), product8);
    }

    public void printProductsBase() {
        for (Map.Entry<String, Product> entry : productsBase.entrySet())
            System.out.println("Код: " + entry.getKey() + ", " + entry.getValue());
    }
}