package services;

import java.io.IOException;
import java.net.MalformedURLException;

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
        connection.get
        connection.getOutputStream().write(body.getBytes("UTF-8"));
        Response response = new Response(connection);
        connection.disconnect();
        return response.getBody();
    }

}
