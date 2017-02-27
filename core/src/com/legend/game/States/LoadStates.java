package com.legend.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;

/**
 * Created by Patrick Sky on 2/13/2017.
 */

public class LoadStates extends GameState {

    private Stage stage;
    private Image map;
    private Texture backTxr;


    public LoadStates (final GameStateManager gsm){
        super(gsm);

        stage = new Stage(new StretchViewport(1280, 720));
        map = new Image(new Texture("mapdungeon.jpg"));
        stage.addActor(map);
        Gdx.input.setInputProcessor(stage);

        backTxr = new Texture("back.png");
        Drawable drawable = new TextureRegionDrawable(new TextureRegion(backTxr));
        ImageButton btnBack = new ImageButton(drawable);
        btnBack.setPosition(stage.getWidth() - (stage.getWidth() / 8), stage.getHeight() / 8);

        btnBack.addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent e, float x, float y, int point, int button){
                gsm.set(new GameMenu(gsm));
            }
        });
        stage.addActor(btnBack);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
    }

    @Override
    public void render(SpriteBatch sb) {
        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void resize(int width, int height) {

    }
}
