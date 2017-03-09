package com.legend.game.BlenderObjects;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.legend.game.LeGENDGAME;
import com.legend.game.Screen.GameScreen;

/**
 * Created by Patrick Sky on 2/27/2017.
 */

public class RandomPersonOne extends GameScreen{

    Environment environment;
    AssetManager assets;
    private ModelInstance inst;
    ModelBatch mbatch;
    private Vector3 position;


    Array<ModelInstance> instances = new Array<ModelInstance>();

    public RandomPersonOne(float x, float y, float z){

        position = new Vector3(x, y, z);
        screenCamera = new OrthographicCamera();
        screenCamera.setToOrtho(false, LeGENDGAME.WIDTH, LeGENDGAME.HEIGHT);

        // Create ModelBatch that will render all models using a camera
        mbatch = new ModelBatch();
        // Create a camera and point it to our model

        screenCamera.position.set(0f, 500f, 0f);
        screenCamera.lookAt(0,0,0);
        screenCamera.near = 0.1f;
        screenCamera.far = 3000f;
        screenCamera.zoom += 2f;
        screenCamera.update();

        assets = new AssetManager();
        assets.load("extraOne.g3db", Model.class);
        assets.finishLoading();



        // Create an instance of our crate model and put it in an array
        Model model = assets.get("extraOne.g3db", Model.class);
        inst = new ModelInstance(model);
        instances.add(inst);

        inst.transform.setToRotation(-560 , 560 , -120,45); //front view

        // Set up environment with simple lighting
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -0.8f, -10f, -10f));
    }

    public void update() {

        screenCamera.position.x = position.x;
        screenCamera.position.y = position.z;
    }

    public void render() {
        mbatch.begin(screenCamera);
        mbatch.render(instances, environment);
        mbatch.end();
    }

    public void dispose() {
        mbatch.dispose();
        instances.clear();
        assets.dispose();
    }

    public Vector3 getPosition() {
        return position;
    }
}
