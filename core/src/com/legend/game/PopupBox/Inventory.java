package com.legend.game.PopupBox;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;

/**
 * Created by Patrick Sky on 3/6/2017.
 */

public class Inventory {

    private Stage stage;

    private Texture bread;
    private Texture inventoryBG;
    private Texture coin;
    private Texture remove;
    private Texture closed;

    private Image coinIcon;
    private Image inventoryBack;
    private Image breadIcon;
    private ImageButton removeIcon;
    private ImageButton btnclose;


    private Table inventoryTable;
    private Table closeTable;
    private Table removeTable;
    private Table goldTable;

    private Label lblGold;
    private Integer curGold;

    public Inventory(){

        curGold = 0;

        stage = new Stage(new StretchViewport(1280, 720, new OrthographicCamera()));

        FileHandle fontFile = Gdx.files.internal("font/Candarab.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 20;
        BitmapFont font = generator.generateFont(parameter);

        lblGold = new Label(String.format("%03d", curGold), new Label.LabelStyle(font, Color.WHITE));

        bread = new Texture("popup/bread.png");
        inventoryBG = new Texture("popup/inventoryBox.png");
        coin = new Texture("popup/coin.png");
        remove = new Texture("popup/remove.png");
        closed = new Texture("popup/close.png");

        coinIcon = new Image(coin);
        inventoryBack = new Image(inventoryBG);
        breadIcon = new Image(bread);
        removeIcon = new ImageButton(new TextureRegionDrawable(new TextureRegion(remove)));
        btnclose = new ImageButton(new TextureRegionDrawable(new TextureRegion(closed)));

        inventoryBack.setPosition((stage.getWidth() / 2) - (inventoryBG.getWidth() / 2),
                (stage.getHeight() / 2 ) - (inventoryBG.getHeight() / 2));


        inventoryTable = new Table();
        inventoryTable.setPosition((stage.getWidth() / 2) - (inventoryBG.getWidth() / 2),
                (stage.getHeight() / 2 ) - (inventoryBG.getHeight() / 2));
        inventoryTable.setFillParent(true);
        inventoryTable.left();

        inventoryTable.add(breadIcon).width(50).height(50).padLeft(40);


        closeTable = new Table();
        closeTable.setPosition((stage.getWidth() / 2) - (inventoryBG.getWidth() / 2),
                (stage.getHeight() / 2 ) - (inventoryBG.getHeight() / 2));
        closeTable.setFillParent(true);

        closeTable.add(btnclose).width(50).height(50).padTop(-200);


        removeTable = new Table();
        removeTable.setPosition((stage.getWidth() / 2) - (inventoryBG.getWidth() / 2),
                (stage.getHeight() / 2 ) - (inventoryBG.getHeight() / 2));
        removeTable.setFillParent(true);
        removeTable.bottom().left();

        removeTable.add(removeIcon).width(50).height(50).padLeft(60).padBottom(50);


        goldTable = new Table();
        goldTable.setPosition((stage.getWidth() / 2) - (inventoryBG.getWidth() / 2),
                (stage.getHeight() / 2 ) - (inventoryBG.getHeight() / 2));
        goldTable.setFillParent(true);
        goldTable.bottom().left().padBottom(20);

        goldTable.add(coinIcon).width(25).height(25).padLeft(400);
        goldTable.add(lblGold).padLeft(20);


    }

    public void inventory(){
        stage.addActor(inventoryBack);
        stage.addActor(inventoryTable);
        stage.addActor(closeTable);
        stage.addActor(removeTable);
        stage.addActor(goldTable);
    }

    public void close(){
        inventoryBack.remove();
        closeTable.remove();
        inventoryTable.remove();
        removeTable.remove();
        goldTable.remove();
    }


    public Stage getStage() {
        return stage;
    }

    public ImageButton getRemoveIcon() {
        return removeIcon;
    }

    public ImageButton getBtnclose() {
        return btnclose;
    }
}
