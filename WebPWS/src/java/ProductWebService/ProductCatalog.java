package ProductWebService;

import ProductService.ProductServiceHelper;
import java.util.ArrayList;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name = "MarketCatalog", serviceName = "MarketCatalogService", portName = "MarketCatalogPort", targetNamespace = "http://www.Market.com")
public class ProductCatalog implements ProductCatalogInterface {

    private ProductService.ProductServiceHelper service = new ProductServiceHelper();

    @Override
    public ArrayList<String> getProductCategories() {
        return service.getProductCategories();
    }

    @Override
    public ArrayList<String> getProducts(String category) throws InvalidInputException {
        return service.getProducts(category);
    }

    @Override
    public boolean addProduct(String category, String product) throws InvalidInputException {
        return service.addProduct(category, product);
    }

    @Override
    @WebResult(name = "Product")
    public ArrayList<Model.Product> getProductsv2(String category) {
        return service.getProductsv2(category);
    }

}
