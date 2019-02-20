package system;
import com.google.gson.Gson;
import services.PaymentService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

public class Sale { 
   private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

   private String customer = ""; 
   private Date timeOfSale = new Date();
   private ArrayList<SaleItem> items = new ArrayList<SaleItem>();
   private float total = 0.0f; 
   private Payment tendered;
   private float returned = 0.0f;
   
   public Sale(String customer){
      this.customer = customer;
   } 

   public void insertPaymentMethod(String type, float amount, int creditCardNumber){
      if(type.equals("CHECK")){
         tendered = new Payment(amount,false);
      }else if(type.equals("CASH")){
         tendered = new Payment(amount,true);
      }else if(type.equals("CREDIT")){
         tendered = new Payment(creditCardNumber, amount);
      }

      if(!type.equals("CASH")){
         tendered.validatePayment();
         System.out.println(tendered.getSuccessMsg());
      }

      returned = amount - total;
   }

   public void setItemList(ArrayList<SaleItem> items){
      this.items = items;
      items.forEach((item)->total+=item.getPrice());
   }

   public void insertItem(String upc,int quantity,float price){
      SaleItem item = new SaleItem(upc,quantity,price);
      total += quantity*price;
      items.add(item);
   }

   public String createJson(){
      Gson gson = new Gson();
      return gson.toJson(this);
   }

   public String getCustomerName(){
      return customer;
   }

   public ArrayList<SaleItem> getItemList(){
      return items;
   }

   public float getTotal(){
      return total;
   }

   public float getTendered(){
      return tendered.getAmount();
   }

   public String getPaymentMethod(){
      return tendered.getType();
   }

   public int getCreditCardNumber(){
      return tendered.getCreditCardNumber();
   }

   public float getReturned(){
      return returned;
   }

}
