package com.legend.game.Maps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.legend.game.BlenderObjects.MainCharacter;
import com.legend.game.BlenderObjects.RandomPersonOne;
import com.legend.game.BlenderObjects.RandomPersonTwo;
import com.legend.game.Buttons.ActualGameButtons;
import com.legend.game.Buttons.Controller;
import com.legend.game.HUD.HUD;
import com.legend.game.LeGENDGAME;
import com.legend.game.PopupBox.Inventory;
import com.legend.game.Screen.GameScreen;
import com.legend.game.States.GameMenu;
import com.legend.game.States.GameState;
import com.legend.game.States.GameStateManager;

/**
 * Created by Patrick Sky on 2/25/2017.
 */

public class Haran extends GameState {

    private Stage stage;

    private MainCharacter mainCharacter;

    private HUD hud;
    private Controller controller;
    private ActualGameButtons actualGameButtons;
    private Inventory inventory;

    private TmxMapLoader mapLoader;//load the map into the game
    private TiledMap map; // the map itself
    private IsometricTiledMapRenderer renderer; // it renders the map into the screen

    private GameScreen gameScreen;

    public Haran(final GameStateManager gsm){
        super(gsm);


//        mainCharacter = new MainCharacter(map);
        mainCharacter = new MainCharacter(628, 0, 156);

        gameScreen = new GameScreen();

        controller = new Controller();
        hud = new HUD();
        inventory = new Inventory();
        actualGameButtons = new ActualGameButtons();


        stage = new Stage(gameScreen.getScreenViewPort());

        Gdx.input.setInputProcessor(new InputMultiplexer(controller.getStageC(), actualGameButtons.getStage(), inventory.getStage()));

        mapLoader = new TmxMapLoader();
        map = mapLoader.load("tiledmaps/Haran.tmx");
        renderer = new IsometricTiledMapRenderer(map, 2f);


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

        actualGameButtons.getBtnInventory().addListener(new ClickListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                inventory.inventory();
                return false;
            }
        });

        inventory.getBtnclose().addListener(new ClickListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                inventory.close();
                return false;
            }
        });


    }


    @Override
    protected void handleInput() {



        if (controller.isLeftPressed()){
            if (actualGameButtons.isRunPressed()){
                mainCharacter.walkLeft(2);
            }
            else {
                mainCharacter.walkLeft(1);
//                mainCharacter.setLeft();
                System.out.println(gameCam.position);
            }

        }
        else if (controller.isRightPressed()){
            if (actualGameButtons.isRunPressed()){
                mainCharacter.walkRight(2);
            }
            else {
                mainCharacter.walkRight(1);
//                mainCharacter.setRight();
                System.out.println(gameCam.position);
            }

        }
        else if (controller.isUpPressed()){
            if (actualGameButtons.isRunPressed()){
                mainCharacter.walkUp(2);
            }
            else {
                mainCharacter.walkUp(1);
//                mainCharacter.setUp();
                System.out.println(gameCam.position);
            }

        }
        else if (controller.isDownPressed()){
            if (actualGameButtons.isRunPressed()){
                mainCharacter.walkDown(2);
            }
            else {
                mainCharacter.walkDown(1);
//                mainCharacter.setDown();
                System.out.println(gameCam.position);
            }

        }


    }

    @Override
    public void update(float dt) {
        gameCam.position.x = mainCharacter.getPosition().x;
        gameCam.position.y = mainCharacter.getPosition().z;

        renderer.setView(gameCam);
        mainCharacter.updateEntity(dt);
        hud.getMapName().setText("Haran");
        hud.updated(dt);
        gameCam.update();
        handleInput();

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
        inventory.getStage().draw();
        hud.stage.draw();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void resize(int width, int height) {

    }
}
