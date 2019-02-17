package services;

import java.io.IOException;
import java.net.MalformedURLException;

public class Payment{
	//End point to credit and check
    String baseUrl;

    Payment(String baseUrl) {
        this.baseUrl = baseUrl + "/payment";
    }
    public String check(String payload){
        this.baseUrl = this.baseUrl + "/check";
        try {
            Post postRequest = new Post(this.baseUrl);
            String response = postRequest.execute();
        }

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

    String newPayment(String payload) {
        try {
            Put req = new Put(this.baseUrl);
            String res = req.execute(payload);
            return res;
        } catch (MalformedURLException e) {
            return e.getMessage();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

}