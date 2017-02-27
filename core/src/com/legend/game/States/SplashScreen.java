package com.legend.game.States;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.legend.game.LeGENDGAME;

import javafx.stage.Screen;

/**
 * Created by Patrick Sky on 11/26/2016.
 */

public class SplashScreen extends GameState {

    private Texture splashBackground;
    private OrthographicCamera cam;
    private boolean timerIsOn = false;

    private Music splashSound;
    public SplashScreen(GameStateManager gsm) {
        super(gsm);
        cam = new OrthographicCamera();
        cam.setToOrtho(false, LeGENDGAME.WIDTH, LeGENDGAME.HEIGHT);
        splashBackground = new Texture("DevocatLogo.png");
        splashSound = Gdx.audio.newMusic(Gdx.files.internal("splash screen.MP3"));
        splashSound.setLooping(true);
        splashSound.setVolume(5f);
        splashSound.play();
    }

    @Override
    public void handleInput() {

        if (!timerIsOn){
            timerIsOn = true;

            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    gsm.set(new GameMenu(gsm));
                    dispose();
                }
            }, 3);
        }

        else if(Gdx.input.justTouched()){
            LeGENDGAME.backgroundMusic.play();
            gsm.set(new GameMenu(gsm));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(splashBackground, 0,0, cam.viewportWidth, cam.viewportHeight);
        sb.end();
    }

    @Override
    public void dispose() {
        splashBackground.dispose();
        splashSound.dispose();

    }

    @Override
    public void resize(int width, int height) {

    }
}
