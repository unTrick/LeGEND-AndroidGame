package com.legend.game.LoadMaps;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.legend.game.Buttons.ActualGameButtons;
import com.legend.game.Buttons.Controller;
import com.legend.game.States.GameMenu;
import com.legend.game.States.GameState;
import com.legend.game.States.GameStateManager;
import com.legend.game.States.LoadStates;

/**
 * Created by Patrick Sky on 3/2/2017.
 */

public class LoadLeviticus extends GameState {

    private Stage stage;

//    private MainCharacter mainCharacter;
//    private Controller controller;

    private TmxMapLoader mapLoader;//load the map into the game
    private TiledMap map; // the map itself
    private IsometricTiledMapRenderer renderer; // it renders the map into the screen

    private Texture backTxr;

    private ActualGameButtons actualGameButtons;

    public LoadLeviticus(final GameStateManager gsm) {
        super(gsm);

        stage = new Stage(gameView);
        actualGameButtons = new ActualGameButtons();
        Gdx.input.setInputProcessor(actualGameButtons.getStage());

        mapLoader = new TmxMapLoader();
        map = mapLoader.load("tiledmaps/Leviticus.tmx");
        renderer = new IsometricTiledMapRenderer(map, 1f);
        gameCam.position.set(9698.667f,-804,0);

        backTxr = new Texture("back.png");
        Drawable backDraw = new TextureRegionDrawable(new TextureRegion(backTxr));
        ImageButton btnBack = new ImageButton(backDraw);
        btnBack.setPosition(stage.getWidth() - (stage.getWidth() / 8), stage.getHeight() / 8);

        btnBack.addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent e, float x, float y, int point, int button){
                gsm.set(new GameMenu(gsm));
            }
        });

        actualGameButtons.getBtnHome().addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent e, float x, float y, int point, int button){
                gsm.set(new LoadStates(gsm));
                dispose();
                return false;
            }
        });

        stage.addActor(btnBack);
        actualGameButtons.getStage().addActor(actualGameButtons.getBtnHome());

    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            System.out.println(gameCam.position);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            gameCam.translate(-6, 3, 0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            gameCam.translate(6, -3, 0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            gameCam.translate(-6, -3, 0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            gameCam.translate(6, 3, 0);
        }
    }

    @Override
    public void update(float dt) {
        handleInput();

        gameCam.update();
        renderer.setView(gameCam);


//        mainCharacter.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        renderer.render();

        stage.act();
        stage.draw();
        actualGameButtons.getStage().draw();

//        mainCharacter.render();
//        controller.render();

    }

    @Override
    public void dispose() {

    }

    @Override
    public void resize(int width, int height) {

    }
}
