import javafx.scene.image.Image;

/**
 * A super class of all the collectable items.
 * @author Alexandru Mihalache
 */

public class CollectableItem extends Cell {
	private Image image;
	private static Image image2 = new Image("images/groundCell.png");
	private boolean wasCollected;

	/**
	 * Create a new collectable item on the given position.
	 * @param position The position of the collectable item.
	 */
	public CollectableItem(Position position) {
		super(position);
	}

	/**
	 * Change the image representing the collectable item.
	 */
	public void changeImage() {
		this.image = CollectableItem.image2;
	}

	/**
	 * Set the boolean value of wasCollected.
	 * @param wasCollected The new value of wasCollected.
	 */
	public void setWasCollected(boolean wasCollected) {
		this.wasCollected = wasCollected;
	}

	/**
	 * Get the boolean value of wasCollected.
	 * @return True or false.
	 */
	public boolean getWasCollected() {
		return this.wasCollected;
	}

}
