package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;
import java.util.Random;

// https://colourtann.github.io/HelloLibgdx/2.html

/**
 * This class creates the objects in the game and renders them to the screen.
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
	private Paddle paddle;
	private Random r;

	/**
	 * Constructor for TestGame. Initialises r as new object of the Random class,
	 * to be used for generating pseudorandom numbers.
	 */
	public TestGame() {
		r = new Random();
	}

	/**
	 * Create a new Ball object in the middle of the screen, with a 20px radius,
	 * that moves in a random direction at a random speed of up to 10px per
	 * frame, and a new Paddle object that will sit at the bottom of the screen.
	 */
	@Override
	public void create () {
		// Initialise shape as a new ShapeRenderer object.
		shape = new ShapeRenderer();
		// Initialise ball with:
		ball = new Ball((Gdx.graphics.getWidth() / 2), // x-origin in the centre of the window,
				(Gdx.graphics.getWidth() / 2), // y-origin in the centre of the window,
				20, // a radius of 20px,
				r.nextInt(-10, 10), // xSpeed between -10 and 10px per frame,
				r.nextInt(-10, 10)); // ySpeed between -10 and 10px per frame.
		// Initialise the paddle with parameters: x=0, y=10, width=100px and height=10px.
		paddle = new Paddle(0, 10, 100, 10);
	}

	/**
	 * Render the ball and paddle to the screen.
	 */
	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear the buffer.

		ball.update(); // Update the state and location of the ball.
		shape.begin(ShapeRenderer.ShapeType.Filled); // Begin drawing.
		ball.draw(shape); // Draw the ball.
		shape.end(); // Stop drawing.

		paddle.update();
		shape.begin(ShapeRenderer.ShapeType.Filled);
		paddle.draw(shape);
		shape.end();
	}
}