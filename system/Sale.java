package system;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.Date;

class Sale { 
   private String name; 
   private int amountTendered,totalAmount; 
   private HashMap<Integer,Integer> items = new HashMap<Integer,Integer>();
   private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
   private Date date = new Date();
   
   public Sale(){} 
   
   public String getName() { 
      return name; 
   } 
   
   public void setName(String name) { 
      this.name = name; 
   } 
   
   public int getAmountTendered() { 
      return amountTendered; 
   } 
   
   public void setAmountTendered(int age) { 
      this.amountTendered = amountTendered; 
   } 

   public HashMap<Integer,Integer> getItemList(){
      return items;
   }
   
   public String toString() { 
      return "Sale [ name: "+name+", amountTendered: "+ amountTendered+ " ]"; 
   }  
}