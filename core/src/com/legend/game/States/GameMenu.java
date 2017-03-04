package com.legend.game.States;

        import com.badlogic.gdx.Gdx;
        import com.badlogic.gdx.audio.Sound;
        import com.badlogic.gdx.graphics.Texture;
        import com.badlogic.gdx.graphics.g2d.SpriteBatch;
        import com.badlogic.gdx.graphics.g2d.TextureRegion;
        import com.badlogic.gdx.scenes.scene2d.InputEvent;
        import com.badlogic.gdx.scenes.scene2d.Stage;
        import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
        import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
        import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
        import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
        import com.badlogic.gdx.utils.Timer;
        import com.badlogic.gdx.utils.viewport.StretchViewport;
        import com.legend.game.CutScenes.GenesisIntro;
        import com.legend.game.LeGENDGAME;
        import com.legend.game.Maps.Haran;

/**
 * Created by Patrick Sky on 11/26/2016.
 */

public class GameMenu extends GameState{

    private Texture background, start, load, setting, help, book, exit;
    private Sound clickSound;
    private Stage stage;
    //private ImageButton btnStart, btnLoad, btnSetting, btnHelp, btnBook;


    public GameMenu(final GameStateManager gsm) {
        super(gsm);
        background = new Texture("GameMenuBG.jpg");
        clickSound = Gdx.audio.newSound(Gdx.files.internal("button-16.mp3"));
        stage = new Stage(new StretchViewport(1280, 720));
        new Timer().stop();

        Gdx.input.setInputProcessor(stage);

        start = new Texture("start.png");
        Drawable drawStart = new TextureRegionDrawable(new TextureRegion(start));
        ImageButton btnStart = new ImageButton(drawStart);
        btnStart.setPosition((stage.getWidth() / 2) - ((start.getWidth() / 2) + (stage.getWidth() / 5)), (stage.getHeight() / 4) - (start.getHeight() / 2));
        stage.addActor(btnStart);

        btnStart.addListener(new ClickListener(){
           @Override
            public void touchUp(InputEvent e, float x, float y, int point, int button){
                dispose();
                gsm.set(new GenesisIntro(gsm));
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
            public void touchUp(InputEvent e, float x, float y, int point, int button){
                gsm.set(new BibleBook(gsm));
            }
        });

        exit = new Texture("close.png");
        Drawable drawExit = new TextureRegionDrawable(new TextureRegion(exit));
        ImageButton btnExit = new ImageButton(drawExit);
        btnExit.setPosition(stage.getWidth() - (stage.getWidth() / 16), stage.getHeight() - (stage.getHeight() / 12));
        btnExit.setSize(50,50);
        stage.addActor(btnExit);

        btnExit.addListener(new ClickListener(){
           @Override
            public void touchUp(InputEvent e, float x, float y, int point, int button){
                Gdx.app.exit();
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
        sb.begin();
        sb.draw(background, 0, 0);
        sb.end();
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }


    @Override
    public void dispose() {
        background.dispose();
        clickSound.dispose();
        LeGENDGAME.backgroundMusic.dispose();
    }

}
