package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;
import java.util.ArrayList;
import java.util.Random;

// https://colourtann.github.io/HelloLibgdx/3.html

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
	Color colour;
	ArrayList<Brick> bricks;

	/**
	 * Constructor for TestGame. Initialises r as new object of the Random class,
	 * to be used for generating pseudorandom numbers.
	 */
	public TestGame() {
		r = new Random();
		colour = Color.WHITE;
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
		bricks = new ArrayList<>();
		int brickWidth = 63;
		int brickHeight = 20;
		for (int y = Gdx.graphics.getHeight() / 2; y < Gdx.graphics.getHeight(); y += brickHeight + 10) {
			for (int x = 0; x < Gdx.graphics.getWidth(); x += brickWidth + 10) {
				bricks.add(new Brick(x, y, brickWidth, brickHeight));
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
		checkCollision(paddle); // Check whether the ball and paddle have collided.
		ball.draw(shape); // Draw the ball.
		shape.end(); // Stop drawing.

		paddle.update();
		shape.begin(ShapeRenderer.ShapeType.Filled);
		paddle.draw(shape);
		shape.end();

		int brickWidth = 63;
		int brickHeight = 20;
		shape.begin(ShapeRenderer.ShapeType.Filled);
		for (int y = Gdx.graphics.getHeight()/2; y < Gdx.graphics.getHeight(); y += brickHeight + 10) {
			for (int x = 0; x < Gdx.graphics.getWidth(); x += brickWidth + 10) {
				bricks.add(new Brick(x, y, brickWidth, brickHeight));
			}
		}
		for (Brick brick : bricks) {
			brick.draw(shape);
		}
		shape.end();
	}

	/**
	 *
	 * @param paddle
	 */
	public void checkCollision(Paddle paddle) {
		if(collidesWith(paddle)){
			ball.setYSpeed(-ball.getYSpeed());
		}
		else{
			colour = Color.WHITE;
		}
	}

	/**
	 * Generate a random number greater than 0.5 if the paddle collides with
	 * the ball.
	 *
	 * @param paddle the paddle.
	 * @return true if a collision has happened and false if not.
	 */
	private boolean collidesWith(Paddle paddle) {
		boolean collision = true;

		if ((ball.getX() + ball.getSize()) < (paddle.getX())) {
			return false;
		}
		if ((ball.getX() - ball.getSize()) > (paddle.getX() + paddle.getWidth())) {
			return false;
		}
		if ((ball.getY() + ball.getSize()) < (paddle.getY())) {
			return false;
		}
		if ((ball.getY() - ball.getSize()) > (paddle.getY() + paddle.getHeight())) {
			return false;
		}

		return collision;
	}
}