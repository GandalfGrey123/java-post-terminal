package system;

import services.*;

import com.google.gson.Gson;

public class Cashier{
	
	public Sale createSale(String customer, float amount, String type){
		boolean accepted;
		Sale sale = new Sale(customer);
		sale.insertPaymentMethod(type,amount);
		if(type.equals("CHECK"))
			accepted = checkCheck(amount);

		return sale;
	}

	public Sale createSale(String customer, float amount, String type, int cardNumber){
		Sale sale = new Sale(customer);
		sale.insertPaymentMethod(type,amount);
		boolean accepted = checkCredit(cardNumber,cardNumber);
		return sale;
	}

	public void insertItemToSale(Sale sale,String upc, int quantity, float price){
		sale.insertItem(upc,quantity,price);
	}

	public String createJson(Sale sale){
		Gson gson = new Gson();
		return gson.toJson(sale);
	}

	public boolean checkCredit(float amount,int cardNumber){
		Credit credit = new Credit();
		credit.amount = amount;
		credit.cardNumber = cardNumber;
		//create JSON and send to service
		return true;
	}

	public boolean checkCheck(float amount){
		//create JSON and send to service
		Check check = new Check();
		check.amount = amount;
		return true;
	}
	
}

class Check{
	public float amount;
} 

class Credit{
	public float amount;
	public int cardNumber;
} 
