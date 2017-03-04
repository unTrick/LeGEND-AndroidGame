package com.legend.game.LoadMaps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.legend.game.BlenderObjects.MainCharacter;
import com.legend.game.Buttons.ActualGameButtons;
import com.legend.game.Buttons.Controller;
import com.legend.game.HUD.HUD;
import com.legend.game.LeGENDGAME;
import com.legend.game.States.GameState;
import com.legend.game.States.GameStateManager;

/**
 * Created by Patrick Sky on 3/2/2017.
 */

public class LoadDeuteronomy extends GameState{

    private Stage stage;

//    private MainCharacter mainCharacter;
//    private Controller controller;

    private TmxMapLoader mapLoader;//load the map into the game
    private TiledMap map; // the map itself
    private IsometricTiledMapRenderer renderer; // it renders the map into the screen

    public LoadDeuteronomy(GameStateManager gsm) {
        super(gsm);
//        mainCharacter = new MainCharacter(LeGENDGAME.WIDTH / 2 , 500, LeGENDGAME.HEIGHT / 2);
//        controller = new Controller();

        stage = new Stage(gameView);

        mapLoader = new TmxMapLoader();
        map = mapLoader.load("tiledmaps/Genesis.tmx");
        renderer = new IsometricTiledMapRenderer(map, 2f);
        gameCam.position.set((gameView.getWorldWidth() / 2) + (gameView.getWorldWidth() / 12) , 0, 0);
    }

    @Override
    protected void handleInput() {

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

    }

    @Override
    public void dispose() {

    }

    @Override
    public void resize(int width, int height) {

    }
}

