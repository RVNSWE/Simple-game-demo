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
    private float x;
    private float y;
    private float width;
    private float height;

    public Paddle(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void update() {
        x = Gdx.input.getX() - (width / 2);
    }

    public void draw(ShapeRenderer shape) {
        shape.rect(x, y, width, height);
    }
}