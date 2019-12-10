import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import javafx.scene.image.Image;

/**
 * This class represents one of the four enemies, the Smart Target Enemy.
 * This is an attempt of implementing the A* algorithm which
 * finds the shortest path.
 * @author Alexandru Mihalache
 */
public class SmartTargetEnemy extends Enemy {
    private final Image image = new Image("images/smartEnemy.png");

    /**
	 * Create a new Smart Target Enemy.
	 * @param position  The position in which the enemy will spawn.
	 */
    public SmartTargetEnemy(Position position) {
            super(position);
    }

    /**
     * Get an array containing the position left, right, up and down of the enemy.
     * @param position The position of the enemy.
     * @return An array containing the positions left, right, up and down of the enemy.
     */
    public Position[] getNeighbours(Position position) {
            Position left = new Position(position.getRow(), position.getCol() - 1);
            Position right = new Position(position.getRow(), position.getCol() + 1);
            Position up = new Position(position.getRow() - 1, position.getCol());
            Position down = new Position(position.getRow() + 1, position.getCol());

            Position[] neighbours = { left, right, up, down };

            return neighbours;

    }

    /**
 * Get the image representing the Smart Target Enemy.
 * @return The image representing the Smart Target Enemy.
 */
    public Image getImage() {
            return this.image;
    }

	/**
	* This class return a value that helps in finding the shortest
	* path between two position by aproximating the length of the path.
	* This value is called heuristic.
	* @param enemy position of the smart enemy.
	* @param player position of the player.
	* @return the heuristic value representing the aproximate length.
	*/
    public double heuristicValue(Position enemy, Position player) {

            double heuristic1 = Math.pow(enemy.getRow() - player.getRow(), 2);
            double heuristic2 = Math.pow(enemy.getCol() - player.getCol(), 2);

            double heuristic = Math.sqrt(heuristic1 + heuristic2);

            return heuristic;
    }

    /**
 * Decide on the next move of the enemy.
 * @param cells An array of the cells.
 * @param playerPosition The player's position.
 */
    public void nextMove(Cell[][] cells, Position playerPosition) {

            List<Node> path = new ArrayList<Node>();

            Node target = new Node(playerPosition, heuristicValue(super.getPosition(), playerPosition));
            Node source = new Node(super.getPosition(), 0);

            AstarSearch(source, target);

            for (Node node = target; node != null; node = node.parent) {
                    path.add(node);
            }

            Collections.reverse(path);

            super.setPosition(path.get(0).value.getRow(), path.get(0).value.getCol());
    }

	/**
	*This class performs the A* search by going through the neighbour
	* of the source node that is closer to the goal node than the other
	* neighbours.
	*@param source the starting node.
	*@param goal the ending node.
	*/
    public void AstarSearch(Node source, Node goal) {

            Set<Node> explored = new HashSet<Node>();

            PriorityQueue<Node> queue = new PriorityQueue<Node>(20, new Comparator<Node>() {
                    // override compare method
                    public int compare(Node i, Node j) {
                            if (i.f_scores > j.f_scores) {
                                    return 1;
                            }

                            else if (i.f_scores < j.f_scores) {
                                    return -1;
                            }

                            else {
                                    return 0;
                            }
                    }

            });

            // cost from start
            source.g_scores = 0;

            queue.add(source);

            boolean found = false;

            while ((!queue.isEmpty()) && (!found)) {

                    // the node in having the lowest f_score value
                    Node current = queue.poll();

                    explored.add(current);

                    // goal found
                    if (current.value.equals(goal.value)) {
                            found = true;
                    }

                    Position[] neighbours = getNeighbours(current.value);
                    current.setAdjacencies(neighbours);

                    // check every child of current node
                    for (Edge e : current.adjacencies) {
                            Node child = e.target;
                            double cost = e.cost;
                            double temp_g_scores = current.g_scores + cost;
                            double temp_f_scores = temp_g_scores + child.h_scores;

                            /*
                             * if child node has been evaluated and the newer f_score is higher, skip
                             */

                            if ((explored.contains(child)) && (temp_f_scores >= child.f_scores)) {

                            }

                            /*
                             * else if child node is not in queue or newer f_score is lower
                             */

                            else if ((!queue.contains(child)) || (temp_f_scores < child.f_scores)) {

                                    child.parent = current;
                                    child.g_scores = temp_g_scores;
                                    child.f_scores = temp_f_scores;

                                    if (queue.contains(child)) {
                                            queue.remove(child);
                                    }

                                    queue.add(child);

                            }

                    }

            }

    }

	/**
	* An inner class which will represent
	* a vertex in the graph made
	* and all the properties.
	*
	*/
    class Node {

            public Position value;

			///the movement cost to move from the
			///starting position to a given position
            public double g_scores;

			///the estimated movement cost to move
			///from the starting position to the
			///given position
            public double h_scores;

			///it is the sum of g_scores  and h_scores
			///this is the value that the enemy checks
			///when he decides where to move.
            public double f_scores = 0;

            public Edge[] adjacencies;
            public Node parent;

			/**
			* Node constructor.
			* @param val the position of the node.
			* @param hVal the initial heuristic value.
			*/
            public Node(Position val, double hVal) {
                    value = val;
                    h_scores = hVal;
            }
            /**
			*Sets the adjancencies for a node.
			*@param position the neighbours of the node.
			*
			*/
			public void setAdjacencies(Position[] position) {
                    Node n1 = new Node(position[0], 1);
                    Node n2 = new Node(position[1], 1);
                    Node n3 = new Node(position[2], 1);
                    Node n4 = new Node(position[3], 1);

                    this.adjacencies = new Edge[] {
					                new Edge(n1, 1),
									new Edge(n2, 1),
									new Edge(n3, 1),
                                    new Edge(n4, 1) };
            }

    }

	/**
	*An inner class which represents
	*the link between a node and its neighbour
	*and stores also the cost from moving towards
	* the neighbour.
	*/
    class Edge {
            public final double cost;
            public final Node target;

			/**
			*Edge constructor.
			*@param targetNode the neighbour of the initial node.
			*@param costVal the cost of moving towards the neighbour.
			*/
            public Edge(Node targetNode, double costVal) {
                    target = targetNode;
                    cost = costVal;
            }
    }

}
