package system;

import services.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Date;
import com.google.gson.Gson;

public class Store{

	private HashMap<String,Item> items = new HashMap<String,Item>();
	private String salesLog = "";

	public Store(String url){
		Gson gson = new Gson();
		ProductService productService = new ProductService(url);
		Item[] itemArray = gson.fromJson(productService.getProducts(),Item[].class);
		for (Item item : itemArray) items.put(item.getUpc(), item);
	}

	public HashMap<String,Item> getItemList(){
		return items;
	}	

	public void addToSalesLog(Sale sale){
		Date date = new Date();

		salesLog += "\n"+sale.getCustomerName() +"\t"+ date.getTime()+"\n";
		sale.getItemList().forEach((item)->{
			salesLog+=items.get(item.getUpc()).getDescription()+" "+item.getQuantity()+"@"+items.get(item.getUpc()).getPrice()+" - "+item.getPrice()+">\n";
		});
		salesLog += "-----\nTotal $" + sale.getTotal()+"\n";
		switch(sale.getPaymentMethod()){
			case "CASH":
						salesLog +=	"Amount Tendered: " + sale.getTendered() + "\n" 
						+"Amount Returned: "+ sale.getReturned() + "\n";
						break;
			case "CREDIT":
						salesLog += "Paid by Credit Card "+sale.getCreditCardNumber()+"\n";
						break;
			case "CHECK":
						salesLog += "Paid by Check\n";
						break;
		}
	}

	public void printSalesLog(){
		System.out.println(salesLog);
	}
}