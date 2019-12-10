import javafx.scene.image.Image;

/**
 * Fire boots allows us to create a collectible item FireBoots
 * @author Alexandru Mihalache
 */
public class FireBoots extends CollectableItem {

	private Image image = new Image("images/fireboots.png");
	private Image image2 = new Image("images/groundCell.png");

  /**
   * Sets the position of the fire boots
   * @param position
   */
	public FireBoots(Position position) {
		super(position);
	}

  /**
   * gets the image of the fire boots
   * @return image The fireBoots.png file
   */
	public Image getInstanceImage() {
		return image;
	}

  /**
   * changes the image to draw the cell behind it also
   */
    public void changeImage() {
   		this.image = this.image2;
	}

}
