import javafx.scene.image.Image;

/**
 * This class represents a coloured door.
 * @author Chris Gibson
 */
public class ColourDoor extends Cell {
  private String colour;
  private Image image;
  private static Image image2 = new Image("images/groundCell.png");

  /**
   * Create a new coloured door on the given position with a specified colour.
   * @param position The position of the coloured door.
   * @param colour The colour of the coloured door.
   */
  public ColourDoor(Position position, String colour) {
    super(position);
    this.colour = colour;
    if (this.colour.equals("red")) {
      image = new Image("images/redDoor.png");
    } else if (this.colour.equals("blue")) {
      image = new Image("images/blueDoor.png");
    } else {
      image = new Image("images/greenDoor.png");
    }
  }

  /**
   * Gets the colour of the door that is to be placed
   * @return the colour
   */
  public String getColour() {
    return colour;
  }

  /**
   * Changes the cell image when a door is opened
   */
  public void changeImage() {
    this.image = ColourDoor.image2;
  }

  /**
   * Gets the type of door that needs to be displayed
   * @return this.image The image of the door
   */
  public Image getInstanceImage() {
    return this.image;
  }

}
