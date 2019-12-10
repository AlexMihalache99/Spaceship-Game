/**
 * A superclass representing a movable entity.
 * @author Marios Alexandros Butler
 */
public class MoveableEntity {
	protected Position position;

	/**
	 * Create a moveable entity.
	 * @param position The position of the moveable entity.
	 */
	public MoveableEntity(Position position) {
		this.position = position;
	}

	/**
	 * Change the position of the entity.
	 * @param row The row.
	 * @param col The column.
	 */
	public void setPosition(int row, int col) {
		this.position.setRow(row);
		this.position.setCol(col);
	}

	/**
	 * Get the position of the entity.
	 * @return Position The position of the entity.
	 */
	public Position getPosition() {
		return this.position;
	}

}
