package com.legend.game.States;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.legend.game.HUD.HUD;
import com.legend.game.LeGENDGAME;


/**
 * Created by Patrick Sky on 11/25/2016.
 */

public abstract class GameState {

    protected OrthographicCamera gameCam;
    protected Viewport gameView;
    protected GameStateManager gsm;


    protected GameState(GameStateManager gsm){
        this.gsm = gsm;
        gameCam = new OrthographicCamera();
        gameCam.setToOrtho(false, LeGENDGAME.WIDTH, LeGENDGAME.HEIGHT);
        gameView = new StretchViewport(1280, 720, gameCam);
    }

    protected abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();
    public abstract void resize(int width, int height);
}
