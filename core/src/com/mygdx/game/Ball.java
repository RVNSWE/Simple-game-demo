package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * A ball that moves across the screen and bounces off each edge of the screen
 * to move in the opposite direction.
 *
 * @author K Town
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
     * Get the x position.
     *
     * @return the x position.
     */
    public int getX() {
        return x;
    }

    /**
     * Get the y position.
     *
     * @return the y position.
     */
    public int getY() {
        return y;
    }

    /**
     * Get the ball's size.
     *
     * @return the ball's size.
     */
    public int getSize() {
        return size;
    }

    /**
     * Get the y-axis speed.
     *
     * @return the y-axis speed.
     */
    public int getYSpeed() {
        return ySpeed;
    }

    /**
     * Set the y-axis speed.
     *
     * @param ySpeed the new x-axis speed.
     */
    public void setYSpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    /**
     * Get the x-axis speed.
     *
     * @return the x-axis speed.
     */
    public int getXSpeed() {
        return xSpeed;
    }

    /**
     * Set the x-axis speed.
     *
     * @param xSpeed the new x-axis speed.
     */
    public void setXSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }
}
