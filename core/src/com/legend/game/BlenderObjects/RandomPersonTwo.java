package com.legend.game.BlenderObjects;

import com.badlogic.gdx.Gdx;
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
import com.legend.game.States.BlenderObjectsManager;

/**
 * Created by Patrick Sky on 2/27/2017.
 */

public class RandomPersonTwo extends BlenderObjectsManager {


    Environment environment;
    AssetManager assets;
    private ModelInstance inst;
    ModelBatch mbatch;


    Array<ModelInstance> instances = new Array<ModelInstance>();

    public RandomPersonTwo(){

        // Create ModelBatch that will render all models using a camera

        // Create a camera and point it to our model
        mbatch = new ModelBatch();
        modelCam.position.set(0f, 500f, 0f);
        modelCam.lookAt(0,0,0);
        modelCam.near = 0.1f;
        modelCam.far = 3000f;
        modelCam.zoom += 2f;
        modelCam.update();

        assets = new AssetManager();
        assets.load("extraTwo.g3db", Model.class);
        assets.finishLoading();



        // Create an instance of our crate model and put it in an array
        Model model = assets.get("extraTwo.g3db", Model.class);
        inst = new ModelInstance(model);
        instances.add(inst);
        inst.transform.setToRotation(-560 , 560 , -120,45); //front view

        // Set up environment with simple lighting
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -0.8f, -10f, -10f));
    }

    @Override
    public void update(float dt) {
        if(Gdx.input.justTouched()){
//            System.out.println("this is x" + camera.position); // 1557 XL, -1557 XR, 786 ZUP -660 zdown
        }
        modelCam.update();
    }

    public void render() {
        mbatch.begin(modelCam);
        mbatch.render(instances, environment);
        mbatch.end();
    }

    @Override
    public void dispose() {
        mbatch.dispose();
        instances.clear();
        assets.dispose();
    }

    @Override
    public void resize(int width, int height) {

    }
}
