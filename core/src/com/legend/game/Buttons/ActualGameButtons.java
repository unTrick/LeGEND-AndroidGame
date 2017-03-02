package com.legend.game.Buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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

    private Texture home, talk, run, grab, inventory;
    private ImageButton btnHome, btnTalk, btnRun, btnGrab, btnInventory;
    private Stage stage;
    private Drawable drawHome, drawTalk, drawRun, drawGrab, drawInventory;
    Dialog inventoryD;

    public ActualGameButtons(){

        stage = new Stage();


        home = new Texture("close.png");
        talk = new Texture("talk.png");
        run = new Texture("run.png");
        grab = new Texture("grab.png");
        inventory = new Texture("inventory.png");

        drawHome = new TextureRegionDrawable(new TextureRegion(home));
        btnHome = new ImageButton(drawHome);
        btnHome.setSize(50,50);
        btnHome.setPosition(stage.getWidth() - (stage.getWidth() / 16), stage.getHeight() - (stage.getHeight() / 12));

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


    }


    public ImageButton getBtnHome() {
        return btnHome;
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
}
