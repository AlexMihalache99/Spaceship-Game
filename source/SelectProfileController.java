import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * This class represents the 'Select Profile' option of the menu, which includes options
 * like creating or deleting a user profile, or returning to the main menu.
 * @author Muhammed Fawaz Sahrif  and Alexandru Mihalache
 */
public class SelectProfileController {
	private static UserProfile user = null;

	@FXML private AnchorPane rootPane;
	@FXML private Label label;
	@FXML private ComboBox<UserProfile> chooseProfile;
	@FXML private Button deleteProfilesBtn;
	@FXML private Button saveBtn;
	@FXML private TextField textField;
	@FXML private Button backBtn;


	/**
	 * This method is called automatically and initialises the fxml
	 * @throws IOException
	 */
	public void initialize() throws IOException {
		ProfileManager.loadData(chooseProfile);
	}

	/**
	 * Sets the selected profile to the profile specified
	 * @param user the selected userProfile
	 **/
	public void setUser(UserProfile user){
		SelectProfileController.user = user;
	}

	/**
	 * Returns user
	 * @return UserProfile - the selected userProfile
	 **/
	public static UserProfile getUser(){
		return SelectProfileController.user;
	}


	/**
	 * Choose an existing profile when the button is clicked.
	 * @param event
	 * @throws IOException
	 */
	public void chooseProfileButton(ActionEvent event) throws IOException {
		setUser(chooseProfile.getValue());

	}

	/**
	 * Create a new profile when the button is clicked.
	 * @param event
	 * @throws Exception
	 */
	public void saveButton(ActionEvent event) throws IOException {
		UserProfile user = new UserProfile(textField.getText());
		ProfileManager.addToProfileData(user);
		chooseProfile.getItems().clear();
		ProfileManager.loadData(chooseProfile);
	}

	/**
	 * Delete the profiles when the button is clicked.
	 * @param event
	 */
	public void deleteProfilesButton(ActionEvent event) {
		ProfileManager.deleteData();
		label.setText("Profiles Have Been Deleted!");


	}

	/**
	 * Return to main menu when the button is pressed.
	 * @param event
	 * @throws IOException
	 */
	public void backButton(ActionEvent event) throws IOException {
		Parent mainView = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene mainViewScene = new Scene(mainView);

		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

		window.setScene(mainViewScene);
		window.show();
	}
}
