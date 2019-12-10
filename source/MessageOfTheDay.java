import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
* Retrieves the message of the day from the web server
*
* @author Chris Gibson
*/
public class MessageOfTheDay {

	public static String solvePuzzle() throws IOException {

		URL puzzleURL = new URL("http://cswebcat.swan.ac.uk/puzzle");
		HttpURLConnection connection = (HttpURLConnection) puzzleURL
				.openConnection();

		connection.setRequestMethod("GET");
		// To store our response
		StringBuilder puzzleString = null;

		// Get the input stream of the connection
		try (BufferedReader input = new BufferedReader(
				new InputStreamReader(connection.getInputStream()))) {
			String line;
			puzzleString = new StringBuilder();
			while ((line = input.readLine()) != null) {
				// Append each line of the response and separate them
				puzzleString.append(line);
			}
		} catch (IOException e) {
			System.out.println("Cannot connect. Invalid URL? ");
		} finally {
			connection.disconnect();
		}
		for (int i = 0; i <= puzzleString.length() - 1; i++) {
			if (i % 2 == 0) {
				if (puzzleString.charAt(i) - 90 == 0) {
					puzzleString.setCharAt(i, 'A');
				} else {
					puzzleString.setCharAt(i,
							(char) (puzzleString.charAt(i) + 1));
				}
			} else {
				if (puzzleString.charAt(i) - 65 == 0) {
					puzzleString.setCharAt(i, 'Z');
				} else {
					puzzleString.setCharAt(i,
							(char) (puzzleString.charAt(i) - 1));
				}

			}

		}

		String solutionURL = "http://cswebcat.swan.ac.uk/message?solution="
				+ puzzleString;
		return solutionURL;
	}

	public static StringBuilder retrieveMessage() throws IOException {
		URL puzzleURL = new URL(solvePuzzle());
		HttpURLConnection connection = (HttpURLConnection) puzzleURL
				.openConnection();

		connection.setRequestMethod("GET");

		StringBuilder message = null;
		try (BufferedReader input = new BufferedReader(
				new InputStreamReader(connection.getInputStream()))) {
			String line;
			message = new StringBuilder();
			while ((line = input.readLine()) != null) {
				message.append(line);
			}
		} catch (IOException e) {
			System.out.println("Cannot connect. Invalid URL? ");
		} finally {
			connection.disconnect();
		}


	    if(message.length() > 80 && message.length() < 160) {
	    	String msg = message.substring(0 , 80) + "\n" + message.substring(80, message.length());
	    	message.delete(0, message.length());
	    	message.append(msg);
	    }else if(message.length() > 160) {
	    	String msg = message.substring(0, 80) + "\n" + message.substring(80, 160) + "\n";
	    	String msg1 = message.substring(160, message.length());
	    	message.delete(0, message.length());
	    	message.append(msg);
	    	message.append(msg1);
	    }
		return message;
	}

}
