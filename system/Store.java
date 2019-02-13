package system;

import java.util.HashMap;

public class Store{
	private HashMap<Integer,String> items;

	public Store(HashMap<Integer,String> items){
		this.items = items;
	}

	public String getDescription(int upc){
		return items.get(upc);
	}
	
}