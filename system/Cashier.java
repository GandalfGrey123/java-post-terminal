package system;

import services.*;

import com.google.gson.Gson;

public class Cashier{
	
	public void createSale(){
		Gson gson = new Gson();
		Sale sale = new Sale("Pablo");
		sale.setName("Pablo");
		System.out.println(gson.toJson(sale));
	}
	
}