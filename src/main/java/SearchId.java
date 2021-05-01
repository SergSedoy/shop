import java.util.Map;

public class SearchId implements FilterId{
    private Map<String, Product> productsBase;

    public SearchId(Map<String, Product> productsBase) {
        this.productsBase = productsBase;
    }

    @Override
    public void filterId(String id) {
        System.out.println(id + ": " + productsBase.get(id));
    }
}
