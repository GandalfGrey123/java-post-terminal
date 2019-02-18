package services;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Post extends Request {


    public Post(String uri) throws MalformedURLException, IOException {
        super(uri);
        connection.setRequestMethod("POST");
    }

    public String execute() throws IOException {
        return this.execute("");
    }
    public String execute(String body) throws IOException {
        connection.setDoOutput(true);
        connection.getOutputStream().write(body.getBytes("UTF-8"));
        Response response = new Response(connection);
        connection.disconnect();
        if(response.getStatusCode() == 400){
            System.out.println("Getting Body");
//            return response.getBody();
            return Integer.toString(response.getStatusCode());
        }else{
            System.out.println("Getting Code");
            return Integer.toString(response.getStatusCode());
        }
    }




}
