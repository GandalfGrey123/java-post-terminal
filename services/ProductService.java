package services;

import java.net.MalformedURLException;
import java.io.IOException;

public class ProductService {
	
  private String getProductsRoute;

  public ProductService(String baseUrl){
    getProductsRoute = baseUrl+"/products";
  } 
  public String getProducts(){
      try{
        String productsJsonString = new Get(getProductsRoute).execute();
        return productsJsonString;
      } catch (MalformedURLException e) {
          return e.getMessage();
      } catch (IOException e) {
          return e.getMessage();
      }
  }
}
