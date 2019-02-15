import gui.*;
import services.*;
import system.*;

import java.util.HashMap;

public class Manager{

	public static void main(String[] args){
		if(args.length != 1){
			System.out.println("Error: Manager <REST API URL>");
			return;
		}
		Store store = new Store(args[0]);
		//store.printItems();
		Cashier cashier = new Cashier();
		Sale sale = cashier.createSale("Pablo",20.0f,"CHECK");
		System.out.println(cashier.createJson(sale));
	}

}