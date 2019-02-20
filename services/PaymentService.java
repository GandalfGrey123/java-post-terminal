package services;

import system.Payment;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class PaymentService{
	//End point to credit and check
    String static_base_url;
    String baseUrl;
    private static PaymentService single_instance = null;

//    Converted to a singleton class in order to keep the url for post requests


    private PaymentService(String s_base_url){
        this.static_base_url = s_base_url + "/payments";
        System.out.println(this.static_base_url);
    }
//    public void setPaymentType(String baseUrl) {
//        this.baseUrl = baseUrl + "/payments";
//    }

//    public PaymentService(String baseUrl) {
//        this.baseUrl = baseUrl + "/payments";
//    }
    public void setPaymentType(String type){
        this.baseUrl = this.static_base_url + type;
//        System.out.println(this.baseUrl);
    }
    public static PaymentService getInstance(String static_base_url){
        if (single_instance == null){
            single_instance = new PaymentService(static_base_url);
        }
        return single_instance;
    }
    public static PaymentService getInstance(){
        if (single_instance == null){
            single_instance = new PaymentService("http://post-server.herokuapp.com");
        }
        return single_instance;
    }

    public String newPayment(String payload) {
        System.out.println(this.baseUrl);

        try {
            Post req = new Post(this.baseUrl);
            return req.execute(payload);
        } catch (MalformedURLException e) {
            return e.getMessage();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

}