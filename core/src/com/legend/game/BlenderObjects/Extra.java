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
import com.badlogic.gdx.utils.Array;

/**
 * Created by Patrick Sky on 3/13/2017.
 */

public class Extra {
    OrthographicCamera camera;

    Environment environment;
    AssetManager assets;
    private ModelInstance inst;

    Array<ModelInstance> instances = new Array<ModelInstance>();

    public Extra(){

        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(0f, 500f, 0f);
        camera.lookAt(0, 0, 0);
        camera.near = 0.1f;
        camera.far = 3000f;
        camera.zoom += 2f;
        camera.update();



        // Create an instance of our crate model and put it in an array
        assets = new AssetManager();
        Model model = assets.get("abraham.g3db", Model.class);
        inst = new ModelInstance(model);
        instances.add(inst);
        inst.transform.setToRotation(-560 , 560 , -120,45); //front view

        environment = new Environment();

    }

    public Environment getEnvironment() {
        return environment;
    }

    public AssetManager getAssets() {
        return assets;
    }

    public ModelInstance getInst() {
        return inst;
    }

    public Array<ModelInstance> getInstances() {
        return instances;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }
}
