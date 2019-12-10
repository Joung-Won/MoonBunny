package com.joungwon.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.joungwon.game.sprites.Bunny;
import com.joungwon.game.sprites.HitBox;

public class PlayState extends State {
    private static final int BOX_SPACE = 125;
    private static final int BOX_COUNT = 4;

    private Bunny bunny;
    private Texture background;
    private Array<HitBox> boxes;

    // find image for bunny then set camera on bunny
    protected PlayState(GameStateManager inputGame) {
        super(inputGame);
        bunny = new Bunny(20, 300);
        camera.setToOrtho(false, 240, 400);
        background = new Texture("background.png");
        boxes = new Array<HitBox>();
        for (int i = 1; i <= BOX_COUNT; i++) {
            boxes.add(new HitBox(i * (BOX_SPACE + HitBox.BOX_WIDTH)));
        }
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            bunny.jump();
        }
    }

    @Override
    public void update(float oat) {
        handleInput();
        bunny.update(oat);
        camera.position.x = bunny.getPosition().x + 80;

        for (HitBox box : boxes) {
            if (camera.position.x - (camera.viewportWidth / 2) > box.getTopPosition().x + box.getTopBox().getWidth()) {
                box.reposition(box.getTopPosition().x + ((box.BOX_WIDTH + BOX_SPACE) * BOX_COUNT));
            }

            if(box.collision(bunny.getBunnyBounds())) {
                game.set(new PlayState(game));
            }
        }
        camera.update();
    }

    // before statebatch.draw(bird) find an image for bird
    @Override
    public void render(SpriteBatch stateBatch) {
        stateBatch.setProjectionMatrix(camera.combined);
        stateBatch.begin();
        stateBatch.draw(background, camera.position.x - (camera.viewportWidth / 2), 0);
        stateBatch.draw(bunny.getAnimation(), bunny.getPosition().x, bunny.getPosition().y);
        for (HitBox box : boxes) {
            stateBatch.draw(box.getTopBox(), box.getTopPosition().x, box.getTopPosition().y);
            stateBatch.draw(box.getBottomBox(), box.getBottomPosition().x, box.getBottomPosition().y);
        }
        stateBatch.end();
    }

    @Override
    public void dispose() {

    }
}
