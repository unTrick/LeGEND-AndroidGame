package com.legend.game.HUD;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.legend.game.LeGENDGAME;
import com.legend.game.States.GameMenu;
import com.legend.game.States.GameState;
import com.legend.game.States.GameStateManager;

/**
 * Created by Patrick Sky on 2/24/2017.
 */

public class HUD {

    public Stage stage;
    private Viewport viewport;
    private Integer minuteTimer;
    private Integer hourTimer;
    private float timeCountMinute;
    private float timeCountHour;

    private String colon = " : ";

    private Texture blank;
    private float health; // 0 = dead, 1 = full
    private float bar = 3 /2;

    private Label lblTimer;
    private Label mapLocate;
    private Label lblName;
    private Label lblCurTime;
    private Label mapName;
    private Image blankh;

    public HUD(){
        minuteTimer = 1;
        hourTimer = 6;
        timeCountHour = 0;
        timeCountMinute = 0;
        health = 1;


        FileHandle fontFile = Gdx.files.internal("font/Candarab.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 30;
        BitmapFont font = generator.generateFont(parameter);



        viewport = new FitViewport(LeGENDGAME.WIDTH, LeGENDGAME.HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport);


        Table table = new Table();
        table.top();
        table.setFillParent(true);

        blank = new Texture("green.png");
        blankh = new Image(blank);
        blankh.setScale(health / 2, bar / 2);


        lblTimer = new Label("TIME", new Label.LabelStyle(font, Color.WHITE ));
        mapLocate = new Label("World Location", new Label.LabelStyle(font, Color.WHITE ));
        mapName = new Label("mapName", new Label.LabelStyle(font, Color.WHITE));
        lblName = new Label("Patrick Sky", new Label.LabelStyle(font, Color.WHITE ));
        lblCurTime = new Label(String.format("%02d", hourTimer) + colon + String.format("%02d", minuteTimer), new Label.LabelStyle(font, Color.WHITE));

//        lblName.setFontScale(2);
//        lblTimer.setFontScale(2);
//        lblCurTime.setFontScale(2);
        table.add(lblName).expandX().pad(10, -400, 0, 0);
        table.add(mapLocate).expandX().padTop(10).padLeft(-200);
        table.add(lblTimer).expandX().padTop(10).width(150);
        table.row();
        table.add(blankh).expandX().pad(-30, -80, 0, 0);
        table.add(mapName).expandX().padTop(10).padLeft(-200);
        table.add(lblCurTime).expandX().padTop(10).width(150);

        stage.addActor(table);
    }

    public void updated(float dt){


        timeCountHour += dt;
        if(timeCountHour > 59){
            hourTimer++;
            timeCountHour = 0;

            if(hourTimer == 24){
                hourTimer = 0;
            }
        }


        timeCountMinute += dt;
        if(timeCountMinute >= 1){
            minuteTimer++;
            timeCountMinute = 0;

            if(minuteTimer == 59){
                minuteTimer = 0;
            }

            if (health > 0){
                health -= 0.001;
            }

            if(health == 0){
                health = 0;
            }


        }

        lblCurTime.setText(String.format("%02d", hourTimer) + colon + String.format("%02d", minuteTimer));
        blankh.setScale(health / 2, bar / 2);
//        if(health <= 0.6){
//            blank = new Texture("orange.png");
//        }
//
//        else if(health <= 0.3){
//            blank = new Texture("red.png");
//        }

    }


    public Label getMapName() {
        return mapName;
    }

    public Integer getMinuteTimer() {
        return minuteTimer;
    }

    public Integer getHourTimer() {
        return hourTimer;
    }
}
