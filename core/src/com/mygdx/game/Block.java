package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * A rectangular paddle that adjusts its x-position to that of the cursor.
 *
 * @author K Town
 * @version 18/06/2024
 */
public class Block {
    /**
     * Declare class attributes.
     */
    private int x,y,width,height;
    private boolean paddle, destroyed;

    /**
     * Constructor for Paddle objects. Sets initial object attribute values.
     *
     * @param x the initial x position.
     * @param y the initial y position.
     * @param width the width of the object.
     * @param height the height of the object.
     */
    public Block(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        paddle = false;
        destroyed = false;
    }

    /**
     * Set the current Rectangle object as the paddle.
     */
    public void setPaddle() {
        paddle = true;
    }

    /**
     * Get whether the current Rectangle object is the paddle.
     *
     * @return true if it is the paddle, false if it is not.
     */
    public boolean getPaddle() {
        return paddle;
    }

    /**
     * Set the current Rectangle object as destroyed.
     */
    public void setDestroyed() {
        destroyed = true;
    }

    /**
     * Check whether the rectangle has been destroyed.
     *
     * @return true if it has been destroyed, false if it has not.
     */
    public boolean getDestroyed() {
        return destroyed;
    }

    /**
     * Update the x position of the centre of the Paddle object to match the
     * x position of the cursor.
     */
    public void update() {
        if (paddle) {
            x = Gdx.input.getX() - (width / 2);
        }
    }

    /**
     * Create the rectangle shape that will represent the paddle, with the
     * initial x position, y position, width and height set by the Paddle
     * constructor.
     *
     * @param shape the shape to be created.
     */
    public void draw(ShapeRenderer shape) {
        shape.rect(x, y, width, height);
    }

    /**
     * Get the paddle x position.
     *
     * @return the x position.
     */
    public float getX() {
        return x;
    }

    /**
     * Get the paddle y position.
     *
     * @return the y position.
     */
    public float getY() {
        return y;
    }

    /**
     * Get the paddle width.
     *
     * @return the paddle width.
     */
    public float getWidth() {
        return width;
    }

    /**
     * Get the paddle height.
     *
     * @return the paddle height.
     */
    public float getHeight() {
        return height;
    }
}
