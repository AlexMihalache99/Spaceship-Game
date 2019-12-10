import javafx.scene.image.Image;

/**
 * A class representing the flippers.
 * @author Alexandru Mihalache
 */
public class Flippers extends CollectableItem {

	private Image image = new Image("images/flipper.png");
	private Image image2 = new Image("images/groundCell.png");

	/**
	 * Create new flippers on the given position.
	 * @param position The position of the flippers.
	 */
	public Flippers(Position position) {
		super(position);
	}

	/**
	 * Get the image representing the flippers.
	 * @return The image representing the flippers.
	 */
	public Image getInstanceImage() {
		return this.image;
	}

	/**
	 * Change the image representing the flippers.
	 */
	public void changeImage() {
		this.image = this.image2;
	}

}
