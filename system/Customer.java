package system;

import java.util.HashMap;

public class Customer{
	private String name, paymentMethod;
	private HashMap<Integer,Integer> shoppingCart = new HashMap<Integer,Integer>();

	public Customer(String name){
		this.name = name;
	}

	public void addItemToShoppingCart(int upc, int quantity){
		shoppingCart.put(upc,quantity);
	}

	public HashMap<Integer,Integer> getShoppingCart(){
		return shoppingCart;
	}

	public void setPaymentMethod(String paymentMethod){
		this.paymentMethod = paymentMethod;
	}
	
}