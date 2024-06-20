package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Bricks to line the top of the screen. The ball will break them when it hits
 * them.
 *
 * @author Katherine Town
 * @version 20/06/2024
 */

public class Brick {
    /**
     * Declare class attributes.
     */
    private int x,y,width,height;

    /**
     * Constructor for brick objects.
     *
     * @param x the x-axis position.
     * @param y the y-axis position.
     * @param width the width of the brick.
     * @param height the height of the brick.
     */
    public Brick(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Draw the brick.
     *
     * @param shape the shape to be created.
     */
    public void draw(ShapeRenderer shape){
        shape.rect(x, y, width, height);
    }
}
