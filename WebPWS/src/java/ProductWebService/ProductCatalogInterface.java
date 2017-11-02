/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductWebService;

import Model.Product;
import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author VRUSHABH
 */
@WebService(name = "MarketCatalog", portName = "MarketCatalogPort", targetNamespace = "http://www.Market.com")
public interface ProductCatalogInterface {

    @WebMethod(action = "add_product", operationName = "addProducts")
    boolean addProduct(String category, String product) throws InvalidInputException;

    @WebMethod(action = "fetch_categories", operationName = "fetchCategories")
    ArrayList<String> getProductCategories();

    @WebMethod(action = "fetch_products", operationName = "fetchProducts")
    ArrayList<String> getProducts(String category) throws InvalidInputException;

    @WebMethod(action = "fetch_products", operationName = "fetchProducts")
    ArrayList<Product> getProductsv2(String category);

}
