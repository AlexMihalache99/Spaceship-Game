import javafx.scene.image.Image;

/**
 * This class represents one of the four enemies, the Straight Line Enemy.
 * @author Alexandru Mihalache
 */
public class StraightLineEnemy extends Enemy {
	private final Image image = new Image("images/straightLineEnemy.png");
	private String direction;

	/**
	 * Create a new Straight Line Enemy.
	 * @param position  The position in which the enemy will spawn.
	 * @param direction The direction the enemy is moving to.
	 */
	public StraightLineEnemy(Position position, String direction) {
		super(position);
		this.direction = direction;
	}

	/**
	 * Get the image representing the Straight Line Enemy.
	 * @return The image representing the Straight Line Enemy.
	 */
	public Image getImage() {
		return this.image;
	}

	/**
	 * Set the new direction of the Straight Line Enemy.
	 * @param direction The direction the enemy is moving to.
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}

	/**
	 * Get the direction of the Straight Line Enemy.
	 * @return The direction the enemy is moving to.
	 */
	public String getDirection() {
		return this.direction;
	}

	/**
	 * Decide on the next move of the enemy.
	 * @param cells An array of the cells.
	 * @param playerPosition The player's position.
	 */
	public void nextMove(Cell[][] cells, Position playerPosition) {
		if (this.direction.equals("left")) {/// player moves from right to left

			if (cells[this.getPosition().getRow()][this.getPosition().getCol() - 1] instanceof Wall) {
				this.setDirection("right");
				this.setPosition(this.getPosition().getRow(), this.getPosition().getCol() + 1);
			} else {
				this.setPosition(this.getPosition().getRow(), this.getPosition().getCol() - 1);
			}

		} else if (this.direction.equals("right")) {/// player moves from left to right

			if (cells[this.getPosition().getRow()][this.getPosition().getCol() + 1] instanceof Wall) {
				this.setDirection("left");
				this.setPosition(this.getPosition().getRow(), this.getPosition().getCol() - 1);
			} else {
				this.setPosition(this.getPosition().getRow(), this.getPosition().getCol() + 1);
			}

		} else if (this.direction.equals("up")) {/// player moves from down to up

			if (cells[this.getPosition().getRow() - 1][this.getPosition().getCol()] instanceof Wall) {
				this.setDirection("down");
				this.setPosition(this.getPosition().getRow() + 1, this.getPosition().getCol());
			} else {
				super.setPosition(super.getPosition().getRow() - 1, super.getPosition().getCol());
			}

		} else if (this.direction.equals("down")) {/// enemy moves from up to down

			if (cells[super.getPosition().getRow() + 1][super.getPosition().getCol()] instanceof Wall) {
				this.setDirection("up");
				this.setPosition(this.getPosition().getRow() - 1, this.getPosition().getCol());
			} else {
				super.setPosition(super.getPosition().getRow() + 1, super.getPosition().getCol());

			}

		}
	}

}
