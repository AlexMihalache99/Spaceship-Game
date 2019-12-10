import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * The controller class for the leaderboard menu.
 * @author Muhammed Fawaz sharif and Alexandru Mihalache
 */
public class LeaderboardController {
	@FXML AnchorPane rootPane;
	@FXML Button level1Btn;
	@FXML Button level2Btn;
	@FXML Button level3Btn;
	@FXML Button level4Btn;
	@FXML Button level5Btn;
	@FXML Button backBtn;

	/**
	 * Opens new scene containing leaderBoard information
	 * @param event
	 * @throws IOException
	 */
	public void level1Button(ActionEvent event) throws IOException {
		Parent lv1View = FXMLLoader.load(getClass().getResource("Level1Scene.fxml"));
		Scene lv1ViewScene = new Scene(lv1View);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(lv1ViewScene);
		window.show();
	}

	/**
	 * Opens new scene containing leaderBoard information
	 * @param event
	 * @throws IOException
	 */
	public void level2Button(ActionEvent event) throws IOException {
		Parent lv2View = FXMLLoader.load(getClass().getResource("Level2Scene.fxml"));
		Scene lv2ViewScene = new Scene(lv2View);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(lv2ViewScene);
		window.show();


	}
	/**
	 * Opens new scene containing leaderBoard information
	 * @param event
	 * @throws IOException
	 */
	public void level3Button(ActionEvent event) throws IOException {
		Parent lv3View = FXMLLoader.load(getClass().getResource("Level3Scene.fxml"));
		Scene lv3ViewScene = new Scene(lv3View);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(lv3ViewScene);
		window.show();


	}

	/**
	 * Opens new scene containing leaderBoard information
	 * @param event
	 * @throws IOException
	 */
	public void level4Button(ActionEvent event) throws IOException {
		Parent lv4View = FXMLLoader.load(getClass().getResource("Level4Scene.fxml"));
		Scene lv4ViewScene = new Scene(lv4View);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(lv4ViewScene);
		window.show();


	}

	/**
	 * Opens new scene containing leaderBoard information
	 * @param event
	 * @throws IOException
	 */
	public void level5Button(ActionEvent event) throws IOException {
		Parent lv5View = FXMLLoader.load(getClass().getResource("Level5Scene.fxml"));
		Scene lv5ViewScene = new Scene(lv5View);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(lv5ViewScene);
		window.show();


	}

	/**
	 * Returns to main menu when button is pressed
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
