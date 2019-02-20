package services;

import java.net.MalformedURLException;
import java.io.IOException;

public class SaleService {

    private String baseUrl;

    public SaleService(String baseUrl) {
        this.baseUrl = baseUrl + "/sales";
    }

    public String getSales() {
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

    public String newSale(String payload) {
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
