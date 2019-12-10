package com.joungwon.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Bunny {
    private static final int MOVEMENT = 100;
    private static final int GRAVITY = -15;
    private Vector3 position;
    private Vector3 velocity;
    private Rectangle bunnyBounds;
    private Animation animation;


    public Bunny(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        Texture animationTexture = new Texture("animation.png");
        animation = new Animation(new TextureRegion(animationTexture), 3, 0.5f);
        bunnyBounds = new Rectangle(x + 50, y + 20, animationTexture.getWidth() / 3 - 40, animationTexture.getHeight() - 50);
    }
    public void update(float deltaTime) {
        animation.update(deltaTime);
        if (position.y > 0)
            velocity.add(0, GRAVITY, 0);
        velocity.scl(deltaTime);
        position.add(MOVEMENT * deltaTime, velocity.y, 0);
        if (position.y < 0) {
            position.y = 0;
        }
        velocity.scl(1/deltaTime);
        bunnyBounds.setPosition(position.x, position.y);
    }

    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getAnimation() {
        return animation.getFrame();
    }
    public void jump() {
        velocity.y = 250;
    }
    public Rectangle getBunnyBounds() {
        return bunnyBounds;
    }
    public void dispose() {

    }
}
