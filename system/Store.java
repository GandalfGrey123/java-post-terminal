package system;

import services.*;
import java.util.HashMap;
import com.google.gson.Gson;

public class Store{

	private Item[] items;

	public Store(String url){
		Gson gson = new Gson();
		Products productService = new Products(url);
		this.items = gson.fromJson(productService.getProducts(),Item[].class);
	}

	public Item[] getItemList(){
		return items;
	}

	public void printItems(){
		for(int i=0;i<items.length;i++){
			System.out.println(items[i].getUpc() + " " +items[i].getDescription()+ " " +items[i].getPrice()+"\n");
		}
	}
	
}