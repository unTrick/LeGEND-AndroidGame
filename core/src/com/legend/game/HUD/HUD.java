package com.legend.game.HUD;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.legend.game.LeGENDGAME;

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

    String colon = " : ";

    Texture blank;
    float health; // 0 = dead, 1 = full
    float bar = 3 /2;

    Label lblTimer;
    Label lblName;
    Label lblCurTime;
    Image blankh;

    public HUD(){
        minuteTimer = 1;
        hourTimer = 6;
        timeCountHour = 0;
        timeCountMinute = 0;
        health = 1;
        viewport = new FitViewport(LeGENDGAME.WIDTH, LeGENDGAME.HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport);


        Table table = new Table();
        table.top();
        table.setFillParent(true);

        blank = new Texture("green.png");
        blankh = new Image(blank);
        blankh.setScale(health / 2, bar / 2);


        lblTimer = new Label("TIME", new Label.LabelStyle(new BitmapFont(), Color.WHITE ));
        lblName = new Label("Patrick Sky", new Label.LabelStyle(new BitmapFont(), Color.WHITE ));
        lblCurTime = new Label(String.format("%02d", hourTimer) + colon + String.format("%02d", minuteTimer), new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        lblName.setFontScale(2);
        lblTimer.setFontScale(2);
        lblCurTime.setFontScale(2);
        table.add(lblName).expandX().pad(10, -400, 0, 0);
        table.add().expandX().padTop(10);
        table.add(lblTimer).expandX().padTop(10);
        table.row();
        table.add(blankh).expandX().pad(-30, -80, 0, 0);
        table.add().expandX().padTop(10);
        table.add(lblCurTime).expandX().padTop(10);

        stage.addActor(table);
    }

    public void update(float dt){

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


}
