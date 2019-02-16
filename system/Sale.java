package system;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

public class Sale { 
   private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

   private String customer; 
   private Date timeOfSale = new Date();
   private ArrayList<SaleItem> items = new ArrayList<SaleItem>();
   private float total = 0.0f; 
   private Payment tendered;
   private float returned = 0.0f;
   
   public Sale(String customer){
      this.customer = customer;
   } 

   public void insertPaymentMethod(String type,float amount){
      tendered = new Payment(type,amount);
      returned = amount - total;
   }

   public void insertItem(String upc,int quantity,float price){
      SaleItem item = new SaleItem(upc,quantity,price);
      total += quantity*price;
      items.add(item);
   }
}

class SaleItem{
   private String upc;
   private int quantity;
   private float price;

   public SaleItem(String upc,int quantity,float price){
      this.upc = upc;
      this.quantity = quantity;
      this.price = price;
   }
}

class Payment{
   private String type;
   private float amount;

   public Payment(String type,float amount){
      this.type = type;
      this.amount = amount;
   }

   public String getType(){
      return type;
   }

   public float getAmount(){
      return amount;
   }
}