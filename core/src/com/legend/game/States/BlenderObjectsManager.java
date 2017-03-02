package com.legend.game.States;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.legend.game.LeGENDGAME;

/**
 * Created by Patrick Sky on 2/28/2017.
 */

public abstract class  BlenderObjectsManager {

    protected OrthographicCamera modelCam;
    protected Viewport modelView;

    protected BlenderObjectsManager(){
        modelCam = new OrthographicCamera();
        modelCam.setToOrtho(false, LeGENDGAME.WIDTH, LeGENDGAME.HEIGHT);
        modelView = new StretchViewport(1280, 720, modelCam);

    }


    protected void walkLeft(){
        modelCam.translate(-3, 0, -2); // Left
    }

    protected void walkRight(){
        modelCam.translate(3, 0, 2); // Right
    }

    protected void walkUp(){
        modelCam.translate(-3, 0, 2); // Up
    }

    protected void walkDown(){
        modelCam.translate(3, 0, -2); // Down
    }

    public abstract void update(float dt);
    public abstract void dispose();
    public abstract void resize(int width, int height);
}
