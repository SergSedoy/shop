import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private List<Map<Product, Integer>> listOrders;

    public Order() {
        listOrders = new ArrayList<>();
    }

    public List<Map<Product, Integer>> getOrders() {
        return listOrders;
    }

    public void listOrders(Map<String, Integer> order, Products products) {
        Map<Product, Integer> orderInList = new HashMap<>();
        for(Map.Entry<String, Integer> entry : order.entrySet()) {
            Product product = products.getProductsBase().get(entry.getKey());
            orderInList.put(product, entry.getValue());
        }
        listOrders.add(orderInList);
    }

    public void print() {
        int i = 1;
        for (Map<Product, Integer> map : listOrders) {
            System.out.println("Заказ № " + i + " : ");
            for (Map.Entry<Product, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " количество " + entry.getValue() + " cтоимость: " + (entry.getValue() * entry.getKey().getCost()));
            }
            i++;
        }
    }
}
