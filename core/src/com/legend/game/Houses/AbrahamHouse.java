package com.legend.game.Houses;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.Map;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.legend.game.BlenderObjects.MainCharacter;
import com.legend.game.BlenderObjects.RandomPersonOne;
import com.legend.game.Buttons.ActualGameButtons;
import com.legend.game.Buttons.Controller;
import com.legend.game.HUD.HUD;
import com.legend.game.LeGENDGAME;
import com.legend.game.Maps.Haran;
import com.legend.game.PopupBox.Inventory;
import com.legend.game.States.GameMenu;
import com.legend.game.States.GameState;
import com.legend.game.States.GameStateManager;


/**
 * Created by Patrick Sky on 2/27/2017.
 */

public class AbrahamHouse extends GameState {

    private Stage stage;


    private MainCharacter mainCharacter;
    private HUD hud;
    private Controller controller;
    private ActualGameButtons actualGameButtons;
    private Inventory inventory;

    private TiledMap map; // the map itself
    private IsometricTiledMapRenderer renderer; // it renders the map into the scree


    public AbrahamHouse(GameStateManager gsm){
        super(gsm);

        controller = new Controller();
        hud = new HUD();
        inventory = new Inventory();
        actualGameButtons = new ActualGameButtons();

        stage = new Stage(gameView);
        Gdx.input.setInputProcessor(new InputMultiplexer(controller.getStageC(), actualGameButtons.getStage(), inventory.getStage()));

        gameCam.position.set(500,200,0);

        map = new TmxMapLoader().load("tiledmaps/AbrahamsHouse.tmx");
        renderer = new IsometricTiledMapRenderer(map);


//        mainCharacter = new MainCharacter(map);
//        mainCharacter.setTilePostion(1,0, 25);
        mainCharacter = new MainCharacter(700, 0, 50);
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

        if(Gdx.input.justTouched()){
        }


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

//        gameCam.position.x = mainCharacter.getX() + LeGENDGAME.WIDTH / 2;
//        gameCam.position.y = mainCharacter.getY() + LeGENDGAME.HEIGHT / 2;
//        if (gameCam.position.x < gameCam.viewportWidth / 2) {
//            gameCam.position.x = gameCam.viewportWidth / 2;
//        }
//        if (gameCam.position.x > tilemapwidth * 16 - gameCam.viewportWidth / 2) {
//            gameCam.position.x = tilemapwidth * 16 - gameCam.viewportWidth / 2;
//        }
//        if (gameCam.position.y < gameCam.vsiewportHeight / 2) {
//            gameCam.position.y = gameCam.viewportHeight / 2;
//        }
//        if (gameCam.position.y > tilemapHeight * 16 - gameCam.viewportHeight / 2) {
//            gameCam.position.y = tilemapHeight * 16 - gameCam.viewportHeight / 2;
//        }


        if((gameCam.position.x > 1040) && (gameCam.position.y > 40)){
            gsm.set(new Haran(gsm));
        }

        renderer.setView(gameCam);
        mainCharacter.updateEntity(dt);
        hud.getMapName().setText("Abraham's House");
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
