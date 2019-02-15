package system;

import java.util.HashMap;
import com.google.gson.annotations.SerializedName;


public class Store{

	private Item[] items;

	public Store(Item[] items){
		this.items = items;
	}

	public Item[] getItemList(){
		return items;
	}
	
}