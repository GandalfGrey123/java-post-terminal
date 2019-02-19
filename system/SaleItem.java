package system;
import com.google.gson.Gson;
import services.PaymentService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

public class SaleItem{
   	private String upc;
   	private int quantity;
   	private float price;

   	public SaleItem(String upc,int quantity,float price){
      this.upc = upc;
      	this.quantity = quantity;
      	this.price = price;
   	}

   	public float getPrice(){
   		return price;
   	}

   	public int getQuantity(){
   		return quantity;
   	}

   	public String getUpc(){
   		return upc;
   	}
}