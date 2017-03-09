package com.legend.game.States;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
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
    private Stage stage;
    private Image bg;

    private Music splashSound;
    public SplashScreen(GameStateManager gsm) {
        super(gsm);
        cam = new OrthographicCamera();
        cam.setToOrtho(false, LeGENDGAME.WIDTH, LeGENDGAME.HEIGHT);
        stage = new Stage();
        splashBackground = new Texture("DevocatLogo.png");
        splashSound = Gdx.audio.newMusic(Gdx.files.internal("splash screen.MP3"));
        splashSound.setLooping(true);
        splashSound.setVolume(5f);
        splashSound.play();

        bg = new Image(splashBackground);
        stage.addActor(bg);

        stage.addAction(Actions.sequence(Actions.alpha(0),Actions.fadeIn(1)));
    }

    @Override
    public void handleInput() {

        if (!timerIsOn){
            timerIsOn = true;

            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    LeGENDGAME.backgroundMusic.play();
                    stage.addAction(Actions.fadeOut(1));
                    gsm.set(new GameMenu(gsm));
                    dispose();
                }
            }, 3);
        }

        else if(Gdx.input.justTouched()){
            LeGENDGAME.backgroundMusic.play();
            stage.addAction(Actions.fadeOut(1));
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
        stage.draw();
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
