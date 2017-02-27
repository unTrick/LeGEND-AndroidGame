package com.legend.game.Maps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.legend.game.BlenderObjects.MainCharacter;
import com.legend.game.BlenderObjects.RandomPersonOne;
import com.legend.game.BlenderObjects.RandomPersonTwo;
import com.legend.game.Buttons.ActualGameButtons;
import com.legend.game.Buttons.Controller;
import com.legend.game.HUD.HUD;
import com.legend.game.LeGENDGAME;
import com.legend.game.States.GameMenu;
import com.legend.game.States.GameState;
import com.legend.game.States.GameStateManager;

/**
 * Created by Patrick Sky on 2/25/2017.
 */

public class Haran extends GameState {

    private Stage stage;

    private MainCharacter mainCharacter;
    private RandomPersonOne randomPersonOne;
    private RandomPersonTwo randomPersonTwo;

    private HUD hud;
    private Controller controller;
    private ActualGameButtons actualGameButtons;

    private TmxMapLoader mapLoader;//load the map into the game
    private TiledMap map; // the map itself
    private IsometricTiledMapRenderer renderer; // it renders the map into the screen

    public Haran(final GameStateManager gsm){
        super(gsm);

        mainCharacter = new MainCharacter();
        randomPersonOne = new RandomPersonOne();
        randomPersonTwo = new RandomPersonTwo();

        controller = new Controller();
        hud = new HUD();
        actualGameButtons = new ActualGameButtons();
        stage = new Stage(gameView);

        Gdx.input.setInputProcessor(new InputMultiplexer(controller.getStageC(), actualGameButtons.getStage()));

        mapLoader = new TmxMapLoader();
        map = mapLoader.load("tiledmaps/Haran.tmx");
        renderer = new IsometricTiledMapRenderer(map, 2f);
        gameCam.position.set((gameView.getWorldWidth() / 2) + (gameView.getWorldWidth() / 12) , 0, 0);


        actualGame();
        gameCam.update();

    }

    private void actualGame(){

        controller.getStageC().addActor(controller.getBtnUp());
        controller.getStageC().addActor(controller.getBtnDown());
        controller.getStageC().addActor(controller.getBtnLeft());
        controller.getStageC().addActor(controller.getBtnRight());

        actualGameButtons.getStage().addActor(actualGameButtons.getBtnHome());

        actualGameButtons.getBtnHome().addListener(new ClickListener(){

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                gsm.set(new GameMenu(gsm));
            }
        });


    }


    @Override
    protected void handleInput() {



        if (controller.isLeftPressed()){
            mainCharacter.walkLeft();
//            walkLeft();
        }
        else if (controller.isRightPressed()){
           mainCharacter.walkRight();
//            walkRight();

        }
        else if (controller.isUpPressed()){
            mainCharacter.walkUp();
//            walkUp();
        }
        else if (controller.isDownPressed()){
            mainCharacter.walkDown();
//            walkDown();
        }


    }

    @Override
    public void update(float dt) {
        handleInput();


        gameCam.update();
        renderer.setView(gameCam);

        randomPersonTwo.update();
        randomPersonOne.update();
        mainCharacter.update();
        hud.update(dt);

    }


    @Override
    public void render(SpriteBatch sb) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        renderer.render();

        stage.act();
        stage.draw();

        mainCharacter.render();
        randomPersonOne.render();
        randomPersonTwo.render();

        controller.render();
        actualGameButtons.getStage().draw();
        hud.stage.draw();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void resize(int width, int height) {

    }
}