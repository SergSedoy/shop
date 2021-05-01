import java.util.Map;

public class SearchName implements FilterName{
    private Map<String,Product> productsBase;

    public SearchName(Map<String,Product> productsBase) {
        this.productsBase = productsBase;
    }

    @Override
    public void filterName(String name) {
        for(Map.Entry<String, Product> entry : productsBase.entrySet()) {
            if(entry.getValue().getName().equals(name)){
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
