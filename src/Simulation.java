
public class Simulation {
	int width;
	int height;
	int[][] board;
	final int ALIVE = 1;
	final int DEAD = 0;

	/* Constructor, gets length and width and creates a board */
	public Simulation(int width, int height) {

		this.width = width;
		this.height = height;

		this.board = new int[width][height];
	}

	/*
	 * Initialize the cell at the X position and the Y position on the board, in a
	 * "live" cell
	 */
	public void setAlive(int x, int y) {
		this.board[x][y] = ALIVE;
	}

	/*
	 * Initialize the cell at the X position and the Y position on the board, in a
	 * "Dead" cell
	 */
	private void setDead(int x, int y) {
		this.board[x][y] = DEAD;

	}

	/* If the position is correct, returns the position on the board */
	public int getState(int x, int y) {
		if (x < 0 || x >= width) {
			return 0;
		}
		if (y < 0 || y >= height) {
			return 0;
		}
		return this.board[x][y];
	}

	/*
	 * Count the amount of living neighbors of cell X Y, for the purpose of
	 * calculating the STEP later
	 */
	public int countAliveNeighbours(int x, int y) {
		int count = 0;

		count = count + getState(x - 1, y - 1);
		count = count + getState(x, y - 1);
		count = count + getState(x + 1, y - 1);

		count = count + getState(x - 1, y);
		count = count + getState(x + 1, y);

		count = count + getState(x - 1, y + 1);
		count = count + getState(x, y + 1);
		count = count + getState(x + 1, y + 1);

		return count;

	}

	/* Changing the board according to the Conway's Game of Life conditions */
	public void step() {
		int[][] newBoard = new int[width][height];

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int aliveNeighbours = countAliveNeighbours(x, y);

				if (getState(x, y) == ALIVE) {
					if (aliveNeighbours < 2) { // In every site where there is "life" that has 0 or 1 living neighbors,
												// death will occur in the next generation
												// from loneliness
						newBoard[x][y] = DEAD;
					} else if (aliveNeighbours == 2 || aliveNeighbours == 3) { //  Every site where there is "life" and
																				// has 2 or 3 living neighbors, will
																				// continue to exist in the next
																				// generation.
						newBoard[x][y] = ALIVE;
					} else if (aliveNeighbours > 3) { // In any site where "there is life" and if there are 4 or more
														// living neighbors, death will occur in the next generation as
														// a result
														// From "Population Explosion"
						newBoard[x][y] = DEAD;
					}
				} else {
					if (aliveNeighbours == 3) { // In every site where there is "no life" that has exactly 3 living
												// neighbors, there will be a birth in the next generation
						newBoard[x][y] = ALIVE;
					}
				}

			}
		}

		this.board = newBoard;
	}
}
