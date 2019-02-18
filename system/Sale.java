package system;
import com.google.gson.Gson;
import services.PaymentService;

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

   public void insertPaymentMethod(String type, float amount){
      if(type.equals("check")){
         tendered = new Payment(amount);
      }else{
         tendered = new Payment(1234, amount);
      }

//      tendered = new Payment(1234, amount);
      tendered.validatePayment();
      System.out.println(tendered.getSuccessMsg());

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
   private int cardNumber;
   private float amount;
   private boolean successful = false;
   private String message;


   public Payment(int cardNumber, float creditAmount){
      this.type = "CREDIT";
      this.amount = creditAmount;
      this.cardNumber = cardNumber;
   }
   public Payment(float checkAmount){
      this.type = "CHECK";
      this.amount = checkAmount;
   }
   public boolean validatePayment(){
      String BASE_URL = "http://localhost:3000";
      PaymentService paymentService = new PaymentService(BASE_URL);
      switch (type){
         case "CHECK":
//            System.out.println("Payment type: Check");
            paymentService.setPaymentType("/check");
            break;
         case "CREDIT":
            paymentService.setPaymentType("/credit");
            break;
      }
      parseValidation(paymentService.newPayment(createRequest()));
//      paymentService.newPayment(createRequest());
      return successful;
   }
   private String createRequest(){
      Gson postBody = new Gson();
      return postBody.toJson(this);
   }
   private void parseValidation(String serverValidation){
      if(serverValidation.equals("202")){
         message = "Payment Successful";
         successful = true;
      }else if(serverValidation.equals("406")){
         message = "Payment Denied";
      }else{
         message = serverValidation;
      }

   }
   public String getType(){
      return type;
   }

   public float getAmount(){
      return amount;
   }
   public String getSuccessMsg(){
      return this.message;
   }
   public Boolean isSuccessful(){
      return this.successful;
   }


}