package system;

import com.google.gson.annotations.SerializedName;

public class Item{
	@SerializedName("upc")
   	private String upc;
   	@SerializedName("description")
   	private String description;
   	@SerializedName("price")
   	private String price;

   public Item(String upc,String description,String price){
      this.upc = upc;
      this.description = description;
      this.price = price;
   }

   public String getDescription(){
   		return description;
   }

   public String getUpc(){
   		return upc;
   }

   public String getPrice(){
   		return price;
   }
}