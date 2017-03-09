package com.legend.game.CutScenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.legend.game.LoadMaps.LoadExodus;
import com.legend.game.States.GameState;
import com.legend.game.States.GameStateManager;

/**
 * Created by Patrick Sky on 3/2/2017.
 */

public class ExodusIntro extends GameState {

    private Image story;
    private ImageButton btnNext;
    private Stage stage;

    int click = 0;

    public ExodusIntro(final GameStateManager gsm) {
        super(gsm);

        stage = new Stage(gameView);
        Gdx.input.setInputProcessor(stage);
        story = new Image(new Texture("cutscenes/1-4.jpg"));
        story.setPosition(-stage.getWidth() / 1.4f, -stage.getHeight() + (-stage.getHeight() / 1.65f)); // first scene
        story.setScale(.7f,.7f);

        btnNext = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("nextandplayButton.png"))));
        btnNext.setPosition(stage.getWidth() - (stage.getWidth() / 8), stage.getHeight() / 8);

        btnNext.addListener(new ClickListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                click = 1 + click;

                if (click == 1) {
                    story.setPosition(-stage.getWidth(), -stage.getHeight() + (-stage.getHeight() / 1.65f)); // second scene
                }

                if (click == 2) {
                    story.setPosition(-stage.getWidth() / 3, 0); // pharaoh tries to destroy israel
                }
                if (click == 3) {
                    story.setPosition(-stage.getWidth() + (-stage.getWidth() / 2), -stage.getHeight() / 12); // last
                }
                if (click == 4) {
                    gsm.set(new LoadExodus(gsm));
                }


                return false;
            }
        });

        stage.addActor(story);
        stage.addActor(btnNext);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        stage.draw();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void resize(int width, int height) {

    }
}
