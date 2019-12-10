import javafx.scene.image.Image;

/**
 * A super class for all types of enemies.
 * @author Alexandru Mihalache
 */
public abstract class Enemy extends MoveableEntity {

	private Image image;

	/**
	 * Create a new enemy on the given position.
	 * @param position The position of the enemy.
	 */
	public Enemy(Position position) {
		super(position);
	}

	/**
	 * Get the position of the player.
	 * @param player The player.
	 * @return The position of the player.
	 */
	public Position getPlayerPosition(Player player) {

		return player.getPosition();
	}

	/**
	 * Get the image representing the enemy.
	 * @return The image representing the enemy.
	 */
	public Image getImage() {
		return this.image;
	}

	/**
	 * Abstract method which will include implementation for
	 * sub class enemies to calculate their next move
	 * @param cells the level's cells
	 * @param playerPos the player's position
	 **/
	public abstract void nextMove(Cell[][] cells, Position playerPos);

}
