import javafx.scene.image.Image;

/**
 * This class represents a key.
 * @author Alexandru Mihalache
 */
public class Key extends CollectableItem {
	private Image image;
	private Image image2 = new Image("images/groundCell.png");
	private String colour;

	/**
	 * Create a new key on the given position.
	 * @param position The position of the key.
	 * @param colour The colour of the key.
	 */
	public Key(Position position, String colour) {
		super(position);
		this.colour = colour;

		//sets the correct image based on colour
		if (this.colour.equals("red")) {
			image = new Image("images/redkey.png");
		} else if (this.colour.equals("blue")) {
			image = new Image("images/bluekey.png");
		} else {
			image = new Image("images/greenkey.png");
		}
	}

	/**
	 * Set the colour of the key.
	 * @param colour The new colour.
	 */
	public void setColour(String colour) {
		this.colour = colour;
	}

	/**
	 * Get the colour of the key.
	 * @return The colour of the key.
	 */
	public String getColour() {
		return this.colour;
	}

	/**
	 * Get the image representing the key.
	 * @return The image representing the key.
	 */
	public Image getInstanceImage() {
		return image;
	}

	/**
	 * Change the image representing the key.
	 */
	public void changeImage() {
		this.image = this.image2;
	}

}
