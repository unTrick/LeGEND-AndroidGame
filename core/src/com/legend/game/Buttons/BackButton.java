package com.legend.game.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Created by Patrick Sky on 3/9/2017.
 */

public class BackButton {

    private Stage stage;
    private ImageButton btnBack;

    private Table table;


    public BackButton(){

        stage = new Stage();

        Drawable backDraw = new TextureRegionDrawable(new TextureRegion(new Texture("close.png")));
        btnBack = new ImageButton(backDraw);

        table = new Table();
        table.setFillParent(true);
        table.top().right();

        table.add(btnBack).width(100).padRight(100).padTop(20);
    }

    public Stage getStage() {
        return stage;
    }

    public ImageButton getBtnBack() {
        return btnBack;
    }

    public Table getTable() {
        return table;
    }
}
