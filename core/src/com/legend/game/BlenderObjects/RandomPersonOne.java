package com.legend.game.BlenderObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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
import com.legend.game.Maps.Haran;
import com.legend.game.States.GameStateManager;

/**
 * Created by Patrick Sky on 2/27/2017.
 */

public class RandomPersonOne {

    ModelBatch modelBatch;
    Environment environment;
    OrthographicCamera camera;
    AssetManager assets;
    private ModelInstance inst;


    Array<ModelInstance> instances = new Array<ModelInstance>();

    public RandomPersonOne(){

        // Create ModelBatch that will render all models using a camera
        modelBatch = new ModelBatch();

        // Create a camera and point it to our model
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(0f, 500f, 0f);
        camera.lookAt(0,0,0);
        camera.near = 0.1f;
        camera.far = 3000f;
        camera.zoom += 2f;
        camera.update();

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
        if(Gdx.input.justTouched()){
            System.out.println("this is x" + camera.position); // 1557 XL, -1557 XR, 786 ZUP -660 zdown
        }
        camera.update();
    }


    public void render() {

        modelBatch.begin(camera);
        modelBatch.render(instances, environment);
        modelBatch.end();
    }

    public void dispose(){
        modelBatch.dispose();
        instances.clear();
        assets.dispose();
    }

    public OrthographicCamera getCamera() {
        return camera;
    }
}
