package system;

import services.*;

import com.google.gson.Gson;
import services.PaymentService;

public class Payment{
   private String type = "CASH";
   private int cardNumber;
   private float amount = 0.0f;
   private transient boolean successful = false;
   private transient String message;

   public Payment(int cardNumber, float creditAmount){
      this.type = "CREDIT";
      this.amount = creditAmount;
      this.cardNumber = cardNumber;
   }

   public Payment(float amount, boolean cash){
      if(cash){
         this.type = "CASH";
      }else{
         this.type = "CHECK";
      }
      
      this.amount = amount;
   }

   public boolean validatePayment(){
//      String BASE_URL = "http://localhost:3000";
      PaymentService paymentService = PaymentService.getInstance();
      switch (type){
         case "CHECK":
            paymentService.setPaymentType("/check");
            break;
         case "CREDIT":
            paymentService.setPaymentType("/credit");
            break;
      }
      parseValidation(paymentService.newPayment(createRequest()));
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

   public int getCreditCardNumber(){
      return cardNumber;
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