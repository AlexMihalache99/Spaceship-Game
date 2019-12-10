import javafx.scene.image.Image;

/**
 * This class represents a teleporter cell.
 * @author Alexandru Mihalache
 */
public class Teleporter extends Cell {
	private final static Image IMAGE = new Image("images/teleporter.png");
	private final Position tpLocation;

	/**
	 * Create a new teleporter cell on the given position.
	 * @param position The position of the teleporter cell.
	 * @param tpLocation The position of the connected teleporter.
	 */
	public Teleporter(Position position, Position tpLocation) {
		super(position);
		this.tpLocation = tpLocation;
	}

	/**
     * Get the image representing the teleporter cell.
     * @return The image representing the teleporter cell.
     */
	public static Image getImage() {
		return IMAGE;
	}

	/**
	 * Get the position of the connected teleporter.
	 * @return The position of the connected teleporter.
	 */
	public Position getTPLocation() {
		return this.tpLocation;
	}

}
