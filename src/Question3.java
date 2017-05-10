import java.net.HttpURLConnection;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question3 {

	// makes a call to http://www.thomas-bayer.com/sqlrest/CUSTOMER/ and displays the response status code and response body. 
	public static void main(String[] args) {
		try {
			// Send GET request to http://www.thomas-bayer.com/sqlrest/CUSTOMER/
			URL targetUrl = new URL("http://www.thomas-bayer.com/sqlrest/CUSTOMER/");
			HttpURLConnection targetConnection = (HttpURLConnection) targetUrl.openConnection();
			targetConnection.setRequestMethod("GET");
			// Display Response Code
			System.out.println("System Response Code: " + targetConnection.getResponseCode());
			// Display Response Body
			System.out.println("Response Body:");
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					(targetConnection.getInputStream())));
			String output;
			// Display each line from response, until line is null
			while ((output = reader.readLine()) != null) {
				System.out.println(output);
			}
			// Close connection
			targetConnection.disconnect();
		} catch (MalformedURLException exception) {
		} catch (IOException exception) {
		}
	}

}
