import javafx.scene.image.Image;

/**
 * A super class for cells and acts as the ground cell.
 * @author William Bampton
 */
public class Cell {

    private  Position position;
    private  final static Image IMAGE = new Image("images/groundCell.png");


  /**
   * Create a new cell.
   * @param position The position of the cell.
   */
  public Cell(Position position){
        this.position = position;
    }

  /**
   * Gets the position of a cell
   * @return position
   */
  public Position getPosition() {
      return position;
    }

  /**
   * Sets the position of a cell
   * @param position
   */
  public void setPosition(Position position) {
      this.position = position;
    }

  /**
   * Gets the opened image.
   * @return IMAGE
   */
  public static Image getImage() {
      return IMAGE;
    }

}
