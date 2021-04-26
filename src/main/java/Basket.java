import java.util.*;

public class Basket {
    private Map<String, Integer> basketProduct;

    public Basket() {
        basketProduct = new HashMap<>();
    }

    public Map<String, Integer> getBasketProduct() {
        return basketProduct;
    }

    public void basketPut(String id, int quantity) {
        basketProduct.put(id, quantity);
    }

    public void printBascetPut(Products products) {
        for(Map.Entry<String, Integer> entry : basketProduct.entrySet()) {
            Product product = products.getProductsBase().get(entry.getKey());
            System.out.println(product + " количество " + entry.getValue() + " cтоимость: " + (entry.getValue() * product.getCost()));
        }
    }

    public void basketRemove(String inputDel) {
        basketProduct.remove(inputDel);
    }
}