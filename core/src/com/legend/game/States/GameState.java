package com.legend.game.States;


import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
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


    protected void walkLeft(){
        gameCam.translate(-3, -2, 0); // Left
    }

    protected void walkRight(){
        gameCam.translate(3, 2, 0); // Right
    }

    protected void walkUp(){
        gameCam.translate(-3, 2, 0); // Up
    }

    protected void walkDown(){
        gameCam.translate(3, -2, 0); // Down
    }

    protected abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();
    public abstract void resize(int width, int height);
}
