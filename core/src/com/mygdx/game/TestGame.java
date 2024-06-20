package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class creates the objects in the game and renders them to the screen.
 * Based on tutorial from https://colourtann.github.io/HelloLibgdx/index.html.
 * Project development after implementation of collision detection and brick
 * destruction was entirely the work of the author.
 *
 * @author Katherine Town
 * @version 18/06/2024
 */
public class TestGame extends ApplicationAdapter {
	/**
	 * Declare class attributes.
	 */
	private ShapeRenderer shape;
	private Ball ball;
	private ArrayList<Rectangle> rectangles;
	private Rectangle paddle;
	private Random r;
	private Color colour;

	/**
	 * Constructor for TestGame. Initialises r as new object of the Random class,
	 * to be used for generating pseudorandom numbers.
	 */
	public TestGame() {
		r = new Random();
		colour = Color.WHITE;
		rectangles = new ArrayList<>();
	}

	/**
	 * Create a new Ball object in the middle of the screen, with a 20px radius,
	 * that moves in a random direction at a random speed of up to 10px per
	 * frame, and a new Paddle object that will sit at the bottom of the screen.
	 */
	@Override
	public void create () {
		// Create shape as a new ShapeRenderer object.
		shape = new ShapeRenderer();

		// Create the ball.
		ball = new Ball((Gdx.graphics.getWidth() / 2), // x-origin in the centre of the window,
				30, // y-origin in the centre of the window,
				10, // a radius of 20px,
				r.nextInt(-10, 10), // xSpeed between -10 and 10px per frame,
				r.nextInt( 5, 10)); // ySpeed 10px per frame.

		// Create the paddle and bricks.
		rectangles.add(new Rectangle(0, 10, 100, 10));
		paddle = rectangles.get(0);
		paddle.setPaddle();
		int rectangleWidth = 63;
		int rectangleHeight = 20;
		for (int y = Gdx.graphics.getHeight() / 2; y < Gdx.graphics.getHeight(); y += rectangleHeight + 10) {
			for (int x = 0; x < Gdx.graphics.getWidth(); x += rectangleWidth + 10) {
				rectangles.add(new Rectangle(x, y, rectangleWidth, rectangleHeight));
			}
		}
	}

	/**
	 * Render the ball and paddle to the screen.
	 */
	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear the buffer.

		ball.update(); // Update the state and location of the ball.
		shape.begin(ShapeRenderer.ShapeType.Filled); // Begin drawing.
		ball.draw(shape); // Draw the ball.
		shape.end(); // Stop drawing.

		shape.begin(ShapeRenderer.ShapeType.Filled);
		for (Rectangle rectangle : rectangles) {
			rectangle.update();
			rectangle.draw(shape);
			checkCollision(rectangle);
		}
		for (int i = 0; i < rectangles.size(); i++) {
			Rectangle rectangle = rectangles.get(i);
			if (rectangle.getDestroyed()) {
				rectangles.remove(rectangle);
				i--;
			}
		}
		shape.end();
	}

	/**
	 * Check whether the ball has collided with an object. If it collides with a
	 * brick, break the brick. If it collides with a paddle, bounce off.
	 *
	 * @param rectangle the object to be checked for collision with the ball.
	 */
	public void checkCollision(Rectangle rectangle) {
		if (collidesWith(rectangle) && rectangle.getPaddle()) {
			ball.setYSpeed(-ball.getYSpeed());
		}
		else if (collidesWith(rectangle)) {
			ball.setYSpeed(-ball.getYSpeed());
			rectangle.setDestroyed();
		}
	}

	/**
	 * Check whether the ball has collided with an object.
	 *
	 * @param rectangle the object the ball may collide with.
	 * @return true if a collision has happened and false if not.
	 */
	private boolean collidesWith(Rectangle rectangle) {
		boolean collision = true;

		if (((ball.getX() + ball.getSize()) < (rectangle.getX()))
		|| ((ball.getX() - ball.getSize()) > (rectangle.getX() + rectangle.getWidth()))
		|| ((ball.getY() + ball.getSize()) < (rectangle.getY()))
		|| ((ball.getY() - ball.getSize()) > (rectangle.getY() + rectangle.getHeight()))) {
			return false;
		}

		return collision;
	}
}