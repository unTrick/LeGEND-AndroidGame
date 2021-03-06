package com.legend.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.legend.game.CutScenes.ExodusIntro;
import com.legend.game.CutScenes.LeviticusIntro;
import com.legend.game.LoadMaps.LoadDeuteronomy;
import com.legend.game.LoadMaps.LoadExodus;
import com.legend.game.LoadMaps.LoadGenesis;
import com.legend.game.LoadMaps.LoadLeviticus;
import com.legend.game.LoadMaps.LoadNumbers;

/**
 * Created by Patrick Sky on 2/13/2017.
 */

public class LoadStates extends GameState {

    private Stage stage;
    private Image background;
    private Texture backTxr, gen, exo, levi, numb, deu;
    private Label title;
    BitmapFont font;

    public LoadStates (final GameStateManager gsm){
        super(gsm);

        stage = new Stage(gameView);
        background = new Image(new Texture("GameMenuBG.jpg"));
        stage.addActor(background);
        Gdx.input.setInputProcessor(stage);

        FileHandle fontFile = Gdx.files.internal("font/Candarab.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter contentParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        contentParameter.size = 50;
        font = generator.generateFont(contentParameter);

        backTxr = new Texture("back.png");
        gen = new Texture("Book/genesisIcon.png");
        exo = new Texture("Book/exodusIcon.png");
        levi = new Texture("Book/leviticusIcon.png");
        numb = new Texture("Book/numbersIcon.png");
        deu = new Texture("Book/deuteronomyIcon.png");

        title = new Label("Level Selection Menu", new Label.LabelStyle(font, Color.WHITE));
        title.setPosition((stage.getWidth() / 2) - (title.getWidth() / 2), 180);

        Drawable backDraw = new TextureRegionDrawable(new TextureRegion(backTxr));
        Drawable genDraw = new TextureRegionDrawable(new TextureRegion(gen));
        Drawable exoDraw = new TextureRegionDrawable(new TextureRegion(exo));
        Drawable leviDraw = new TextureRegionDrawable(new TextureRegion(levi));
        Drawable numbDraw = new TextureRegionDrawable(new TextureRegion(numb));
        Drawable deuDraw = new TextureRegionDrawable(new TextureRegion(deu));

        ImageButton btnBack = new ImageButton(backDraw);
        ImageButton btnGen = new ImageButton(genDraw);
        ImageButton btnExo = new ImageButton(exoDraw);
        ImageButton btnLevi = new ImageButton(leviDraw);
        ImageButton btnNumb = new ImageButton(numbDraw);
        ImageButton btnDeu = new ImageButton(deuDraw);

        btnGen.setSize(200, 200);
        btnExo.setSize(200, 200);
        btnLevi.setSize(200, 200);
        btnNumb.setSize(200, 200);
        btnDeu.setSize(200, 200);


        btnBack.setPosition(stage.getWidth() - (stage.getWidth() / 8), stage.getHeight() / 8);
        btnGen.setPosition((stage.getWidth() / 2) - ((stage.getWidth() / 4) + (btnGen.getWidth() / 2)), (stage.getHeight() /2) - (gen.getHeight() / 4));
        btnExo.setPosition((stage.getWidth() / 2) - ((stage.getWidth() / 8) + (btnExo.getWidth() / 2)), (stage.getHeight() /2) - (exo.getHeight() / 4));
        btnLevi.setPosition((stage.getWidth() / 2) - (btnLevi.getWidth() / 2), (stage.getHeight() /2) - (levi.getHeight() / 4));
        btnNumb.setPosition((stage.getWidth() / 2) + ((stage.getWidth() / 8) - (btnNumb.getWidth() / 2)), (stage.getHeight() /2) - (numb.getHeight() / 4));
        btnDeu.setPosition(stage.getWidth() - ((stage.getWidth() / 4) + (btnDeu.getWidth() / 2)), (stage.getHeight() /2) - (deu.getHeight() / 4));

        btnBack.addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent e, float x, float y, int point, int button){
                gsm.set(new GameMenu(gsm));
                dispose();
            }
        });

        btnGen.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent e, float x, float y, int point, int button){
                gsm.set(new LoadGenesis(gsm));
                dispose();
                return false;
            }
        });

        btnExo.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent e, float x, float y, int point, int button){
//                gsm.set(new LoadExodus(gsm));
                gsm.set(new ExodusIntro(gsm));
                dispose();
                return false;
            }
        });

        btnLevi.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent e, float x, float y, int point, int button){
                gsm.set(new LeviticusIntro(gsm));
                dispose();
                return false;
            }
        });

        btnNumb.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent e, float x, float y, int point, int button){
                gsm.set(new LoadNumbers(gsm));
                dispose();
                return false;
            }
        });

        btnDeu.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent e, float x, float y, int point, int button){
                gsm.set(new LoadDeuteronomy(gsm));
                dispose();
                return false;
            }
        });



        stage.addActor(btnBack);
        stage.addActor(btnGen);
        stage.addActor(btnExo);
        stage.addActor(btnLevi);
        stage.addActor(btnNumb);
        stage.addActor(btnDeu);
        stage.addActor(title);
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
        stage.dispose();
    }

    @Override
    public void resize(int width, int height) {

    }
}
