package com.legend.game.CutScenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.legend.game.States.GameState;
import com.legend.game.States.GameStateManager;

/**
 * Created by Patrick Sky on 3/2/2017.
 */

public class LeviticusIntro extends GameState{

    private Image story;
    private ImageButton btnNext;
    private Stage stage;

    int click = 0;

    public LeviticusIntro(GameStateManager gsm) {
        super(gsm);

        stage = new Stage(gameView);
        Gdx.input.setInputProcessor(stage);
        story = new Image(new Texture("cutscenes/1-7.jpg"));
        story.setSize(story.getWidth() / 1.8f, story.getHeight() / 1.8f);

        btnNext = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("nextandplayButton.png"))));
        btnNext.setPosition(stage.getWidth() - (stage.getWidth() / 8), stage.getHeight() / 8);

        btnNext.addListener(new ClickListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

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

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void resize(int width, int height) {

    }
}
