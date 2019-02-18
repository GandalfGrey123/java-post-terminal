import gui.*;
import services.*;
import system.*;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Manager{

	public static void main(String[] args){
		if(args.length != 1){
			System.out.println("Error: Manager <REST API URL>");
			return;
		}
		Store store = new Store(args[0]);
		Item[] items = store.getItemList();
		Cashier cashier = new Cashier();
		startGui(items);
	}


	public static void startGui(Item[] items){
		List<String> productDescriptions = new ArrayList<>();
		for (Item item : items) {
		    productDescriptions.add(item.getDescription());
		}
		String[] itemNames = new String[productDescriptions.size()];
		itemNames = productDescriptions.toArray(itemNames);
		PostView.start(itemNames);
	}
}