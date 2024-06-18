package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;

// https://colourtann.github.io/HelloLibgdx/2.html

/**
 * This class creates the objects in the game and renders them to the screen.
 *
 * @author Katherine Town
 * @version 18/06/2024
 */
public class TestGame extends ApplicationAdapter {
	ShapeRenderer shape;
	Ball ball;
	Paddle paddle;

	@Override
	public void create () {
		shape = new ShapeRenderer();
		ball = new Ball(20, 30, 20, 5, 6);
		paddle = new Paddle(0, 10, 100, 10);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		ball.update();
		shape.begin(ShapeRenderer.ShapeType.Filled);
		ball.draw(shape);
		shape.end();

		paddle.update();
		shape.begin(ShapeRenderer.ShapeType.Filled);
		paddle.draw(shape);
		shape.end();
	}
}