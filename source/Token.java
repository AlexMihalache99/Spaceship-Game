import javafx.scene.image.Image;

/**
 * This class represents a token.
 * @author Alexandru Mihalache
 */
public class Token extends CollectableItem{
	private Image image = new Image("images/token.png");
	private Image image2 = new Image("images/groundCell.png");

	/**
	 * Create a new token on the given position.
	 * @param position The position of the token.
	 */
	public Token(Position position) {
		super(position);
	}

	/**
	 * Get the image representing the token.
	 * @return The image representing the token.
	 */
	public Image getInstanceImage() {
		return this.image;
	}

	/**
	 * Change the image representing the token.
	 */
	public void changeImage() {
	  	this.image = this.image2;
	}


}
