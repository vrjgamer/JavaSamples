/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductWebService;

import javax.xml.ws.Endpoint;


/**
 *
 * @author VRUSHABH
 */
public class ProductWebServicePublisher {
    
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:1234/marketcatalog", new ProductCatalog());
    }
    
}
