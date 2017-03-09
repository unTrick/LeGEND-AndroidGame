package com.legend.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.legend.game.BibleBooks.BookOfDeuteronomy;
import com.legend.game.BibleBooks.BookOfExodus;
import com.legend.game.BibleBooks.BookOfGenesis;
import com.legend.game.BibleBooks.BookOfLeviticus;
import com.legend.game.BibleBooks.BookOfNumbers;
import com.legend.game.Buttons.BookControls;
import com.legend.game.Buttons.SimpleDirectionGestureDetector;

/**
 * Created by Patrick Sky on 2/11/2017.
 */

public class BibleBook extends GameState {

    private Stage stage;
    private Table selectionTable;
    private BookControls bookControls;

    private BookOfGenesis bookOfGenesis;
    private BookOfExodus bookOfExodus;
    private BookOfDeuteronomy bookOfDeuteronomy;
    private BookOfLeviticus bookOfLeviticus;
    private BookOfNumbers bookOfNumbers;

    public BibleBook(final GameStateManager gsm){
        super(gsm);

        stage = new Stage(gameView);
        bookControls = new BookControls();

        bookOfGenesis = new BookOfGenesis();
        bookOfExodus = new BookOfExodus();
        bookOfDeuteronomy = new BookOfDeuteronomy();
        bookOfLeviticus = new BookOfLeviticus();
        bookOfNumbers = new BookOfNumbers();

        stage.addAction(Actions.delay(1));

        Gdx.input.setInputProcessor(new InputMultiplexer( stage, bookControls.getStage(), new SimpleDirectionGestureDetector(new SimpleDirectionGestureDetector.DirectionListener() {
            @Override
            public void onLeft() {

            }

            @Override
            public void onRight() {

            }

            @Override
            public void onUp() {
                bookOfGenesis.getCamera().translate(0, -20,0);
                bookOfLeviticus.getCamera().translate(0, -20,0);
                bookOfDeuteronomy.getCamera().translate(0, -20,0);
                bookOfNumbers.getCamera().translate(0, -20,0);
                bookOfExodus.getCamera().translate(0, -20,0);


            }

            @Override
            public void onDown() {

                bookOfGenesis.getCamera().translate(0, 20,0);
                bookOfLeviticus.getCamera().translate(0, 20,0);
                bookOfDeuteronomy.getCamera().translate(0, 20,0);
                bookOfNumbers.getCamera().translate(0, 20,0);
                bookOfExodus.getCamera().translate(0, 20,0);

            }
        })));

        selectionTable = new Table();
        selectionTable.setFillParent(true);
        selectionTable.top();

        selectionTable.add(bookControls.getBtnGen()).width(200).padLeft(10);
        selectionTable.add(bookControls.getBtnExo()).width(200).padLeft(10);
        selectionTable.add(bookControls.getBtnLev()).width(200).padLeft(10);
        selectionTable.add(bookControls.getBtnNum()).width(200).padLeft(10);
        selectionTable.add(bookControls.getBtnDeu()).width(200).padLeft(10);
        selectionTable.add(bookControls.getBack()).width(200).padLeft(10);
        selectionTable.row();
        selectionTable.add(bookControls.getBtnPrev()).width(100).top();
        selectionTable.add();
        selectionTable.add();
        selectionTable.add();
        selectionTable.add();
        selectionTable.add(bookControls.getBtnNext()).width(100).top();
        selectionTable.row();


        stage.addActor(selectionTable);

        bookControls.getBack().addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent e, float x, float y){
                stage.addAction(Actions.moveBy(0, -stage.getHeight(), 0.2f));
                gsm.set(new GameMenu(gsm));
                System.out.println("touch");
            }

        });



        bookControls.getBtnGen().addListener(new ClickListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int point, int button){

                bookOfGenesis.getStage().addActor(bookOfGenesis.getTable1());

                bookOfExodus.removeAll();
                bookOfDeuteronomy.removeAll();
                bookOfNumbers.removeAll();
                bookOfLeviticus.removeAll();

                return true;
            }

        });

        bookControls.getBtnExo().addListener(new ClickListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int point, int button){

                bookOfExodus.getStage().addActor(bookOfExodus.getTable1());

                bookOfGenesis.removeAll();
                bookOfDeuteronomy.removeAll();
                bookOfNumbers.removeAll();
                bookOfLeviticus.removeAll();

                return true;
            }

        });

        bookControls.getBtnLev().addListener(new ClickListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int point, int button){

                bookOfLeviticus.getStage().addActor(bookOfLeviticus.getTable1());

                bookOfGenesis.removeAll();
                bookOfDeuteronomy.removeAll();
                bookOfNumbers.removeAll();
                bookOfExodus.removeAll();

                return true;
            }

        });

        bookControls.getBtnNum().addListener(new ClickListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int point, int button){

                bookOfNumbers.getStage().addActor(bookOfNumbers.getTable1());

                bookOfGenesis.removeAll();
                bookOfDeuteronomy.removeAll();
                bookOfExodus.removeAll();
                bookOfLeviticus.removeAll();

                return true;
            }

        });

        bookControls.getBtnDeu().addListener(new ClickListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int point, int button){

                bookOfDeuteronomy.getStage().addActor(bookOfDeuteronomy.getTable1());

                bookOfGenesis.removeAll();
                bookOfExodus.removeAll();
                bookOfNumbers.removeAll();
                bookOfLeviticus.removeAll();

                return true;
            }

        });



    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();

        bookOfGenesis.getStage().draw();
        bookOfExodus.getStage().draw();
        bookOfLeviticus.getStage().draw();
        bookOfNumbers.getStage().draw();
        bookOfDeuteronomy.getStage().draw();

        bookControls.getStage().draw();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void resize(int width, int height) {

    }
}
