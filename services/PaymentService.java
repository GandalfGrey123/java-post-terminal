package services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class PaymentService{
	//End point to credit and check
    String baseUrl;

    public PaymentService(String baseUrl) {
        this.baseUrl = baseUrl + "/payments";
    }
    public void setPaymentType(String type){
        this.baseUrl = this.baseUrl + type;
//        System.out.println(this.baseUrl);
    }


    String getSales() {
        try {
            Get req = new Get(this.baseUrl);
            String res = req.execute();
            return res;
        } catch (MalformedURLException e) {
            return e.getMessage();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    public String newPayment(String payload) {

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