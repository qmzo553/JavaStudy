import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Customer {

    private String name;
    private int points;
    private String profilePhotoUrl;

    public Customer(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public boolean hasOverHundredPoints() {
        return this.points > 100;
    }

    public String getName() {
        return this.name;
    }

    public int getPoints() {
        return this.points;
    }

    public boolean hasValidProfilePhoto() throws IOException {
        URL url = new URL(this.profilePhotoUrl);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        return connection.getResponseCode() == HttpURLConnection.HTTP_OK;
    }

    @Override
    public String toString() {
        return name + " " + points;
    }
}
