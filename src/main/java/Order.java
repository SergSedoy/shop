import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private List<Map<String, Integer>> orders;

    public Order() {
        orders = new ArrayList<>();
    }

    public List<Map<String, Integer>> getOrders() {
        return orders;
    }

    public void listOrders(Map<String, Integer> order) {
        orders.add(order);
    }
}
