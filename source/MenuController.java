import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * The controller class for the main menu.
 * @author Muhammed Fawaz Sharif and Alexandru Mihalache
 *
 */
public class MenuController {

	@FXML private AnchorPane rootPane;
	@FXML private Button playBtn;
	@FXML private Button selectProfileBtn;
	@FXML private Button leaderboardBtn;
	@FXML private Button exitBtn;
	@FXML private Button MusicBtn;
	@FXML private Label messageOfTheDay;

	/**
	 * Intialises the FXMl
	 * @throws IOException
	 **/
	public void initialize() throws IOException {
		messageOfTheDay.setText(MessageOfTheDay.retrieveMessage().toString());
	}

	/**
	 * Starts a specified level if a profile is chosen, otherwise the game begins from level 1
	 * @throws IOException
	 **/
	public void playButton(ActionEvent event) throws IOException{
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		Level level = null;
		if(SelectProfileController.getUser() == null) {
			level = new Level(1,null);
		} else {
			level = new Level(SelectProfileController.getUser().getUserLevel() + 1, SelectProfileController.getUser());
		}

		level.start(window);
	}

	/**
	 * Opens Select profiles menu when button is clicked.
	 * @param event
	 * @throws IOException
	 */
	public void selectProfileButton(ActionEvent event) throws IOException {
		Parent selectProfileView = FXMLLoader.load(getClass().getResource("SelectprofileScene.fxml"));
		Scene selectProfileViewScene = new Scene(selectProfileView);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(selectProfileViewScene);
		window.show();

	}

	/**
	 * Opens LeaderBoard menu when button is clicked.
	 * @param event
	 * @throws IOException
	 */
	public void leaderboardButton(ActionEvent event) throws IOException{
		Parent leaderBoardView = FXMLLoader.load(getClass().getResource("LeaderBoardScene.fxml"));
		Scene  leaderBoardViewScene = new Scene (leaderBoardView);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(leaderBoardViewScene);
		window.show();

	}

	/**
	 * Shows the list of music, so the user can choose when the button is clicked.
	 * @param event
	 * @throws IOException
	 */
	public void MusicButton(ActionEvent event) throws IOException {
		Parent selectProfileView = FXMLLoader.load(getClass().getResource("ChooseMusicScene.fxml"));
		Scene selectProfileViewScene = new Scene(selectProfileView);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(selectProfileViewScene);
	    window.show();
	}


	/**
	 * Exits from the game.
	 * @param event
	 */
	public void exitButton(ActionEvent event) {
		Platform.exit();
	}
}
