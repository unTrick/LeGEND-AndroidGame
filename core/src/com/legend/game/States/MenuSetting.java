package com.legend.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.legend.game.LeGENDGAME;

/**
 * Created by Patrick Sky on 2/15/2017.
 */

public class MenuSetting extends GameState {

    private Texture turnOff, turnOn, menu, bg, musicBG, musicknob;
    private Stage stage;
    private Label musicVol, soundVol;
    private Slider musicSlider;

    public MenuSetting(final GameStateManager gsm){
        super(gsm);

        FileHandle fontFile = Gdx.files.internal("font/Candarab.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 30;
        BitmapFont font = generator.generateFont(parameter);

        stage = new Stage(gameView);
        turnOff = new Texture("MusicTOff.png");
        turnOn = new Texture("MusicTO.png");
        menu = new Texture("back.png");
        bg = new Texture("GameMenuBG.jpg");
        musicBG = new Texture("sliderforMusic.png");
        musicknob = new Texture("musicknob.png");

        Image background = new Image(bg);

        Gdx.input.setInputProcessor(stage);

        stage.addActor(background);

        Drawable turnOffDraw = new TextureRegionDrawable(new TextureRegion(turnOff));
        Drawable turnOnDraw = new TextureRegionDrawable(new TextureRegion(turnOn));
        Drawable menuDraw = new TextureRegionDrawable(new TextureRegion(menu));

        ImageButton btnTurnOff = new ImageButton(turnOffDraw);
        ImageButton btnTurnOn = new ImageButton(turnOnDraw);
        ImageButton btnMenu = new ImageButton(menuDraw);

        Drawable musicBGDraw = new TextureRegionDrawable(new TextureRegion(musicBG));
        Drawable musicKnobDraw = new TextureRegionDrawable(new TextureRegion(musicknob));


        musicVol = new Label("Music Volume", new Label.LabelStyle(font, Color.WHITE));

        musicSlider = new Slider(1,20,2,false, new Slider.SliderStyle(musicBGDraw, musicKnobDraw));

        musicSlider.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                    if (musicSlider.getValue() == 1){
                        LeGENDGAME.backgroundMusic.setVolume(0);
                        LeGENDGAME.storyMusic.setVolume(0);
                    }
                    else if  (musicSlider.getValue() == 2){
                        LeGENDGAME.backgroundMusic.setVolume(0.1f);
                        LeGENDGAME.storyMusic.setVolume(0.1f);

                    }
                    else if (musicSlider.getValue() == 4){
                        LeGENDGAME.backgroundMusic.setVolume(0.2f);
                        LeGENDGAME.storyMusic.setVolume(0.2f);

                    }
                    else if (musicSlider.getValue() == 6){
                        LeGENDGAME.backgroundMusic.setVolume(0.3f);
                        LeGENDGAME.storyMusic.setVolume(0.3f);

                    }
                    else if (musicSlider.getValue() == 8){
                        LeGENDGAME.backgroundMusic.setVolume(0.4f);
                        LeGENDGAME.storyMusic.setVolume(0.4f);

                    }
                    else if (musicSlider.getValue() == 10){
                        LeGENDGAME.backgroundMusic.setVolume(0.5f);
                        LeGENDGAME.storyMusic.setVolume(0.5f);

                    }
                    else if (musicSlider.getValue() == 12){
                        LeGENDGAME.backgroundMusic.setVolume(0.6f);
                        LeGENDGAME.storyMusic.setVolume(0.6f);

                    }
                    else if (musicSlider.getValue() == 14){
                        LeGENDGAME.backgroundMusic.setVolume(0.7f);
                        LeGENDGAME.storyMusic.setVolume(0.7f);


                    }
                    else if (musicSlider.getValue() == 16) {
                        LeGENDGAME.backgroundMusic.setVolume(0.8f);
                        LeGENDGAME.storyMusic.setVolume(0.8f);

                    }
                    else if (musicSlider.getValue() == 18) {
                        LeGENDGAME.backgroundMusic.setVolume(0.9f);
                        LeGENDGAME.storyMusic.setVolume(0.9f);


                    }
                    else if (musicSlider.getValue() == 20) {
                        LeGENDGAME.backgroundMusic.setVolume(1);
                        LeGENDGAME.storyMusic.setVolume(1);

                    }
            }
        });

        final Table table = new Table();
        table.center().padTop(50);
        table.setFillParent(true);

        table.add(musicVol).padTop(100).padLeft(200);
        table.add(musicSlider).padTop(100).left().padRight(400);
        table.row();
        table.add().padTop(100).expandX();
        table.add(btnMenu).padTop(100).right().padRight(50);

        stage.addActor(table);



        btnTurnOff.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent e, float x, float y, int point, int button) {
                LeGENDGAME.backgroundMusic.setVolume(0);
                LeGENDGAME.storyMusic.setVolume(0);
                LeGENDGAME.clickSound.setVolume(0,0);
                return true;
            }
        });

        btnTurnOn.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent e, float x, float y, int point, int button){
                LeGENDGAME.backgroundMusic.setVolume(0.5f);
                LeGENDGAME.clickSound.setVolume(0,1);
                LeGENDGAME.storyMusic.setVolume(0.5f);
                return true;
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
