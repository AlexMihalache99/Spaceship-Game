import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 * This class represents a player.
 * @author Muhammed Fawaz, Alexandru Mihalache and William Bampton
 */
public class Player extends MoveableEntity {
	private int tokenCount;
	private ArrayList<String> keys = new ArrayList<String>();
	private boolean fireBoots;
	private boolean flippers;
	private static Image image = new Image("images/player.png");

	/**
	 * Create a new player.
	 * @param position The position in which the player will spawn.
	 */
    public Player(Position position) {
		super(position);
	}

	/**
	 * Check if the player's attempted move towards a certain cell is valid or not.
	 * @param cell The cell.
	 * @return True or false.
	 */
	public boolean isMoveValid(Cell cell){
		if(cell instanceof CollectableItem) {
			addItem(cell);
			return true;
		} else if (cell instanceof Wall) {
			return false;

		} else if (cell instanceof TokenDoor) {
			TokenDoor tempCell = (TokenDoor) cell;
			if(tempCell.getTokens() == this.tokenCount) {
				tempCell.changeImage();
			}
			return (tempCell.getTokens() == this.tokenCount);
		} else if (cell instanceof ColourDoor) {
			ColourDoor tempCell = (ColourDoor) cell;
			if(keys.contains(tempCell.getColour())) {
				tempCell.changeImage();
			}
			return (keys.contains(tempCell.getColour()));
		} else if(cell instanceof Teleporter) {
			Teleporter tempCell = (Teleporter) cell;
			this.position.setRow(tempCell.getTPLocation().getRow());
			this.position.setCol(tempCell.getTPLocation().getCol());
			return true;
		}else {
			return true;
		}
	}

	/**
	 * Add a collectable item to the player's inventory.
	 * @param cell The cell.
	 */
	private void addItem(Cell cell){
		CollectableItem collectable = (CollectableItem) cell;
		if(!collectable.getWasCollected()) {
			if(cell instanceof FireBoots){
				this.fireBoots = true;
			} else if(cell instanceof Flippers) {
				this.flippers = true;
			} else if (cell instanceof Token) {
				this.tokenCount++;
			} else if (cell instanceof Key) {
				Key tempCell = (Key) cell;
				this.keys.add(tempCell.getColour());
			}
			collectable.changeImage();
		}
	}

	/**
	 * Get the image representing the player.
	 * @return The image representing the player.
	 */
	public static Image getImage(){
		return image;
	}

	public static void setImage(String file){
		Player.image = new Image(file);
	}
	/**
	 * Get the number of tokens the player has at the moment.
	 * @return tokenCount The number of tokens.
	 */
	public int getTokenCount() {
		return tokenCount;
	}

	/**
	 * Set the number of tokens the player has at the moment.
	 * @param tokenCount The number of tokens.
	 */
	public void setTokenCount(int tokenCount) {
		this.tokenCount = tokenCount;
	}

	/**
	 * Return a boolean value based on whether the player is wearing fire boots or not.
	 * @return True or false.
	 */
	public boolean isFireBoots() {
		return fireBoots;
	}

	/**
	 * Adds or removes fire boots from the player's inventory.
	 * @param fireBoots True: Adds fire boots. False: Removes fire boots.
	 */
	public void setFireBoots(boolean fireBoots) {
		this.fireBoots = fireBoots;
	}

	/**
	 * Return a boolean value based on whether the player is wearing flippers or not.
	 * @return True or false.
	 */
	public boolean isFlippers() {
		return flippers;
	}

	/**
	 * Adds or removes flippers from the player's inventory.
	 * @param flippers True: Adds flippers. False: Removes flippers.
	 */
	public void setFlippers(boolean flippers) {
		this.flippers = flippers;
	}
}
