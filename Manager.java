import gui.*;
import services.*;
import system.*;

import java.util.HashMap;
import com.google.gson.Gson;

public class Manager{

	public static void main(String[] args){
		if(args.length != 1){
			System.out.println("Error: Manager <REST API URL>");
			return;
		}
		//ProductService productService = new ProductService(arg[1]);
		Gson gson = new Gson();
		Item[] items = gson.fromJson("[{\"upc\": \"CX14\",\"description\": \"Wine - Niagara,vqa Reisling\",\"price\": \"$79.75\"}]", Item[].class);
		System.out.println(items[0].getDescription());
		/*Cashier cashier = new Cashier();
		cashier.createSale();*/
	}

}