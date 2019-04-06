package model.product.repository;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class NBPRepository {

    private final static String BASE_REQUEST_URL="http://api.nbp.pl/api/exchangerates/tables/c";
    private final HttpClient httpClient;

    public NBPRepository() {
        this.httpClient = HttpClients.createDefault();
    }

    public String getResponse() {
        HttpGet httpGet = new HttpGet(BASE_REQUEST_URL);
        try {
            HttpResponse response = httpClient.execute(httpGet);
           Scanner s = new Scanner(response.getEntity().getContent()).useDelimiter("\\A");
           return s.hasNext() ? s.next() : "";
          //  String jsonAsString = s.hasNext() ? s.next() : "";

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
