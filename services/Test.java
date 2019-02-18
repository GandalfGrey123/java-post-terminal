package services;

import system.Sale;

public class Test {
    public static void main(String[] args) {
        Sale s = new Sale("Gary Straub");
        s.insertPaymentMethod("CHECK", 4000);
        System.out.println("Hello World!");
    }
}
