import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.scene.control.ComboBox;

/**
 * Manages the incoming of new users and reads/adds to and from the users database.
 * @author Muhammed Fawaz Sharif
 */
public class ProfileManager {
	private static final String USER_DATA = "UserProfiles.txt";
	private static ArrayList<UserProfile> userProfiles = new ArrayList<UserProfile>();

	/**
	 * Loads the data from the UserProfileData.txt file and
	 * imports into a readable ArrayList 'users'.
	 * @throws IOException
	 */
	public static void loadData(ComboBox<UserProfile> comboBox) throws IOException {

		File inputFile = new File(USER_DATA);
		BufferedReader in = null;
		int bufferSize = 8*1024;

		try {
			in = new BufferedReader(new FileReader(inputFile), bufferSize);
			String line = "";

		    while((line = in.readLine()) != null) {

				String [] items = line.split(",");

				String name  = items[0];
				String score = items[1];
				String level = items[2];
				String skin  = items[3];

				UserProfile user = new UserProfile(name);
				user.setHiScore(Integer.parseInt(score));
				user.setUserLevel(Integer.parseInt(level));
				user.setSkin(skin);

				comboBox.getItems().add(user);
			}

		} catch(IOException e) {
			e.printStackTrace();
		}
		in.close();
	}

	/**
	 * Populates the userProfiles arraylist with all of the users stored
	 **/
	public static void populateUserProfiles(){
		userProfiles.clear();
		File inputFile = new File(USER_DATA);
		BufferedReader in = null;
		int bufferSize = 8*1024;

		try {
			in = new BufferedReader(new FileReader(inputFile), bufferSize);
			String line = "";

		    while((line = in.readLine()) != null) {
				String [] items = line.split(",");
				UserProfile user = new UserProfile(items[0]);
				user.setHiScore(Integer.parseInt(items[1]));
				user.setUserLevel(Integer.parseInt(items[2]));
				user.setSkin(items[1]);

				boolean updated = false;
				for(int i = 0; i < ProfileManager.userProfiles.size(); i++){
					if(user.getName() == userProfiles.get(i).getName()) {
						userProfiles.set(i, user);
						updated = true;
					}
				}

				if(!updated) {
					ProfileManager.userProfiles.add(user);
				}

			}
		} catch(Exception e) {

		}
	}

	/**
	 * Adds a new user to the data to be stored.
	 * @param user the user to be stored.
	 */
	public static void addToProfileData(UserProfile user) {
		populateUserProfiles();
		System.out.println(user.getName());
		if (!checkExist(user.getName())) {
			saveData(user);
		} else {
			System.out.println("\nERROR: Username already exists.\n");
		}

	}

	/**
	 * Saves the ArrayList of users into the database to update the file.
	 * It then calls loadData() so the ArrayList can be used immediately after saving.
	 */
	public static void saveData(UserProfile user) {

		File database = new File(USER_DATA);
		PrintWriter out = null;

		try {
			out = new PrintWriter(new FileOutputStream(database, true));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		out.println(user);
		out.close();
	}

	/**
	 * Delete profiles from the array.
	 */
	public static void deleteData() {
		clearProfileDatabFile();
		for(int i = 0; i < userProfiles.size(); i++) {
			userProfiles.remove(i);
		}
	}

	/**
	 * Clear the UserProfileData file, ready for writing.
	 */
	public static void clearProfileDatabFile() {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(USER_DATA);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		writer.print("");
		writer.close();
	}

	/**
	 * Return true if the userName exists in the UserProfileData; if not, then false.
	 * @param user To be compared against array
	 * @return Boolean - true if exists already; false if not.
	 */
	public static boolean checkExist(String user) {
		for (int i = 0; i < userProfiles.size(); i++) {
			if (user.equals(userProfiles.get(i).getName())) {
				return true;
			}
		}
		return false;
	}


	/**
	 * Return the user based on the given username.
	 * @param username Username of the user.
	 * @return User - User with the username.
	 */
	public static UserProfile getUser(String username) {
		for (int i = 0; i < userProfiles.size(); i++) {
			if (username.equals(userProfiles.get(i).getName())) {
				return userProfiles.get(i);
			}
		}
		return null;
	}
}
