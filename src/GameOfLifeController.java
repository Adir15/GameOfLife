import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;

public class GameOfLifeController {

	@FXML
	private Button button;

	@FXML
	private Canvas canv;
	private Affine affine;
	private Simulation simulation;
	private final int BOARD_SIZE = 10;

	/* Constructor, gets length and width and creates a board */
	public void initialize() {
		Random random = new Random();

		affine = new Affine();
		affine.appendScale(canv.getHeight() / 10f, canv.getWidth() / 16f); // Creating squares of the desired size on
		simulation = new Simulation(BOARD_SIZE, BOARD_SIZE); // Initialize the simulation at the appropriate size
		for (int i = 0; i < random.nextInt(100); i++) { // Random generation of lives in the game
			{
				simulation.setAlive(random.nextInt(BOARD_SIZE), random.nextInt(BOARD_SIZE));
				simulation.setAlive(random.nextInt(BOARD_SIZE), random.nextInt(BOARD_SIZE));
				simulation.setAlive(random.nextInt(BOARD_SIZE), random.nextInt(BOARD_SIZE));
				simulation.setAlive(random.nextInt(BOARD_SIZE), random.nextInt(BOARD_SIZE));
			}
		}
		draw(); // Creating the canvas
	}

	/* The functions activated by pressing a button */
	@FXML
	void buttonPress(ActionEvent event) {
		simulation.step(); // Changes the canvas according to the rules of the game
		draw(); // Creating a new canvas, with the new conditions with each click of a button
	}

	/*
	 * The canvas drawing, in the size required by the simulation department, the
	 * color and the conditions of the requested game
	 */
	public void draw() {
		GraphicsContext g = canv.getGraphicsContext2D();
		g.setTransform(affine);
		g.setFill(Color.DARKGRAY);
		g.fillRect(0, 0, canv.getHeight(), canv.getWidth());

		g.setFill(Color.BLACK);
		for (int x = 0; x < simulation.width; x++) {
			for (int y = 0; y < simulation.height; y++) {
				if (simulation.getState(x, y) == 1) {
					g.fillRect(x, y, 1, 1);
				}
			}
		}
		g.setStroke(Color.GRAY);
		g.setLineWidth(0.05f);
		for (int x = 0; x <= simulation.width; x++) {
			g.strokeLine(x, 0, x, 10);
		}
		for (int y = 0; y <= simulation.width; y++) {
			g.strokeLine(0, y, 10, y);
		}

	}

}
