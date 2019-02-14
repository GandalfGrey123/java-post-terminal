package services;

import java.net.MalformedURLException;
import java.io.IOException;

public class Sale {

    String baseUrl = "http://localhost:3000/sales";

    Sale() {
    }

    String getSales() {
        try {
            Get req = new Get(baseUrl);
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
            Put req = new Put(baseUrl);
            String res = req.execute(payload);
            return res;
        } catch (MalformedURLException e) {
            return e.getMessage();
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}