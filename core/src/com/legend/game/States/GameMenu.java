package com.legend.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.physics.bullet.softbody.btSoftBody;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.legend.game.CutScenes.GenesisIntro;
import com.legend.game.LeGENDGAME;

/**
 * Created by Patrick Sky on 11/26/2016.
 */

public class GameMenu extends GameState{

    private Texture background, start, load, setting, help, book, exit;

    private Stage stage;
    private Image bg;
    private TextButton btnAccount, btnOk;
    private Table tblAccount;
    private TextField user, pass;
    //private ImageButton btnStart, btnLoad, btnSetting, btnHelp, btnBook;


    private final static String STATUSUI_TEXTURE_ATLAS_PATH = "skin/statusui.atlas";
    private final static String STATUSUI_SKIN_PATH = "skin/statusui.json";

    public static TextureAtlas STATUSUI_TEXTUREATLAS;
    public static Skin STATUSUI_SKIN ;


    public GameMenu(final GameStateManager gsm) {
        super(gsm);
        background = new Texture("GameMenuBG.jpg");
        stage = new Stage(new StretchViewport(1280, 720));
        new Timer().stop();

        Gdx.input.setInputProcessor(stage);

        bg = new Image(background);
        stage.addActor(bg);

        FileHandle fontFile = Gdx.files.internal("font/Candarab.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 30;
        BitmapFont font = generator.generateFont(parameter);

        start = new Texture("start.png");
        Drawable drawStart = new TextureRegionDrawable(new TextureRegion(start));
        ImageButton btnStart = new ImageButton(drawStart);
        btnStart.setPosition((stage.getWidth() / 2) - ((start.getWidth() / 2) + (stage.getWidth() / 5)), (stage.getHeight() / 4) - (start.getHeight() / 2));
        stage.addActor(btnStart);

        btnStart.addListener(new ClickListener(){
           @Override
            public void touchUp(InputEvent e, float x, float y, int point, int button){

               LeGENDGAME.clickSound.play();
                gsm.set(new GenesisIntro(gsm));
                dispose();
           }
        });


        load = new Texture("load.png");
        Drawable drawLoad = new TextureRegionDrawable(new TextureRegion(load));
        ImageButton btnLoad = new ImageButton(drawLoad);
        btnLoad.setPosition((stage.getWidth() / 2) - (load.getWidth() / 2) - (stage.getWidth() / 14), (stage.getHeight() / 4) - (load.getHeight() / 2));
        stage.addActor(btnLoad);

        btnLoad.addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent e, float x, float y, int point, int button){
                LeGENDGAME.clickSound.play();
                gsm.set(new LoadStates(gsm));
            }
        });

        setting = new Texture("setting.png");
        Drawable drawSetting = new TextureRegionDrawable(new TextureRegion(setting));
        ImageButton btnSetting = new ImageButton(drawSetting);
        btnSetting.setPosition((stage.getWidth() / 2) - (setting.getWidth() / 2) + (stage.getWidth() / 14),(stage.getHeight() / 4) - (setting.getHeight() / 2) );
        stage.addActor(btnSetting);

        btnSetting.addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent e, float x, float y, int point, int button){
                LeGENDGAME.clickSound.play();
                gsm.set(new MenuSetting(gsm));
            }
        });

        help = new Texture("help.png");
        Drawable drawHelp = new TextureRegionDrawable(new TextureRegion(help));
        ImageButton btnHelp = new ImageButton(drawHelp);
        btnHelp.setPosition((stage.getWidth() / 2) - ((help.getWidth() / 2) - (stage.getWidth() / 5)), (stage.getHeight() / 4) - (help.getHeight() / 2));
        stage.addActor(btnHelp);

        btnHelp.addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent e, float x, float y, int point, int button){
                LeGENDGAME.clickSound.play();
                gsm.set(new GameHelp(gsm));
            }
        });

        book = new Texture("bookbutton.png");
        Drawable drawBook = new TextureRegionDrawable(new TextureRegion(book));
        ImageButton btnBook = new ImageButton(drawBook);
        btnBook.setPosition((stage.getWidth() / 2) - (book.getWidth() / 2), (stage.getHeight() / 12));
        stage.addActor(btnBook);

        btnBook.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent e, float x, float y){
                LeGENDGAME.clickSound.play();
                gsm.set(new BibleBook(gsm));
                dispose();

            }
        });

        Drawable down = new TextureRegionDrawable(new TextureRegion(new Texture("skin/downDrawable.png"), 200, 50));
        Drawable up = new TextureRegionDrawable(new TextureRegion(new Texture("skin/upDrawable.png"), 200, 50));

        btnAccount = new TextButton("User Account", new TextButton.TextButtonStyle(up,down,up,font));
        btnAccount.setPosition(stage.getWidth() - (stage.getWidth() / 4), stage.getHeight() - (stage.getHeight() / 10));

        exit = new Texture("close.png");
        Drawable drawExit = new TextureRegionDrawable(new TextureRegion(exit));
        ImageButton btnExit = new ImageButton(drawExit);
        btnExit.setPosition(stage.getWidth() - (stage.getWidth() / 16), stage.getHeight() - (stage.getHeight() / 12));
        btnExit.setSize(50,50);



        tblAccount = new Table();
        tblAccount.background(new TextureRegionDrawable(new TextureRegion(new Texture("popup/useraccount.png"), 500, 329)));
        tblAccount.setSize(500, 329);
//        tblAccount.top();
        tblAccount.setPosition((stage.getWidth() / 2) - (tblAccount.getWidth() / 2), (stage.getHeight() / 2) - (tblAccount.getHeight() / 2));

        Label lblAcc = new Label("User Account", new Label.LabelStyle(font, Color.BLACK));
        Label lblUsername = new Label("Username: ", new Label.LabelStyle(font, Color.BLACK));
        Label lblPassword = new Label("Password: ", new Label.LabelStyle(font, Color.BLACK));

        STATUSUI_TEXTUREATLAS = new TextureAtlas(STATUSUI_TEXTURE_ATLAS_PATH);
        STATUSUI_SKIN = new Skin(Gdx.files.internal(STATUSUI_SKIN_PATH), STATUSUI_TEXTUREATLAS);

        user = new TextField("", STATUSUI_SKIN);
        pass = new TextField("", STATUSUI_SKIN);


        ImageButton btnCloseAcc = new ImageButton(drawExit);
        btnOk = new TextButton("Login", new TextButton.TextButtonStyle(up,down,up,font));

        tblAccount.add().top().width(50);
        tblAccount.add().top().width(50);
        tblAccount.add(btnCloseAcc).top().width(50);
        tblAccount.row();
        tblAccount.add();
        tblAccount.add(lblAcc).padBottom(20);
        tblAccount.add();
        tblAccount.row();
        tblAccount.add(lblUsername);
        tblAccount.add();
        tblAccount.add(user);
        tblAccount.row();
        tblAccount.add(lblPassword);
        tblAccount.add();
        tblAccount.add(pass);
        tblAccount.row();
        tblAccount.add();
        tblAccount.add(btnOk).width(100).height(50);
        tblAccount.add();

        btnCloseAcc.addListener(new ClickListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                tblAccount.remove();

                return true;
            }
        });

        btnOk.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                tblAccount.remove();

                return true;
            }
        });


        btnAccount.addListener(new ClickListener(){


            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                stage.addActor(tblAccount);
                return true;
            }
        });






        stage.addActor(btnExit);
        stage.addActor(btnAccount);

        btnExit.addListener(new ClickListener(){
           @Override
            public void touchUp(InputEvent e, float x, float y, int point, int button){
                Gdx.app.exit();
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
        //backgroundMusic.play();
    }





    @Override
    public void render(SpriteBatch sb) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }


    @Override
    public void dispose() {
        background.dispose();
    }

}
