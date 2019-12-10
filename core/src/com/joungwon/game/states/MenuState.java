package com.joungwon.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.joungwon.game.MoonBunny;

public class MenuState extends State {
    private Texture background;
    private Texture playButton;
    public MenuState(GameStateManager inputGame) {
        super(inputGame);
        background = new Texture("background.png");
        playButton = new Texture("playbutton.png");
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            game.set(new PlayState(game));
        }
    }

    @Override
    public void update(float oat) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch stateBatch) {
        stateBatch.begin();
        stateBatch.draw(background, 0, 0, 480, 800);
        stateBatch.draw(playButton, 90, MoonBunny.HEIGHT / 2);
        stateBatch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playButton.dispose();
    }
}
