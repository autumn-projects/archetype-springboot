import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GracefulShutdown {

    public static void main(String[] args) {
        try {
            URL url = new URL(" http://localhost:10212/actuator/shutdown");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");

            InputStream is = connection.getInputStream();
            System.out.println(is);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
