/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductService;

import Model.Product;
import ProductWebService.InvalidInputException;
import java.util.ArrayList;

/**
 *
 * @author VRUSHABH
 */
public class ProductServiceHelper {

    ArrayList<Product> productList = new ArrayList<Product>();
    ArrayList<String> bookList = new ArrayList<String>();
    ArrayList<String> musicList = new ArrayList<String>();
    ArrayList<String> movieList = new ArrayList<String>();

    public ProductServiceHelper() {
        bookList.add("Inferno");
        bookList.add("JoyLand");
        bookList.add("The Game of Thrones");

        musicList.add("Random Access Memories");
        musicList.add("Night Vision");
        musicList.add("Unorthodox Jukebox");

        movieList.add("Oz the Great and Powerful");
        movieList.add("Despicable Me");
        movieList.add("Star Trek Into Darkness");

    }

    public ArrayList<String> getProducts(String category)  throws InvalidInputException{
        switch (category) {
            case "Books":
            case "books":
                return bookList;
            case "Movies":
            case "movies":
                return movieList;
            case "Music":
            case "music":
                return musicList;
            default:
                throw new InvalidInputException(category+" is not valid", "Invalid Input");
        }
    }

    public ArrayList<String> getProductCategories() {
        ArrayList<String> categories = new ArrayList<String>();
        categories.add("Books");
        categories.add("Music");
        categories.add("Movies");
        return categories;
    }

    public boolean addProduct(String category, String product) throws InvalidInputException {
        switch (category) {
            case "Books":
            case "books":
                bookList.add(product);
                break;
            case "Movies":
            case "movies":
                movieList.add(product);
                break;
            case "Music":
            case "music":
                musicList.add(product);
                break;
            default:
                throw new InvalidInputException(category+" is not valid", "Invalid Input");
              
        }

        return true;

    }
public ArrayList<Model.Product> getProductsv2(String category) {
        Product product = new Product("Java Beans", "123", 99999.9);
        productList.add(product);
        product = new Product("Jokes", "12", 5000);
        productList.add(product);
        return productList;
    }
}
