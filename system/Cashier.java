package system;

import services.*;

import com.google.gson.Gson;

public class Cashier{
	
	public void createSale(){
		Gson gsonSale = new Gson();
		/*Sale sale = new Sale();
		sale.setName("Pablo");
		sale.setAmountTendered(20);
		
		String jsonString = gsonSale.toJson(sale); */         
      	System.out.println(gsonSale); 
	}
	
}