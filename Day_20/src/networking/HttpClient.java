package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {

  public static void main(String[] args) throws IOException {
    String urlString = "https://www.google.co.in/"; // Replace with your desired URL

    // Create a URL object
    URL url = new URL(urlString);

    // Open a connection
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

    // Set request method (GET by default)
    connection.setRequestMethod("GET");

    // Connect to the server
    connection.connect();

    // Get response code
    int responseCode = connection.getResponseCode();

    // Print response headers
    System.out.println("Response Code: " + responseCode);
    System.out.println("Response Headers:");
    for (String headerName : connection.getHeaderFields().keySet()) {
      System.out.println(headerName + ": " + connection.getHeaderField(headerName));
    }
    System.out.println();

    // Print response body (if successful)
    if (responseCode >= 200 && responseCode < 300) {
      BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
      reader.close();
    } else {
      System.out.println("Error: HTTP response code " + responseCode);
    }

    // Disconnect
    connection.disconnect();
  }
}
