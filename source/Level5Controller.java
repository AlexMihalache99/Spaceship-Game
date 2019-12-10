import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
	/**
	 * The controller class for the level 5 button.
	 * @author Muhammed Fawaz Sharif and Alexandru Mihalache
	 *
	 */
	public class Level5Controller {

		@FXML private Label  label;
		@FXML private Button showBtn;
		@FXML private Button backBtn;

	    /**
	     * Show the leader board when the button is pressed.
	     * @param event event handler
	     */
	    public void showButton(ActionEvent event) {
	    	BufferedReader br = null;

    	    String line = null;

    	    try {
    	    	br = new BufferedReader(new FileReader("leaderboard5.txt"));
    	    	while((line = br.readLine()) != null) {
    	    		 label.setText(label.getText() + "\n" +line);
    	    	}
    	    } catch (IOException e) {
    	    	e.printStackTrace();
    	    }

	    }


		/**
		 * Returns back to Leader board  scene when button is pressed
		 * @param event event handler
		 * @throws IOException
		 */
		public void backButton(ActionEvent event) throws IOException {
			Parent spv = FXMLLoader.load(getClass().getResource("LeaderBoardScene.fxml"));
			Scene selectProfileViewScene = new Scene(spv);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(selectProfileViewScene);
			window.show();
		}

}
