package com.joungwon.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class HitBox {
    public static final int BOX_WIDTH = 12;
    public static final int TERM = 130;
    public static final int SPACE = 100;
    public static final int LOWEST = 120;
    private Texture topBox, bottomBox;
    private Vector2 topPosition, bottomPosition;
    private Random random;
    private Rectangle boundsTop, boundsBottom;
    public HitBox(float oat) {
        topBox = new Texture("box.png");
        bottomBox = new Texture("box.png");
        random = new Random();
        topPosition = new Vector2(oat, random.nextInt(SPACE) + SPACE + LOWEST);
        bottomPosition = new Vector2(oat, topPosition.y - SPACE - bottomBox.getHeight());
        boundsTop = new Rectangle(topPosition.x, topPosition.y, topBox.getWidth() - 30, topBox.getHeight() + 15);
        boundsBottom = new Rectangle(bottomPosition.x, bottomPosition.y, bottomBox.getWidth() - 30, bottomBox.getHeight() - 50);
    }

    public Texture getTopBox() {
        return topBox;
    }

    public Texture getBottomBox() {
        return bottomBox;
    }

    public Vector2 getTopPosition() {
        return topPosition;
    }

    public Vector2 getBottomPosition() {
        return bottomPosition;
    }
    public void reposition(float x) {
        topPosition.set(x, random.nextInt(TERM) + SPACE + LOWEST);
        bottomPosition.set(x, topPosition.y - SPACE - bottomBox.getHeight());
        boundsTop.setPosition(topPosition.x, topPosition.y);
        boundsBottom.setPosition(bottomPosition.x, bottomPosition.y);
    }
    public boolean collision(Rectangle playerBound) {
        if (!playerBound.overlaps(boundsTop) && !playerBound.overlaps(boundsBottom)) {

        }
        return playerBound.overlaps(boundsTop) || playerBound.overlaps(boundsBottom);
    }
    public void dispose() {
    }
}
