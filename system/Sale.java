package system;
import com.google.gson.Gson;
import services.PaymentService;

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
      tendered = new Payment("CHECK",amount);
      tendered.validatePayment();
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
   private transient String type;
   private String cardNumber;
   private float amount;


   public Payment(String type, float amount){
      this.type = type;
      this.amount = amount;
   }
   public Payment(float amount){
      this.type = "CHECK";
      this.amount = amount;
   }
   public boolean validatePayment(){
      String BASE_URL = "http://localhost:3000";
      PaymentService paymentService = new PaymentService(BASE_URL);
      switch (type){
         case "CHECK":
            System.out.println("Payment type: Check");
            paymentService.setPaymentType("/check");
            break;
         case "CREDIT":
            paymentService.setPaymentType("/credit");
            break;
      }
      System.out.println(paymentService.newPayment(createRequest()));
//      paymentService.newPayment(createRequest());
      return false;
   }
   private String createRequest(){
      Gson postBody = new Gson();
      return postBody.toJson(this);
   }

   public String getType(){
      return type;
   }

   public float getAmount(){
      return amount;
   }


}