public class Products {
	
  private String getProductsRoute;

  public Products(String baseUrl){
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
