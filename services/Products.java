public class ProductService {
	
  private String getProductsRoute;

  public ProductService(String baseUrl){
    getProductsRoute = baseUrl+"/products";
  } 
  public String getProducts(){
      try{
      String productsJsonString = new Get(getProductsRoute).execute();
    } catch(Exception ex){
      ex.printStackTrace();
    }
    return productsJsonString;
  }
}
