package com.vrj.java.ProductWebService;


import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.vrj.java.Model.Product;

/**
 *
 * @author VRUSHABH
 */
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
