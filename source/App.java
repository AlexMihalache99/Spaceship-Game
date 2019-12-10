import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class runs the main menu where the game can be played from, profile
 * creation, playing music and viewing the level.
 * @author Fawaz Sharif and Alexandru Mihalache
 */

public class App extends Application{

  /**
   * Main method to run app
   * @param args
   */
	public static void main(String [] args) {
		launch(args);
	}

  /**
   * Creates a window of h:450 and w:450
   * Shows the title of the game
   * @param primaryStage
   * @throws Exception
   */
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene scene = new Scene(root, 450, 450);

		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.setTitle("SpaceShip");
		primaryStage.show();
	}




}
