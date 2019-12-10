import javafx.scene.image.Image;

/**
 * This class represents a water cell.
 * @author Muhammed Fawaz Sharif
 * */
public class Water extends Cell {
	private final static Image IMAGE = new Image("images/water.png");
	private static boolean enemyWall = true;

	/**
	 * Create a new water cell on the given position.
	 * @param position The position of the water cell.
	 */
	public Water(Position position) {
	  super(position);
	}

	/**
	 * Get the image representing the water cell.
	 * @return The image representing the water cell.
	 */
	public static Image getImage() {
	  return IMAGE;
	}


}
