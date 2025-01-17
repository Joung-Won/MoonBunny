package com.joungwon.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class GameStateManager {

    private Stack<State> states;
    public GameStateManager() {
        states = new Stack<State>();
    }
    public void push(State state) {
        states.push(state);
    }
    public void pop() {
        states.pop().dispose();
    }
    public void set(State state) {
        states.pop().dispose();
        states.push(state);
    }
    public void update(float oat) {
        states.peek().update(oat);
    }
    public void render(SpriteBatch batch) {
        states.peek().render(batch);
    }
}
