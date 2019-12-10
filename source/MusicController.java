import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * This is the controller class for the music menu.
 * @author Muhammed Fawaz Sharif and Alexandru Mihalache
 */

public class MusicController {
	@FXML
	private Button button1;
	@FXML
	private Button button2;
	@FXML
	private Button button3;
	@FXML
	private Button button4;
	@FXML
	private Button button5;
	@FXML
	private Button button6;

	private MediaPlayer mediaPlayer;

	/**
	 * Plays music when the button is clicked.
	 * @param event
	 */
	public void button1(ActionEvent event) {
		String musicFile = "Duck Dodgers intro.mp4";
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	}

	/**
	 * Plays music when the button is clicked.
	 * @param event
	 */
	public void button2(ActionEvent event) {
		String musicFile2 = "Song 2.mp3";
		Media sound2 = new Media(new File(musicFile2).toURI().toString());
		mediaPlayer = new MediaPlayer(sound2);
		mediaPlayer.play();
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

	}

	/**
	 * Plays music when the button is clicked.
	 * @param event
	 */
	public void button3(ActionEvent event) {
		String musicFile3 = "Song 3.mp3";
		Media sound3 = new Media(new File(musicFile3).toURI().toString());
		mediaPlayer = new MediaPlayer(sound3);
		mediaPlayer.play();
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

	}

	/**
	 * Plays music when the button is clicked.
	 * @param event
	 */
	public void button4(ActionEvent event) {
		String musicFile4 = "Song 4.mp3";
		Media sound4 = new Media(new File(musicFile4).toURI().toString());
		mediaPlayer = new MediaPlayer(sound4);
		mediaPlayer.play();
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

	}

	/**
	 * Plays music when the button is clicked.
	 * @param event
	 */
	public void button5(ActionEvent event) {
		String musicFile5 = "Song 5.mp3";
		Media sound5 = new Media(new File(musicFile5).toURI().toString());
		mediaPlayer = new MediaPlayer(sound5);
		mediaPlayer.play();
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

	}

	/**
	 * Plays music when the button is clicked.
	 * @param event
	 */
	public void button6(ActionEvent event) {
		String musicFile6 = "Song 6.mp3";
		Media sound6 = new Media(new File(musicFile6).toURI().toString());
		mediaPlayer = new MediaPlayer(sound6);
		mediaPlayer.play();
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

	}

	/**
	 * Returns back to main menu.
	 * @param event
	 * @throws IOException
	 */
	public void backButton(ActionEvent event) throws IOException {
		Parent mainView = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene mainViewScene = new Scene(mainView);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(mainViewScene);
		window.show();

	}

}
