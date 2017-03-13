package com.legend.game.LoadMaps;

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
import com.legend.game.Buttons.BackButton;
import com.legend.game.Buttons.Controller;
import com.legend.game.States.GameMenu;
import com.legend.game.States.GameState;
import com.legend.game.States.GameStateManager;
import com.legend.game.States.LoadStates;

/**
 * Created by Patrick Sky on 3/2/2017.
 */

public class LoadNumbers extends GameState {

    private Stage stage;

//    private MainCharacter mainCharacter;
//    private Controller controller;

    private TmxMapLoader mapLoader;//load the map into the game
    private TiledMap map; // the map itself
    private IsometricTiledMapRenderer renderer; // it renders the map into the screen

    private BackButton backButton;

    public LoadNumbers(final GameStateManager gsm) {
        super(gsm);

        stage = new Stage(gameView);
        backButton = new BackButton();

        Gdx.input.setInputProcessor(backButton.getStage());


        mapLoader = new TmxMapLoader();
        map = mapLoader.load("tiledmaps/Numbers.tmx");
        renderer = new IsometricTiledMapRenderer(map, 0.6f);
        gameCam.position.set(1546,-21,0);

        backButton.getStage().addActor(backButton.getTable());

        backButton.getBtnBack().addListener(new ClickListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int point, int button){

                gsm.set(new LoadStates(gsm));

                return true;
            }

        });



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

//        mainCharacter.render();
//        controller.render();
        backButton.getStage().draw();

    }

    @Override
    public void dispose() {

    }

    @Override
    public void resize(int width, int height) {

    }
}
