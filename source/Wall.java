import javafx.scene.image.Image;

/**
 * This class represents a wall cell.
 * @author Alexandru Mihalache
 */
public class Wall extends Cell{
	private final static Image IMAGE = new Image("images/wall.png");

   /**
    * Create a new wall cell on the given position.
    * @param position The position of the wall cell.
    */
   public Wall(Position position){
    super(position);
   }

   /**
	 * Get the image representing the wall cell.
	 * @return The image representing the token door.
	 */
   public static Image getImage() {
	return IMAGE;
   }

}
