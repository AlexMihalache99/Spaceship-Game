import javafx.scene.image.Image;

/**
 * The dumb enemy class, moves towards the player but if there is a wall it
 * will get stuck
 * @author William Bampton
 */
public class DumbEnemy extends Enemy{

   private final Image image = new Image("images/dumbEnemy.png");

   /**
   * Dumb enemy initial position
   * @param position
   */
    public DumbEnemy(Position position){
        super(position);
    }

  /**
   * Gets the graphical image for the enemy
   * @return this.image
   */
    public Image getImage() {
    	return this.image;
    }

  /**
   * Computes the dumb enemies next move towards the player
   * Moves up if player is above and vice versa
   * Moves left if player is to the left and vice versa
   * This doesn't take into account walls just gets stuck
   * @param cells
   * @param playerPos
   */
  public void nextMove(Cell[][] cells, Position playerPos){
        if(playerPos.getRow() > this.position.getRow()) {
            Cell cell = cells[this.position.getRow()+1][this.position.getCol()];
            if(!(cell instanceof Wall)) {
                this.position.setRow(this.position.getRow()+1);
            }

        } else if (playerPos.getRow() < this.position.getRow()) {
            Cell cell = cells[this.position.getRow()-1][this.position.getCol()];
            if(!(cell instanceof Wall)) {
                this.position.setRow(this.position.getRow()-1);
            }

        }else if(playerPos.getCol() > this.position.getCol()) {
            Cell cell = cells[this.position.getRow()][this.position.getCol()+1];
            if(!(cell instanceof Wall)) {
                this.position.setCol(this.position.getCol()+1);
            }

        } else if (playerPos.getCol() < this.position.getCol()) {
            Cell cell = cells[this.position.getRow()][this.position.getCol()-1];
            if(!(cell instanceof Wall)) {
                this.position.setCol(this.position.getCol()-1);
            }

        }
    }
}
