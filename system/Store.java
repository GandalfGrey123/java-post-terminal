package system;

import services.*;
import java.util.HashMap;
import com.google.gson.Gson;

public class Store{

	private HashMap<String,Item> items = new HashMap<String,Item>();

	public Store(String url){
		Gson gson = new Gson();
		Products productService = new Products(url);
		Item[] itemArray = gson.fromJson(productService.getProducts(),Item[].class);
		for (Item item : itemArray) items.put(item.getUpc(), item);
	}

	public HashMap<String,Item> getItemList(){
		return items;
	}	
}