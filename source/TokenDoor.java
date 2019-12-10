import javafx.scene.image.Image;

/**
 * This class represents a token door cell.
 * @author William Bampton
 */
public class TokenDoor extends Cell{
    private int tokens;
    private Image image;
    private static Image image2 = new Image("images/groundCell.png");

    /**
     * Create a new token door cell on the given position,
     * which requires a specified amount of tokens to open.
     * @param position The position of the token door.
     * @param tokens The amount of tokens needed to open the token door.
     */
    public TokenDoor(Position position, int tokens){
        super(position);
        this.tokens = tokens;
        if(this.tokens == 1) {
        	image = new Image("images/door1.png");
        }else if(this.tokens == 2) {
        	image = new Image("images/door2.png");
        }else {
        	image = new Image("images/door3.png");
        }
    }

    /**
     * Get the number of tokens needed to open the token door.
     * @return The amount of tokens.
     */
    public int getTokens() {
    	return tokens;
    }

    /**
     * Change the image representing the token door.
     */
    public void changeImage() {
   	   this.image = TokenDoor.image2;
    }

    /**
     * Get the image representing the token door.
     * @return The image representing the token door.
     */
    public Image getInstanceImage() {
    	return this.image;
    }
}
