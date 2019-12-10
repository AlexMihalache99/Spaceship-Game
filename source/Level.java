import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
/**
* Contains the implementation for drawing all of the assets, player movement and
* various other functions of a level
* @author William Bampton
*/
public class Level extends Application{
    private static UserProfile user;

    private Cell[][] cells;
    private Enemy[] enemies;
    private Player player;
    private boolean gameOver = false;
    private boolean won = false;

    private Cell[][] displayCells;
    private Enemy[][] displayEnemies;
    private int cellSize = 50;
    private int windowSize = 450;
    private int gridSize = 9;
    private int centerPoint = 4;

    private int level;


    /**
     * Constructs the level instance
     * @param number level number
     * @param user the user's profile
     **/
    public Level(int number, UserProfile user){
    	this.level = number;
        Level.user = user;
        LevelReader buffer = new LevelReader("level"+number +".csv");
        this.cells = buffer.getCells();
        this.enemies = buffer.getEnemies();
        this.player = buffer.getPlayer();
        if(this.level > 1) {
            Player.setImage("images/skin"+(this.level-1)+".png");
        }

    }

    /**
     * This method is called automatically after the constructor has finished and
     * contains the necessary code to draw and continue running the game
     * @param primaryStage the stage
     **/
    public void start(Stage primaryStage) throws IOException{

            //Load and create the level for the user
            loadPlayerView();
            GridPane grid = drawLevel();
            Scene scene = new Scene(grid, this.windowSize, this.windowSize);
            primaryStage.setTitle("SpaceShip");
            primaryStage.setScene(scene);
            primaryStage.show();

            //Handles the keyboard input for the user and player movement
            EventHandler<KeyEvent> handler = event ->{;
                if(event.getCode()== KeyCode.UP) {
                    Cell cell = this.cells[this.player.getPosition().getRow()-1][this.player.getPosition().getCol()];
                    if(this.player.isMoveValid(this.cells[this.player.getPosition().getRow()-1][this.player.getPosition().getCol()])) {

                        if(!(cell instanceof Teleporter)) {
                            this.player.getPosition().setRow(this.player.getPosition().getRow()-1);
                        }
                    }

                } else if (event.getCode()== KeyCode.DOWN) {
                    Cell cell = this.cells[this.player.getPosition().getRow()+1][this.player.getPosition().getCol()];
                    if(this.player.isMoveValid(this.cells[this.player.getPosition().getRow()+1][this.player.getPosition().getCol()])) {

                        if(!(cell instanceof Teleporter)) {
                            this.player.getPosition().setRow(this.player.getPosition().getRow()+1);
                        }
                    }

                } else if (event.getCode()== KeyCode.LEFT) {
                    Cell cell = this.cells[this.player.getPosition().getRow()][this.player.getPosition().getCol()-1];
                    if(this.player.isMoveValid(this.cells[this.player.getPosition().getRow()][this.player.getPosition().getCol()-1])) {
                        if(!(cell instanceof Teleporter)) {
                            this.player.getPosition().setCol(this.player.getPosition().getCol()-1);
                        }
                    }

              } else if (event.getCode()== KeyCode.RIGHT){
                    Cell cell = this.cells[this.player.getPosition().getRow()][this.player.getPosition().getCol()+1];
                    if(this.player.isMoveValid(this.cells[this.player.getPosition().getRow()][this.player.getPosition().getCol()+1])) {
                        if(!(cell instanceof Teleporter)) {
                          this.player.getPosition().setCol(this.player.getPosition().getCol()+1);
                        }
                    }
                }

                //Once the player has moved the enemies can calculate their new positions and the new state of
                //the level is displayed
                enemyMovement();
                isGameOver();
                loadPlayerView();
                primaryStage.getScene().setRoot(drawLevel());

                //If gameOver has been set to true
                if(this.gameOver) {

                    if(this.won) {
                        //If final level is completed
                        if(this.level == 5){
                            Alert alert = new Alert(AlertType.INFORMATION);

                            if(user != null) {
                                Leaderboard.addProfile(Level.user);
                                saveGame();
                            }

                        	alert.setContentText("YOU COMPLETED THE GAME. NOW GO GET A LIFE.");
                        	alert.showAndWait();
                        //If a non-final level is completed
                        } else {
                        	Alert alert = new Alert(AlertType.INFORMATION);
                        	alert.setContentText("YOU WON!!!. CLICK OK AND PRESS ANY KEY TO ADVANCE.");
                        	alert.showAndWait();
                            if(user != null) {
                                Leaderboard.addProfile(Level.user);
                                saveGame();
                            }

                        	Level Level = new Level(this.level + 1, user);
                            try {
                                Level.start(primaryStage);
                            } catch(Exception exception_name) {

                            }

                        }
                    } else {
                    	Alert alert = new Alert(AlertType.INFORMATION);
                    	alert.setContentText("YOU DIED. CLICK OK AND PRESS ANY KEY TO RESTART.");
                    	alert.showAndWait();
                    	Level Level = new Level(this.level, user);
                        try {
                            Level.start(primaryStage);
                        } catch(Exception e) {

                        }

                    }
                }
            };
            //Applies the event handler
            primaryStage.getScene().setOnKeyPressed(handler);
        }


	/**
    * Loads the 9x9 grid of cells around the player in a 2d array as well as any enemies that
    * would be in the player view in the grid
    */
    private void loadPlayerView(){
        Position playerPos = this.player.getPosition();
        this.displayEnemies = new Enemy[gridSize][gridSize];
        this.displayCells = new Cell[gridSize][gridSize];


        for(int row = 0; row < this.displayCells.length; row++){
            int rowDiff = this.centerPoint - row;
            for(int col = 0; col < this.displayCells[row].length; col++){
                int colDiff = this.centerPoint - col;

                try{
                    this.displayCells[row][col] = this.cells[playerPos.getRow()-rowDiff][playerPos.getCol()-colDiff];
                } catch(Exception e) {
                    this.displayCells[row][col] = null;
                }

                //Checks if an enemy is also on the cell
                for(int enemy = 0; enemy < this.enemies.length; enemy++){
                    Position enemyPos = this.enemies[enemy].getPosition();
                    if(enemyPos.getRow() == playerPos.getRow()-rowDiff && enemyPos.getCol() == playerPos.getCol()-colDiff) {
                        this.displayEnemies[row][col] = this.enemies[enemy];

                    }
                }
            }
        }
    }

    /**
     * This method creates a GridPane to be displayed by the primary stage.
     * The GridPane contains the images of 9x9 grid of the players view and everything
     * within the grid
     * @return GridPane containing the viewable level
     **/
    private GridPane drawLevel(){
        GridPane grid = new GridPane();
        for (int row = 0; row < this.displayCells.length; row++) {
            for (int col = 0; col < this.displayCells[row].length; col++) {

                try {
                    Cell cell = this.displayCells[row][col];
                    Image cellImage = null;

                    if(cell.getClass().getName() == "Wall") {
                        cellImage = Wall.getImage();
                    } else if (cell.getClass().getName() == "Goal") {
                        cellImage = Goal.getImage();
                    } else if (cell.getClass().getName() == "Water") {
                        cellImage = Water.getImage();
                    } else if (cell.getClass().getName() == "Fire") {
                        cellImage = Fire.getImage();

                    //For the CollectableItems a regular cell image is also inserted
                    //as they have a transparent background
                    } else if (cell.getClass().getName() == "FireBoots") {
                        addToGrid(grid, row, col, Cell.getImage());
                        FireBoots temp = (FireBoots) cell;
                        cellImage = temp.getInstanceImage();
                    }else if (cell.getClass().getName() == "Flippers") {
                        addToGrid(grid, row, col, Cell.getImage());
                        Flippers temp = (Flippers) cell;
                        cellImage = temp.getInstanceImage();
                    }else if (cell.getClass().getName() == "Token") {
                        addToGrid(grid, row, col, Cell.getImage());
                        Token temp = (Token) cell;
                        cellImage = temp.getInstanceImage();
                    } else if (cell.getClass().getName() == "Key") {
                        addToGrid(grid, row, col, Cell.getImage());
                        Key temp = (Key) cell;
                        cellImage = temp.getInstanceImage();

                    } else if (cell.getClass().getName() == "ColourDoor") {
                        ColourDoor temp = (ColourDoor) cell;
                        cellImage = temp.getInstanceImage();
                    } else if (cell.getClass().getName() == "TokenDoor") {
                        TokenDoor temp = (TokenDoor) cell;
                        cellImage = temp.getInstanceImage();
                    } else if (cell.getClass().getName() == "Teleporter") {
                        addToGrid(grid, row, col, Cell.getImage());
                        Teleporter temp = (Teleporter) cell;
                        cellImage = temp.getImage();

                    } else {
                        cellImage = Cell.getImage();
                    }

                    addToGrid(grid, row, col, cellImage);

                } catch(Exception exception_name) {
                    Rectangle rec = new Rectangle();
                    rec.setWidth(this.cellSize);
                    rec.setHeight(this.cellSize);
                    rec.setFill(Color.BLACK);
                    GridPane.setRowIndex(rec, row);
                    GridPane.setColumnIndex(rec, col);
                    grid.getChildren().addAll(rec);
                }
                //Adds the enemy's image to the cell if it exists
                Enemy enemy = this.displayEnemies[row][col];
                if(enemy != null) {
                    addToGrid(grid, row, col, enemy.getImage());
                }

                //Adds the player's image to the centre of the GridPane
                if(row == this.centerPoint && col == this.centerPoint) {
                    addToGrid(grid, row, col, Player.getImage());
                }

            }
        }
        return grid;
    }

    /**
     * Inserts a specified image into a specified GridPane at a specified location
     * @param grid GridPane the image is being added to
     * @param row row of the grid
     * @param col column of the grid
     * @param image image to be added
     **/
    private void addToGrid(GridPane grid, int row, int col, Image image){
        ImageView imageView = new ImageView(image);
        GridPane.setRowIndex(imageView, row);
        GridPane.setColumnIndex(imageView, col);
        grid.getChildren().addAll(imageView);
    }

    /**
     * Calls the nextMove() method for each of the enemies on the level
     **/
    private void enemyMovement(){
        for(int i = 0; i < this.enemies.length; i++){
            if(this.enemies[i].getClass().getName() == ("StraightLineEnemy")) {
                StraightLineEnemy enemy = (StraightLineEnemy) this.enemies[i];
                enemy.nextMove(this.cells, this.player.getPosition());
                Position newPos = enemy.getPosition();
                this.enemies[i].setPosition(newPos.getRow(), newPos.getCol());
            } else if (this.enemies[i].getClass().getName() == "WallFollowingEnemy") {
                WallFollowingEnemy enemy = (WallFollowingEnemy) this.enemies[i];
                enemy.nextMove(this.cells, this.player.getPosition());
                Position newPos = enemy.getPosition();
                this.enemies[i].setPosition(newPos.getRow(), newPos.getCol());
            }else if (this.enemies[i].getClass().getName() == "SmartTargetEnemy") {
                SmartTargetEnemy enemy = (SmartTargetEnemy) this.enemies[i];
                enemy.nextMove(this.cells, this.player.getPosition());
                Position newPos = enemy.getPosition();
                this.enemies[i].setPosition(newPos.getRow(), newPos.getCol());
            }else if (this.enemies[i].getClass().getName() == "DumbEnemy") {
                DumbEnemy enemy = (DumbEnemy) this.enemies[i];
                enemy.nextMove(this.cells, this.player.getPosition());
                Position newPos = enemy.getPosition();
                this.enemies[i].setPosition(newPos.getRow(), newPos.getCol());
            }
        }
    }

    /**
     * Determines whether the game is still ongoing(whether the player has won/lost)
     * @return boolean true is the game is over, false otherwise
     **/
    private boolean isGameOver(){
        Position playerPos = this.player.getPosition();
        Cell playerCell = this.cells[playerPos.getRow()][playerPos.getCol()];
        if(playerCell instanceof Goal) {
            this.gameOver = true;
            this.won = true;
        } else if (playerCell instanceof Water && !this.player.isFlippers()){
            this.gameOver = true;
        } else if (playerCell instanceof Fire && !this.player.isFireBoots()){
            this.gameOver = true;
        }

        for(int i = 0; i < this.enemies.length; i++){
            Position enemyPos = this.enemies[i].getPosition();
            if(playerPos.getRow() == enemyPos.getRow() && playerPos.getCol() == enemyPos.getCol()) {
                this.gameOver = true;
            }
        }

        return false;
    }

    /**
     * Saves the user's game data to their profile
     **/
    private void saveGame(){
        Level.user.setUserLevel(this.level + 1);
        ProfileManager.saveData(user);

    }

}
