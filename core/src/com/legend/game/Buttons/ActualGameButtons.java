package com.legend.game.Buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Created by Patrick Sky on 2/26/2017.
 */

public class ActualGameButtons {

    private Texture home;
    private ImageButton btnHome;
    private Stage stage;
    private Drawable drawHome;

    public ActualGameButtons(){

        stage = new Stage();
        home = new Texture("close.png");

        drawHome = new TextureRegionDrawable(new TextureRegion(home));
        btnHome = new ImageButton(drawHome);
        btnHome.setSize(50, 50);
        btnHome.setPosition(stage.getWidth() - (stage.getWidth() / 16), stage.getHeight() - (stage.getHeight() / 12));
    }


    public ImageButton getBtnHome() {
        return btnHome;
    }

    public Stage getStage() {
        return stage;
    }
}
