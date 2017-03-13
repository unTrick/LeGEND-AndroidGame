package com.legend.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.legend.game.LeGENDGAME;

/**
 * Created by Patrick Sky on 2/15/2017.
 */

public class MenuSetting extends GameState {

    private Texture turnOff, turnOn, menu, bg;
    private Stage stage;

    public MenuSetting(final GameStateManager gsm){
        super(gsm);
        stage = new Stage(gameView);
        turnOff = new Texture("MusicTOff.png");
        turnOn = new Texture("MusicTO.png");
        menu = new Texture("back.png");
        bg = new Texture("GameMenuBG.jpg");

        Gdx.input.setInputProcessor(stage);

        Drawable turnOffDraw = new TextureRegionDrawable(new TextureRegion(turnOff));
        Drawable turnOnDraw = new TextureRegionDrawable(new TextureRegion(turnOn));
        Drawable menuDraw = new TextureRegionDrawable(new TextureRegion(menu));

        ImageButton btnTurnOff = new ImageButton(turnOffDraw);
        ImageButton btnTurnOn = new ImageButton(turnOnDraw);
        ImageButton btnMenu = new ImageButton(menuDraw);

        Table table = new Table();
        table.center().padTop(50);
        table.setFillParent(true);

        table.add(btnTurnOff).padTop(100);
        table.row();
        table.add(btnTurnOn).padTop(20);
        table.row();
        table.add(btnMenu).padTop(100).padLeft(1000);

        stage.addActor(table);


        btnTurnOff.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent e, float x, float y, int point, int button) {
                LeGENDGAME.backgroundMusic.pause();
                return false;
            }
        });

        btnTurnOn.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent e, float x, float y, int point, int button){
                LeGENDGAME.backgroundMusic.play();
                return false;
            }
        });

        btnMenu.addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent e, float x, float y, int point, int button){
                gsm.set(new GameMenu(gsm));
                dispose();
            }
        });
    }


    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        handleInput();

    }

    @Override
    public void render(SpriteBatch sb) {

        sb.begin();
        sb.draw(bg, 0, 0);
        sb.end();
        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        bg.dispose();
    }

    @Override
    public void resize(int width, int height) {

    }
}
