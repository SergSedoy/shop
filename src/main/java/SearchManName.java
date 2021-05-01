import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchManName implements FilterManuf, FilterName {
    private Map<String,Product> productsBase;
    private List<Product> list = new ArrayList<>();

    public SearchManName(Map<String,Product> productsBase) {
        this.productsBase = productsBase;
    }

    @Override
    public void filterManufacturer(String manufacturer) {
        for (Map.Entry<String, Product> entry : productsBase.entrySet()) {
            if (manufacturer.equals(entry.getValue().getManufacturer())) {
                list.add(entry.getValue());
            }
        }
    }

    @Override
    public void filterName(String name) {
        list.stream().filter(x -> name.equals(x.getName()))
                .forEach(System.out::println);
    }
}
