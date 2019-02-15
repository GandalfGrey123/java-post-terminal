package services;

import java.net.MalformedURLException;
import java.io.IOException;

public class Sale {

    String baseUrl;

    Sale(String baseUrl) {
        this.baseUrl = baseUrl + "/sales";
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

    String newSale(String payload) {
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