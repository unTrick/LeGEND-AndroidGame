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
import com.badlogic.gdx.utils.Array;

/**
 * Created by Patrick Sky on 2/26/2017.
 */

public class MainCharacter {


    ModelBatch modelBatch;
    Environment environment;
    OrthographicCamera camera;
    AssetManager assets;
    private ModelInstance inst;



    Array<ModelInstance> instances = new Array<ModelInstance>();

    public MainCharacter(){

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
        assets.load("abraham.g3db", Model.class);
        assets.finishLoading();



        // Create an instance of our crate model and put it in an array
        Model model = assets.get("abraham.g3db", Model.class);
        inst = new ModelInstance(model);
        instances.add(inst);
        inst.transform.setToRotation(-560 , 560 , -120,45); //front view

        // Set up environment with simple lighting
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -0.8f, -10f, -10f));
    }

    public void update() {


        if(camera.position.x > 700){
            camera.position.x = 700;
        }

        if(camera.position.x < -1181){
            camera.position.x = -1181;
        }

        if(camera.position.z > 380){
            camera.position.z = 380;
        }

        if(camera.position.z < -300){
            camera.position.z = -300;
        }

        camera.update();

    }


    public void render() {



        modelBatch.begin(camera);
        modelBatch.render(instances, environment);
        modelBatch.end();
    }

    public void walkLeft(){
        camera.translate(3, 0, -2);
    }

    public void walkRight(){
        camera.translate(-3, 0, 2);
    }

    public void walkUp(){
        camera.translate(3, 0, 2);
    }

    public void walkDown(){
        camera.translate(-3, 0, -2);
    }


    public OrthographicCamera getCamera() {
        return camera;
    }

}
