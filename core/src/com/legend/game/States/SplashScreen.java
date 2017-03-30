package com.legend.game.States;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Timer;
import com.legend.game.LeGENDGAME;

/**
 * Created by Patrick Sky on 11/26/2016.
 */

public class SplashScreen extends GameState {

    private Texture splashBackground;
    private boolean timerIsOn = false;
    private Stage stage;
    private Image bg;

    public SplashScreen(GameStateManager gsm) {
        super(gsm);
        stage = new Stage(gameView);
        splashBackground = new Texture("DevocatLogo.png");
        LeGENDGAME.splashSound.play();

        bg = new Image(splashBackground);
        stage.addActor(bg);
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
        LeGENDGAME.splashSound.dispose();

    }

    @Override
    public void resize(int width, int height) {

    }
}
