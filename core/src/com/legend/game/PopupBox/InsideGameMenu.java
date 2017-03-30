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
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;

/**
 * Created by Patrick Sky on 3/16/2017.
 */

public class InsideGameMenu {
    private Stage stage;
    private Table table;
    private TextButton home, save, load, exit, resume;


    public InsideGameMenu(){

        stage = new Stage(new StretchViewport(1280, 720, new OrthographicCamera()));

        FileHandle fontFile = Gdx.files.internal("font/Candarab.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 35;
        BitmapFont font = generator.generateFont(parameter);

        table = new Table();
        table.background(new TextureRegionDrawable(new TextureRegion(new Texture("popup/menubg.png"), 300, 500)));
        table.setSize(300,500);
        table.setPosition((stage.getWidth() / 2) - (table.getWidth() / 2), (stage.getHeight() / 2) - (table.getHeight() / 2));

        Drawable down = new TextureRegionDrawable(new TextureRegion(new Texture("skin/downDrawable.png"), 200, 50));
        Drawable up = new TextureRegionDrawable(new TextureRegion(new Texture("skin/upDrawable.png"), 200, 50));
        Drawable checked = new TextureRegionDrawable(new TextureRegion(new Texture("skin/checkedDraw.png"), 200, 50));

        resume = new TextButton(" RESUME ", new TextButton.TextButtonStyle(up,down,up,font));
        save = new TextButton(" SAVE ", new TextButton.TextButtonStyle(up,down,up,font));
        load = new TextButton(" LOAD ", new TextButton.TextButtonStyle(up,down,up,font));
        home = new TextButton(" HOME ", new TextButton.TextButtonStyle(up,down,checked,font));
        exit = new TextButton(" EXIT GAME ", new TextButton.TextButtonStyle(up,down,checked,font));

        table.add(resume).expandX().padBottom(40);
        table.row();
        table.add(save).expandX().padBottom(40);
        table.row();
        table.add(load).expandX().padBottom(40);
        table.row();
        table.add(home).expandX().padBottom(40);
        table.row();
        table.add(exit).expandX().padBottom(40);


    }

    public void open(){
        stage.addActor(table);
    }

    public void close(){
        table.remove();
    }

    public Stage getStage() {
        return stage;
    }

    public TextButton getResume() {
        return resume;
    }

    public TextButton getHome() {
        return home;
    }

    public TextButton getSave() {
        return save;
    }

    public TextButton getLoad() {
        return load;
    }

    public TextButton getExit() {
        return exit;
    }
}
