package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * A ball that moves across the screen in random direction with a random velocity
 * and bounces off each edge of the screen to move in the opposite direction.
 *
 * @author Katherine Town
 * @version 18/06/2024
 */
public class Ball {
    private int x;
    private int y;
    private int size;
    private int xSpeed;
    private int ySpeed;

    public Ball(int x, int y, int size, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public void update() {
        x += xSpeed;
        y += ySpeed;
        if (x < size || x > (Gdx.graphics.getWidth() - size)) {
            xSpeed = -xSpeed;
        }
        if (y < size || y > (Gdx.graphics.getHeight() - size)) {
            ySpeed = -ySpeed;
        }
    }
    public void draw(ShapeRenderer shape) {
        shape.circle(x, y, size);
    }
}