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
import com.legend.game.Buttons.ActualGameButtons;
import com.legend.game.Buttons.Controller;
import com.legend.game.HUD.HUD;
import com.legend.game.LeGENDGAME;
import com.legend.game.States.GameMenu;
import com.legend.game.States.GameState;
import com.legend.game.States.GameStateManager;
import com.sun.xml.internal.bind.v2.TODO;

/**
 * Created by Patrick Sky on 2/25/2017.
 */

public class Haran extends GameState {

    private Stage stage;
    private OrthographicCamera camera;

    private MainCharacter mainCharacter;
    private HUD hud;
    private Controller controller;
    private ActualGameButtons actualGameButtons;

    private TmxMapLoader mapLoader;//load the map into the game
    private TiledMap map; // the map itself
    private IsometricTiledMapRenderer renderer; // it renders the map into the screen





    public Haran(final GameStateManager gsm){
        super(gsm);

        mainCharacter = new MainCharacter();
        controller = new Controller();
        hud = new HUD();
        actualGameButtons = new ActualGameButtons();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, LeGENDGAME.WIDTH, LeGENDGAME.HEIGHT);
        stage = new Stage(gameView);

        Gdx.input.setInputProcessor(new InputMultiplexer(controller.getStageC(), actualGameButtons.getStage()));

        mapLoader = new TmxMapLoader();
        map = mapLoader.load("tiledmaps/Haran.tmx");
        renderer = new IsometricTiledMapRenderer(map, 2f);
        camera.position.set((gameView.getWorldWidth() / 2) + (gameView.getWorldWidth() / 12) , 0, 0);


        actualGame();
        camera.update();

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

        if (mainCharacter.getCamera().position.x < -786) {
        }

        if (mainCharacter.getCamera().position.x > 644) {
        }

        if (mainCharacter.getCamera().position.z > 359) {

        }

        if (mainCharacter.getCamera().position.z < -273) {

        }

        if (controller.isLeftPressed()){
            mainCharacter.walkLeft();
        }
        else if (controller.isRightPressed()){
            mainCharacter.walkRight();
        }
        else if (controller.isUpPressed()){
            mainCharacter.walkUp();
        }
        else if (controller.isDownPressed()){
            mainCharacter.walkDown();
        }


    }

    @Override
    public void update(float dt) {
        handleInput();
        camera.update();
        renderer.setView(camera);

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
