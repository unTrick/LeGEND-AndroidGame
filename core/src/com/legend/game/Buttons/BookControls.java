package com.legend.game.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Created by Patrick Sky on 3/8/2017.
 */

public class BookControls  {

    private Stage stage;
    private ImageButton back, btnGen, btnExo, btnLev, btnNum, btnDeu, btnNext, btnPrev;


    public BookControls(){

        stage = new Stage();

        Drawable genDraw = new TextureRegionDrawable(new TextureRegion(new Texture("btnGen.png")));
        btnGen = new ImageButton(genDraw);

        Drawable exoDraw = new TextureRegionDrawable(new TextureRegion(new Texture("btnExo.png")));
        btnExo = new ImageButton(exoDraw);

        Drawable levDraw = new TextureRegionDrawable(new TextureRegion(new Texture("btnLev.png")));
        btnLev = new ImageButton(levDraw);

        Drawable numDraw = new TextureRegionDrawable(new TextureRegion(new Texture("btnNum.png")));
        btnNum = new ImageButton(numDraw);

        Drawable deuDraw = new TextureRegionDrawable(new TextureRegion(new Texture("btnDeu.png")));
        btnDeu = new ImageButton(deuDraw);

        Drawable nextDraw = new TextureRegionDrawable(new TextureRegion(new Texture("nextPg.png")));
        btnNext = new ImageButton(nextDraw);

        Drawable prevDraw = new TextureRegionDrawable(new TextureRegion(new Texture("pregPg.png")));
        btnPrev = new ImageButton(prevDraw);

        Drawable backDraw = new TextureRegionDrawable(new TextureRegion(new Texture("homebtn.png")));
        back = new ImageButton(backDraw);

    }

    public Stage getStage() {
        return stage;
    }


    public ImageButton getBtnPrev() {
        return btnPrev;
    }

    public ImageButton getBack() {
        return back;
    }

    public ImageButton getBtnGen() {
        return btnGen;
    }

    public ImageButton getBtnExo() {
        return btnExo;
    }

    public ImageButton getBtnLev() {
        return btnLev;
    }

    public ImageButton getBtnNum() {
        return btnNum;
    }

    public ImageButton getBtnDeu() {
        return btnDeu;
    }

    public ImageButton getBtnNext() {
        return btnNext;
    }
}
