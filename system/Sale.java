package system;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

class Sale { 
   private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

   private String customer; 
   private Date timeOfSale = new Date();
   private ArrayList<Item> items = new ArrayList<Item>();
   private int total; 
   private Payment tendered;
   private int returned;
   
   public Sale(String customer){
      this.customer = customer;
   } 
   
   public String getName() { 
      return customer; 
   } 
   
   public void setName(String customer) { 
      this.customer = customer; 
   } 

   public void insertItem(String upc,int quantity,float price){
      Item item = new Item(upc,quantity,price);
      items.add(item);
   }
}

class Item{
   private String upc;
   private int quantity;
   private float price;


   public Item(String upc,int quantity,float price){
      this.upc = upc;
      this.quantity = quantity;
      this.price = price;
   }
   public String getDescription(){
      return upc;
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