package com.matsemann.libgdxloadingscreen.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.matsemann.libgdxloadingscreen.SomeCoolGame;

/**
 * @author Mats Svensson
 */
public class LoadingScreen extends AbstractScreen {

    private Stage stage;

    private Image logo;
    private Image loadingBar;
    private Image loadingFrame;
    private Image loadingBarHidden;
    private Image screenBg;
    private Image loadingBg;

    private float percent;
    private float startX, endX;

    public LoadingScreen(SomeCoolGame game) {
        super(game);
    }

    @Override
    public void show() {
        game.manager.load("data/loading.pack", TextureAtlas.class);
        game.manager.finishLoading();

        TextureAtlas atlas = game.manager.get("data/loading.pack", TextureAtlas.class);

        stage = new Stage();

        logo = new Image(atlas.findRegion("libgdx-logo"));
        loadingBar = new Image(atlas.findRegion("loading-bar"));
        loadingFrame = new Image(atlas.findRegion("loading-frame"));
        loadingBarHidden = new Image(atlas.findRegion("loading-bar-hidden"));
        screenBg = new Image(atlas.findRegion("screen-bg"));
        loadingBg = new Image(atlas.findRegion("loading-frame-bg"));

        stage.addActor(screenBg);
        stage.addActor(loadingBar);
        stage.addActor(loadingBg);
        stage.addActor(loadingBarHidden);
        stage.addActor(loadingFrame);
        stage.addActor(logo);

        percent = 0;
    }

    @Override
    public void resize(int width, int height) {
        stage.setViewport(800, 800 * height / width, false);

        screenBg.setSize(stage.getWidth(), stage.getHeight());

        logo.setX((stage.getWidth() - logo.getWidth()) / 2);
        logo.setY((stage.getHeight() - logo.getHeight()) / 2 + 100);

        loadingFrame.setX((stage.getWidth() - loadingFrame.getWidth()) / 2);
        loadingFrame.setY((stage.getHeight() - loadingFrame.getHeight()) / 2);

        loadingBar.setX(loadingFrame.getX() + 15);
        loadingBar.setY(loadingFrame.getY() + 5);

        loadingBarHidden.setX(loadingBar.getX() + 35);
        loadingBarHidden.setY(loadingBar.getY() - 3);
        startX = loadingBarHidden.getX();
        endX = 440;

        loadingBg.setSize(450, 50);
        loadingBg.setX(loadingBarHidden.getX() + 30);
        loadingBg.setY(loadingBarHidden.getY() + 3);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        percent +=  delta / 4.0f;

        if (percent > 1.0f) {
            percent = 1.0f;
        }

        loadingBarHidden.setX(startX + endX * percent);
        loadingBg.setX(loadingBarHidden.getX() + 30);
        loadingBg.setWidth(450 - 450 * percent);
        loadingBg.invalidate();

        stage.draw();
    }

    @Override
    public void hide() {
    }
}
