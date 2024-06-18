package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * A ball that moves across the screen and bounces off each edge of the screen
 * to move in the opposite direction.
 *
 * @author Katherine Town
 * @version 18/06/2024
 */
public class Ball {
    /**
     * Declare class attributes.
     */
    private int x; // An x position.
    private int y; // A y position.
    private int size; // The size of a shape in pixels.
    private int xSpeed; // An x-axis travel speed in pixels.
    private int ySpeed; // A y-axis travel speed in pixels.
    private Color colour; // A colour to assign to a shape.

    /**
     * Constructor for Ball objects. Sets initial object attribute values.
     *
     * @param x the initial x position.
     * @param y the initial y position.
     * @param size the ball radius.
     * @param xSpeed the y-axis speed of travel.
     * @param ySpeed the x-axis speed of travel.
     */
    public Ball(int x, int y, int size, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        colour = Color.WHITE;
    }

    /**
     * Update the x position of the Ball object. If it has reached the edge
     * of the window, reverse its speed (thereby reversing its direction of
     * travel).
     */
    public void update() {
        x += xSpeed; // Update the x position.
        y += ySpeed; // Update the y position.
        if (x < size || x > (Gdx.graphics.getWidth() - size)) {
            xSpeed = -xSpeed;
        }
        if (y < size || y > (Gdx.graphics.getHeight() - size)) {
            ySpeed = -ySpeed;
        }
    }

    /**
     * Create the circle shape that will represent the ball, with the initial
     * x position, y position, size and colour set by the Ball constructor.
     *
     * @param shape the shape to be created.
     */
    public void draw(ShapeRenderer shape) {
        shape.setColor(colour);
        shape.circle(x, y, size);
    }

    /**
     * Check whether the paddle has collided with the ball and set its colour
     * to green if it has, otherwise it is set to white.
     *
     * @param paddle the paddle.
     */
    public void checkCollision(Paddle paddle) {
        if (collidesWith(paddle)) {
            colour = Color.GREEN;
        }
        else {
            colour = Color.WHITE;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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

        if ((this.getX() + size) < (paddle.getX())) {
            return false;
        }
        if ((this.getX() - size) > (paddle.getX() + paddle.getWidth())) {
            return false;
        }
        if ((this.getY() + size) < (paddle.getY())) {
            return false;
        }
        if ((this.getY() - size) > (paddle.getY() + paddle.getHeight())) {
            return false;
        }

        return collision;
    }
}