package Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Test2Demo {

	public static void main(String[] args) {
		try {

			URL url = new URL("https://ap4.force.com/services/apexrest/purchaseitem");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty ("Authorization", "Bearer 00D6F000002JJ62!ASAAQFIABUYsutPu8ZoMzVXvSqolUXJ6ZotFCnx3GkJFD1F0LmLcCW1ziaThUGQSIUFwsOhtlVefC5Pog5bm1o8c3XU4yqMR");

			String input = "{\"data\": [{ \"memberIdExternal\" : \"Ext-10000060\", \"purchaseMerchant\" : \"Cath Kidson\", \"purchaseAmount\" : \"121212\"}]}";

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		 }

	}

}
