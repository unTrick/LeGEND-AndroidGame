package com.legend.game.LoadMaps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.legend.game.BlenderObjects.MainCharacter;
import com.legend.game.Buttons.ActualGameButtons;
import com.legend.game.Buttons.BackButton;
import com.legend.game.Buttons.Controller;
import com.legend.game.Buttons.GenesisPortal;
import com.legend.game.States.GameMenu;
import com.legend.game.States.GameState;
import com.legend.game.States.GameStateManager;
import com.legend.game.States.LoadStates;

/**
 * Created by Patrick Sky on 3/2/2017.
 */

public class LoadGenesis extends GameState {
    private Stage stage;

    private MainCharacter mainCharacter;
    private Controller controller;

    private TmxMapLoader mapLoader;//load the map into the game
    private TiledMap map; // the map itself
    private IsometricTiledMapRenderer renderer; // it renders the map into the screen

    private BackButton backButton;
    private GenesisPortal genesisPortal;

    public LoadGenesis(final GameStateManager gsm) {
        super(gsm);

        stage = new Stage(gameView);
        backButton = new BackButton();
        genesisPortal = new GenesisPortal();

        controller = new Controller();
        mainCharacter = new MainCharacter(1, 0, 0);
        mainCharacter.getCamera().zoom  += 2f;


        Gdx.input.setInputProcessor(new InputMultiplexer(backButton.getStage(), genesisPortal.getStage(), controller.getStageC()));

        mapLoader = new TmxMapLoader();
        map = mapLoader.load("tiledmaps/Genesis.tmx");
        renderer = new IsometricTiledMapRenderer(map, 0.2f);
        gameCam.position.set(1886,105,0);

        backButton.getStage().addActor(backButton.getTable());

        backButton.getBtnBack().addListener(new ClickListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int point, int button){

                gsm.set(new LoadStates(gsm));

                return true;
            }

        });

        controller.getStageC().addActor(controller.getBtnUp());
        controller.getStageC().addActor(controller.getBtnDown());
        controller.getStageC().addActor(controller.getBtnLeft());
        controller.getStageC().addActor(controller.getBtnRight());

    }

    @Override
    protected void handleInput() {

        if(Gdx.input.justTouched()){
                System.out.println("this is the X: " + Gdx.input.getX());
                System.out.println("this is the Y: " + Gdx.input.getY());
        }

        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            gameCam.translate(-6 * 4, 3 * 4, 0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            gameCam.translate(6 * 4, -3 * 4, 0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            gameCam.translate(-6 * 4, -3 * 4, 0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            gameCam.translate(6 * 4, 3 * 4, 0);
        }

        if (controller.isLeftPressed()){

                mainCharacter.walkLeft(1);

//                mainCharacter.setLeft();
            mainCharacter.getCamera().translate(6 * 4,0,-3 * 4);
                System.out.println(gameCam.position);
            }

        else if (controller.isRightPressed()){

                mainCharacter.walkRight(1);
//                mainCharacter.setRight();
               mainCharacter.getCamera().translate(-6 * 4,0,3 *4);
                System.out.println(gameCam.position);


        }
        else if (controller.isUpPressed()){

                mainCharacter.walkUp(1);
//                mainCharacter.setUp();
            mainCharacter.getCamera().translate(6 * 4,0,3 * 4);
                System.out.println(gameCam.position);


        }
        else if (controller.isDownPressed()){

                mainCharacter.walkDown(1);
//                mainCharacter.setDown();
                mainCharacter.getCamera().translate(-6 * 4,0,-3 * 4);
                System.out.println(gameCam.position);


        }



    }

    @Override
    public void update(float dt) {
        handleInput();

        gameCam.update();
        renderer.setView(gameCam);
        mainCharacter.updateEntity(dt);

//        mainCharacter.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        renderer.render();

        stage.act();
        stage.draw();


        backButton.getStage().draw();
        genesisPortal.getStage().draw();
        mainCharacter.render();
        controller.render();

    }

    @Override
    public void dispose() {
        stage.dispose();
        renderer.dispose();
    }

    @Override
    public void resize(int width, int height) {

    }
}
