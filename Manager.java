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
		Item[] items = store.getItemList();
		Cashier cashier = new Cashier();
		Sale sale = cashier.createSale("Pablo");
		cashier.insertItemToSale(sale,items[0].getUpc(),3,items[0].getPrice());
		cashier.insertPaymentMethod("CHECK",300.0f);
		System.out.println(cashier.createJson(sale));
	}

}