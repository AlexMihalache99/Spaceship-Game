import javafx.scene.image.Image;

/**
 * This class represents one of the four enemies, the Wall Following Enemy.
 * @author Alexandru Mihalache
 */
public class WallFollowingEnemy extends Enemy {
	private final Image image = new Image("images/wallFollowingEnemy.png");
	private String direction;

	/**
	 * Create a new Wall Following Enemy.
	 * @param position The position in which the enemy will spawn.
	 * @param direction The direction the enemy is moving to.
	 */
    public WallFollowingEnemy (Position position, String direction) {
        super(position);
        this.direction = direction;
    }

	/**
	 * Get the image representing the Wall Following Enemy.
	 * @return The image representing the Wall Following Enemy.
	 */
    public Image getImage() {
    	return this.image;
    }

	/**
	 * Set the new direction of the Wall Following Enemy.
	 * @param direction The direction the enemy is moving to.
	 */
    public void setDirection(String direction) {
     this.direction = direction;
    }

	/**
	 * Get the direction of the Wall Following Enemy.
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
    public void nextMove (Cell [][] cells, Position playerPosition) {
        int x = super.getPosition().getRow();
        int y = super.getPosition().getCol();

        if(getDirection().equals("up")) {

        	if(cells[x - 1][y] instanceof Wall ) {/// if it's stuck

        		if(cells[x][y - 1] instanceof Wall && cells[x][y + 1] instanceof Wall) {
        			super.setPosition(x + 1, y);
        			setDirection("down");
        		}else if(cells[x][y - 1] instanceof Wall) {
        			super.setPosition(x, y + 1);
        			setDirection("right");
        		}else if(cells[x][y + 1] instanceof Wall) {
        			super.setPosition(x, y - 1);
        			setDirection("left");
        		}else {
        			super.setPosition(x, y + 1);
        			setDirection("right");
        		}
        	}else {///if it's not stuck

        		Position position = new Position(x - 1, y);
        		///direction ok
        		if(checkMoveValid(cells, position, "up") == true) {
        		super.setPosition(x - 1, y);
        		}else {
        		///direction has to be changed
        		position.setRow(x);
        		position.setCol(y - 1);

        		if(checkMoveValid(cells, position, "left") == true) {
        		super.setPosition(x, y - 1);
        		setDirection("left");
        		}else {
            	super.setPosition(x, y + 1);
            	setDirection("right");
        		}

        	 }

        	}
        } else if(getDirection().equals("down")) {

        	if(cells[x + 1][y] instanceof Wall){///if it's stuck

        		if(cells[x][y - 1] instanceof Wall && cells[x][y + 1] instanceof Wall) {
        			super.setPosition(x - 1, y);
        			setDirection("up");
        		}else if(cells[x][y - 1] instanceof Wall) {
        			super.setPosition(x, y + 1);
        			setDirection("right");
        		}else if(cells[x][y + 1] instanceof Wall) {
        			super.setPosition(x, y - 1);
        			setDirection("left");
        		}else {
        			super.setPosition(x, y - 1);
        			setDirection("left");
        		}
        	}else {///if it's not stuck

        		Position position = new Position(x + 1, y);

        		///direction ok
        		if(checkMoveValid(cells, position, "down") == true) {
        		super.setPosition(x + 1, y);
        		}else {
        		///direction has to be changed
        			position.setRow(x);
        			position.setCol(y - 1);

        			if(checkMoveValid(cells, position, "left") == true) {
        		  super.setPosition(x, y - 1);
        		  setDirection("left");
        		  }else {
            	  super.setPosition(x, y + 1);
            	  setDirection("right");
        		}

        	  }

        	}
        } else if(getDirection().equals("left")) {

        	if(cells[x][y - 1] instanceof Wall ) {///if it's stuck

        		if(cells[x + 1][y] instanceof Wall && cells[x - 1][y] instanceof Wall) {
        			super.setPosition(x, y + 1);
        			setDirection("right");
        		}else if(cells[x + 1][y] instanceof Wall) {
        			super.setPosition(x - 1, y);
        			setDirection("up");
        		}else if(cells[x - 1][y] instanceof Wall) {
        			super.setPosition(x + 1, y);
        			setDirection("down");
        		}else {
        			super.setPosition(x - 1, y);
        			setDirection("up");
        		}
        	}else {///if it's not stuck
        		Position position = new Position(x, y - 1);

        		///direction ok
        		if(checkMoveValid(cells, position, "left") == true) {
        		super.setPosition(x, y - 1);
        		}else {
        		///direction has to be changed
        			position.setRow(x - 1);
        			position.setCol(y);

        			if(checkMoveValid(cells, position, "up") == true) {
        		  super.setPosition(x - 1, y);
        		  setDirection("up");
        		  }else {
            	  super.setPosition(x + 1, y);
            	  setDirection("down");
            	  }

        	  }

        	}
        } else if(getDirection().equals("right")) {

        	if(cells[x][y + 1] instanceof Wall ) {///if it's stuck

        		if(cells[x + 1][y] instanceof Wall && cells[x - 1][y] instanceof Wall) {
        			super.setPosition(x, y - 1);
        			setDirection("left");
        		}else if(cells[x + 1][y] instanceof Wall) {
        			super.setPosition(x - 1, y);
        			setDirection("up");
        		}else if(cells[x - 1][y] instanceof Wall) {
        			super.setPosition(x + 1, y);
        			setDirection("down");
        		}else {
        			super.setPosition(x + 1, y);
        			setDirection("down");
        		}
        	}else {///if it's not stuck
        		Position position = new Position(x, y + 1);

        		///direction ok
        		if(checkMoveValid(cells, position, "right") == true) {
        		super.setPosition(x, y + 1);
        		}else {
        		///direction has to be changed
        			position.setRow(x - 1);
        			position.setCol(y);

        			if(checkMoveValid(cells, position, "up") == true) {
        		  super.setPosition(x - 1, y);
        		  setDirection("up");
        		  }else {
            	  super.setPosition(x + 1, y);
            	  setDirection("down");
            	}

        	  }

        	}
        }


    }

    /**
	 * Check whether an enemy's move is valid.
	 * @param cells An array of the cells.
	 * @param position The enemy's position.
	 * @param direction The direction the enemy is moving to.
	 * @return isMoveValid, which specifies whether the enemy's next move is valid or not.
	 */
    private static boolean checkMoveValid(Cell [][] cells, Position position, String direction) {
    	boolean isMoveValid = false;
    	int x = position.getRow();
    	int y = position.getCol();

    	if(direction.equals("up")) {

    		if(cells [x - 1][y] instanceof Wall  || cells[x][y - 1] instanceof Wall
    				|| cells[x][y + 1] instanceof Wall) {
    			isMoveValid = true;
    		}

    	}else if(direction.equals("down")) {

    		if(cells [x + 1][y] instanceof Wall || cells[x][y - 1] instanceof Wall
    				||cells[x][y + 1] instanceof Wall) {
    			isMoveValid = true;
    		}

    	} else if(direction.equals("left")) {

    		if(cells [x][y - 1] instanceof Wall || cells[x + 1][y] instanceof Wall
    				||cells[x - 1][y] instanceof Wall) {
    			isMoveValid = true;
    		}
    	} else if(direction.equals("right")) {

    		if(cells [x][y + 1] instanceof Wall || cells[x + 1][y] instanceof Wall
    				||cells[x - 1][y] instanceof Wall) {
    			isMoveValid = true;
    		}
    	}

    	return isMoveValid;
    }

}
