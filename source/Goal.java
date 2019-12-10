import javafx.scene.image.Image;

/**
 * Crεates the goal cell, the finish point.
 * @author Muhammed Fawaz Sharif
 */
public class Goal extends Cell {

	private final static Image IMAGE = new Image("images/goal.png");

	/**
	 * Sets the position where the goal is placed.
	 * @param pos
	 */
	public Goal(Position position) {
		super(position);
	}

	/**
	 * Returns the image of the goal cell, a checkered flag.
	 * @return IMAGE , goal.png image
	 */
	public static Image getImage() {
		return IMAGE;
	}

}
