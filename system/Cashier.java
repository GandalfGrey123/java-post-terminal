package system;

import services.*;

import com.google.gson.Gson;

public class Cashier{
	
	public Sale createSale(String customer){
		Sale sale = new Sale(customer);
		return sale;
	}

	public void insertPaymentMethod(String type, float amount, int cardNumber){ //CREDIT
		boolean accepted = checkCredit(amount,cardNumber);
	}

	public void insertPaymentMethod(String type, float amount){ //CASH OR CHECK
		boolean accepted = true;
		if(type.equals("CHECK"))
			accepted = checkCheck(amount);
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
