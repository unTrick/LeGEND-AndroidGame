package com.legend.game.Screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.legend.game.LeGENDGAME;

/**
 * Created by Patrick Sky on 3/6/2017.
 */

public class GameScreen implements Screen {

    public OrthographicCamera screenCamera;
    public Viewport screenViewPort;

    public GameScreen() {

        screenCamera = new OrthographicCamera();
        screenCamera.setToOrtho(false, LeGENDGAME.WIDTH, LeGENDGAME.HEIGHT);
        screenViewPort = new StretchViewport(1280, 720, screenCamera);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public Viewport getScreenViewPort() {
        return screenViewPort;
    }
}
