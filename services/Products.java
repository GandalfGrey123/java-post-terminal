package services;

import java.net.MalformedURLException;
import java.io.IOException;

public class Products {
	
  private String getProductsRoute;

  public Products(String baseUrl){
    getProductsRoute = baseUrl+"/products";
  } 
  public String getProducts(){
      try{
      String productsJsonString = new Get(getProductsRoute).execute();
      } catch (MalformedURLException e) {
           return e.getMessage();
       } catch (IOException e) {
           return e.getMessage();
       }
      return null;
//    return productsJsonString;
  }
}
