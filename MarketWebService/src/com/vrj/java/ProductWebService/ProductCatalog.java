package com.vrj.java.ProductWebService;


import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.vrj.java.Model.Product;
import com.vrj.java.ProductServices.ProductServiceHelper;

@WebService(name = "MarketCatalog",  portName = "MarketCatalogPort", targetNamespace = "http://www.Market.com")
public class ProductCatalog implements ProductCatalogInterface {

    private ProductServiceHelper service = new ProductServiceHelper();

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
    public ArrayList<Product> getProductsv2(String category) {
        return service.getProductsv2(category);
    }

}
