package com.matsemann.libgdxloadingscreen.screen;

import com.badlogic.gdx.Screen;
import com.matsemann.libgdxloadingscreen.SomeCoolGame;

/**
 * @author Mats Svensson
 */
public abstract class AbstractScreen implements Screen {

    protected SomeCoolGame game;

    public AbstractScreen(SomeCoolGame game) {
        this.game = game;
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
}
