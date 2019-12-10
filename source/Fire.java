import javafx.scene.image.Image;

/**
 * A class representing the fire cell.
 * @author Muhammed Fawaz Sharif
 */
public class Fire extends Cell {

	private final static Image IMAGE = new Image("images/fire.png");

	/**
	 * Create a new fire cell on the given position.
	 * @param position The position of the fire cell.
	 */
	public Fire(Position position) {
		super(position);
	}

	/**
	 * Get the image representing the fire cell.
	 * @return The image representing the fire cell.
	 */
	public static Image getImage() {
		return IMAGE;
	}

}
