package com.legend.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ai.steer.behaviors.Alignment;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.legend.game.Buttons.SimpleDirectionGestureDetector;

import javax.swing.GroupLayout;

/**
 * Created by Patrick Sky on 3/2/2017.
 */
public class GameHelp extends GameState{

    private Stage stage;
    BitmapFont contentText, titleHead;

    Label lblBtnTitle, lblInstruct, txt1stTitle , txt2ndTitle, txt3rdTitle, txt4thTitle, txtInsContent;
    Label txt1stContent, txt2ndContent, txt3rdContent, txt4thContent;

    public GameHelp(GameStateManager gsm){
        super(gsm);

        stage = new Stage(gameView);

        FileHandle fontFile = Gdx.files.internal("font/Candarab.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter contentParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        contentParameter.size = 20;
        contentText = generator.generateFont(contentParameter);

        FreeTypeFontGenerator.FreeTypeFontParameter titleParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        titleParameter.size = 35;
        titleHead = generator.generateFont(titleParameter);

        Table table = new Table();
        table.top().left().padTop(20);
        table.setFillParent(true);


        String buttonTitle = "Button Contorls";
        String helpTitle = "Instructions";

        String instructContent = "Moving Around\n" +
                "\t- Move the character anywhere using the arrow keus and explore the area to finish a task.\n" +
                "\n" +
                "Talking to someone\n" +
                "\t- To talk to a person, draw close.near to one of them. You see a bubble appears that contains message or instructions.\n" +
                "\n" +
                "Time Limit\n" +
                "\t- In each area, the character requires to finish the task before the time runs out.";

        String firstTitle = "Game Play Controls";
        String secondTitle = "Cutscenes Controls";
        String thirdTitle = "Load Game Controls";
        String fourthTitle = "Other Controls";

        String firstContent = "1. Left, Right, Down and Up Buttons\n" +
                "\t- moves the main character\n" +
                "2. Grab Button\n" +
                "\t- grab things in the area\n" +
                "3. Run Button\n" +
                "\t- hold down while walking to run\n" +
                "4. Inventory Button\n" +
                "\t- used to see the list of grabbed things\n" +
                "5. Message Button\n" +
                "\t- used to talk to people";
        String secondContent = "1. Next Button\n" +
                "\t- press to see the next scene\n" +
                "2. Esc/Skip Button\n" +
                "\t- used to escape/skit the cutscenes\n" +
                "3. Continue Button\n" +
                "\t- press to play the Cutscenes";
        String thirdContent = "1. Books\n" +
                "\t- contains map where the character goes\n" +
                "2. Dead and Live Portals\n" +
                "\t- signifies the place where the game starts";
        String fourthContent = "1. Home button (while in game)\n" +
                "\t- goes back to home menu\n" +
                "2. Sounds control\n" +
                "\t- adjust the sound and music of the game\n" +
                "3. Next button(for conversations)\t\n" +
                "\t- views the remaining message of the person";

        lblInstruct = new Label(helpTitle, new Label.LabelStyle(titleHead, Color.BLACK));
        lblBtnTitle = new Label(buttonTitle, new Label.LabelStyle(titleHead, Color.BLACK));

        txtInsContent = new Label(instructContent, new Label.LabelStyle(contentText, Color.BLACK));

        txt1stTitle = new Label(firstTitle, new Label.LabelStyle(contentText, Color.BLACK));
        txt2ndTitle  = new Label(secondTitle, new Label.LabelStyle(contentText, Color.BLACK));
        txt3rdTitle  = new Label(thirdTitle, new Label.LabelStyle(contentText, Color.BLACK));
        txt4thTitle  = new Label(fourthTitle, new Label.LabelStyle(contentText, Color.BLACK));

        txt1stContent = new Label(firstContent, new Label.LabelStyle(contentText, Color.BLACK));
        txt2ndContent = new Label(secondContent, new Label.LabelStyle(contentText, Color.BLACK));
        txt3rdContent = new Label(thirdContent, new Label.LabelStyle(contentText, Color.BLACK));
        txt4thContent = new Label(fourthContent, new Label.LabelStyle(contentText, Color.BLACK));

        table.add(lblInstruct).center();
        table.row();

        table.add(txtInsContent).pad(10,50,0,0);
        table.row();


        table.add(lblBtnTitle).center().pad(20,0,0,20);
        table.row();

        table.add(txt1stTitle).pad(10,50,0,0).left();
        table.row();
        table.add(txt1stContent).pad(10,70,0,0).left();
        table.row();

        table.add(txt2ndTitle).pad(10,50,0,0).left();
        table.row();
        table.add(txt2ndContent).pad(10,70,0,0).left();
        table.row();

        table.add(txt3rdTitle).pad(10,50,0,0).left();
        table.row();
        table.add(txt3rdContent).pad(10,70,0,0).left();
        table.row();

        table.add(txt4thTitle).pad(10,50,0,0).left();
        table.row();
        table.add(txt4thContent).pad(10,70,0,0).left();

        stage.addActor(table);

        Gdx.input.setInputProcessor(new SimpleDirectionGestureDetector(new SimpleDirectionGestureDetector.DirectionListener() {
            @Override
            public void onLeft() {

            }

            @Override
            public void onRight() {

            }

            @Override
            public void onUp() {
                if(gameCam.position.y < -500){

                }
                else {
                    gameCam.translate(0, -20,0);
                }

            }

            @Override
            public void onDown() {
                if(gameCam.position.y > Gdx.graphics.getHeight() / 2){

                }
                else {
                    gameCam.translate(0, 20,0);
                }
            }
        }));


    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            System.out.println("this is X :" + Gdx.input.getX());
            System.out.println("this is Y :" + Gdx.input.getY());
        }
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();

    }

    @Override
    public void dispose() {

    }

    @Override
    public void resize(int width, int height) {

    }
}
