package com.legend.game.Buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.legend.game.LeGENDGAME;

/**
 * Created by Patrick Sky on 2/26/2017.
 */

public class ActualGameButtons {

    private Texture menu, talk, run, grab, inventory;
    private ImageButton btnMenu, btnTalk, btnRun, btnGrab, btnInventory;
    private Stage stage;
    private Drawable drawMenu, drawTalk, drawRun, drawGrab, drawInventory;
    private boolean runPressed;

    public ActualGameButtons(){

        stage = new Stage();


        menu = new Texture("popup/Menu.png");
        talk = new Texture("talk.png");
        run = new Texture("run.png");
        grab = new Texture("grab.png");
        inventory = new Texture("inventory.png");

        drawMenu = new TextureRegionDrawable(new TextureRegion(menu));
        btnMenu = new ImageButton(drawMenu);
        btnMenu.setSize(50,50);
        btnMenu.setPosition(stage.getWidth() - (stage.getWidth() / 16), stage.getHeight() - (stage.getHeight() / 12));

        drawTalk = new TextureRegionDrawable(new TextureRegion(talk));
        btnTalk = new ImageButton(drawTalk);

        drawRun = new TextureRegionDrawable(new TextureRegion(run));
        btnRun = new ImageButton(drawRun);

        drawGrab = new TextureRegionDrawable(new TextureRegion(grab));
        btnGrab = new ImageButton(drawGrab);

        drawInventory = new TextureRegionDrawable(new TextureRegion(inventory));
        btnInventory = new ImageButton(drawInventory);

        Table table = new Table();
        table.right();
        table.bottom().padBottom(50);
        table.setFillParent(true);
//        table.setFillParent(false);

        table.add().width(100).height(100).pad(20,0,0,20);
        table.add(btnInventory).width(100).height(100).pad(20,0,0,20);
        table.row();
        table.add().width(100).height(100).pad(20,0,0,20);
        table.add(btnTalk).width(100).height(100).pad(20,0,0,20);
        table.row();
        table.add(btnRun).width(100).height(100).pad(20,0,0,20);
        table.add(btnGrab).width(100).height(100).pad(20,0,0,20);

        stage.addActor(table);

        btnRun.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                runPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
               runPressed = false;
            }
        });


    }



    public Stage getStage() {
        return stage;
    }



    public ImageButton getBtnTalk() {
        return btnTalk;
    }

    public ImageButton getBtnRun() {
        return btnRun;
    }

    public ImageButton getBtnGrab() {
        return btnGrab;
    }

    public boolean isRunPressed() {
        return runPressed;
    }

    public ImageButton getBtnInventory() {
        return btnInventory;
    }

    public ImageButton getBtnMenu() {
        return btnMenu;
    }
}
