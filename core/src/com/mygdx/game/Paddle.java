package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * A rectangular paddle that adjusts its x-position to that of the cursor.
 *
 * @author Katherine Town
 * @version 18/06/2024
 */
public class Paddle {
    /**
     * Declare class attributes.
     */
    private float x; // An x position.
    private float y; // A y position.
    private float width; // The width of a shape in pixels.
    private float height; // The height of a shape in pixels.

    /**
     * Constructor for Paddle objects. Sets initial object attribute values.
     *
     * @param x the initial x position.
     * @param y the initial y position.
     * @param width the width of the object.
     * @param height the height of the object.
     */
    public Paddle(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Update the x position of the centre of the Paddle object to match the
     * x position of the cursor. The cursor is drawn from the top of the
     * screen and the paddle from the bottom, therefore the cursor position
     * must be subtracted from the window height to set the paddle's y
     * position.
     */
    public void update() {
        x = Gdx.input.getX() - (width / 2);
        y = Gdx.graphics.getHeight() - (Gdx.input.getY() + (height / 2));
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