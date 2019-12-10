import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Scanner;
/**
* Implements the filereader for the level files
*
* @author William Bampton and Alistair Grom
*/
public class LevelReader{

  private Enemy[] enemies;
  private Cell[][] cells;
  private Player player;

  /**
   * This constructor populates enemies, cells and player with the correct data from
   * the specified file
   * @param filepath where the level file is located
   **/
  public LevelReader(String filepath) {

    ArrayList<Enemy> enemiesArray = new ArrayList<Enemy>();
    ArrayList<ArrayList<Cell>> cellArray = new ArrayList<ArrayList<Cell>>();

    File file = new File(filepath);
    Scanner in = null;

    try {
      in = new Scanner(file);
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    int y = 0;
    while (in.hasNext()) {
        int x = 0;
        String data = in.nextLine();
        StringTokenizer cell = new StringTokenizer(data, ",");

        ArrayList<Cell> row = new ArrayList<Cell>();

        while (cell.hasMoreTokens()) {
            //checks if a cell contains a "/" i.e. an enemy with direction
            String tmpCell = cell.nextToken();
            String argument1 = null;
            String argument2 = null;
            if (tmpCell.contains("/")) {
              String[] tmpArgument = tmpCell.split("/");
              argument1 = tmpArgument[1];

              if (tmpArgument.length > 2) {
                argument2 = tmpArgument[2];
              }
            }

            //Enemies
            if (tmpCell.contains("STE")) {
                enemiesArray.add(new SmartTargetEnemy(new Position(y, x)));
                row.add(new Cell(new Position(y, x)));
            } else if (tmpCell.contains("SLE")) {
                enemiesArray.add(new StraightLineEnemy(new Position(y, x), argument1));
                row.add(new Cell(new Position(y, x)));
            } else if (tmpCell.contains("WFE")) {
                enemiesArray.add(new WallFollowingEnemy(new Position(y, x), argument1));
                row.add(new Cell(new Position(y, x)));
            } else if (tmpCell.contains("DTE")) {
                enemiesArray.add(new DumbEnemy(new Position(y, x)));
                row.add(new Cell(new Position(y, x)));
            }

            //Player
            else if (tmpCell.contains("P")) {
                this.player = new Player(new Position(y, x));
                row.add(new Cell(new Position(y, x)));
            }

            //Core Cells
              else if (tmpCell.contains("WAL")) {
                row.add(new Wall(new Position(y, x)));
            } else if (tmpCell.contains("G")) {
                row.add(new Cell(new Position(y, x)));
            } else if (tmpCell.contains("goal")) {
                row.add(new Goal(new Position(y, x)));
            }

            //Obstacles
             else if (tmpCell.contains("WAT")) {
                row.add(new Water(new Position(y, x)));
            } else if (tmpCell.contains("F")) {
                row.add(new Fire(new Position(y, x)));
            }

            //CollectableItems
              else if (tmpCell.contains("T")) {
                row.add(new Token(new Position(y, x)));
            } else if (tmpCell.contains("fl")) {
                row.add(new Flippers(new Position(y, x)));
            } else if (tmpCell.contains("fb")) {
                row.add(new FireBoots(new Position(y, x)));
            } else if (tmpCell.contains("K")) {
                row.add(new Key(new Position(y, x), argument1));
            }

            //Doors
            //Teleporter arguments need to change
              else if (tmpCell.contains("tp")) {
                row.add(new Teleporter(new Position(y, x), new Position(Integer.parseInt(argument1), Integer.parseInt(argument2))));
            } else if (tmpCell.contains("td")) {
                int tokens = Integer.parseInt(argument1);
                row.add(new TokenDoor(new Position(y, x), tokens));
            } else if (tmpCell.contains("CD")) {
                row.add(new ColourDoor(new Position(y, x), argument1));
            }

            x++;
        }
        cellArray.add(row);
        y++;
    }

    //Convert the cells arraylists to arrays
    ArrayList<Cell[]> temp = new ArrayList<Cell[]>();
    for (int i = 0; i < cellArray.size(); i++) {
        Cell[] tempRow = new Cell[cellArray.get(i).size()];
        tempRow = cellArray.get(i).toArray(tempRow);
        temp.add(tempRow);
    }

    this.cells = new Cell[temp.size()][temp.size()];
    this.cells = temp.toArray(this.cells);


    this.enemies = new Enemy[enemiesArray.size()];
    this.enemies = enemiesArray.toArray(this.enemies);


  }
  /**
   * returns the enemies array
   * @return Enemy[] - array of enemies
   **/
  public Enemy[] getEnemies() {
    return this.enemies;
  }

  /**
   * returns the 2d array of cells
   * @return Cell[][] - 2d array of cells
   **/
  public Cell[][] getCells() {
    return this.cells;
  }

  /**
   * Returns the player object
   * @return Player - the player
   **/
  public Player getPlayer() {
    return this.player;
  }

}
