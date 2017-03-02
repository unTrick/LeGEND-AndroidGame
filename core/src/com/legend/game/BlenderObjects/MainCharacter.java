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
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
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

        if(Gdx.input.justTouched()){
//            System.out.println("this is x" + camera.position); // 1557 XL, -1557 XR, 786 ZUP -660 zdown
            //System.out.println(inst.transform.getRotation(new Quaternion()));
        }

        if(camera.position.x < -1557/2){
            camera.position.x = -1557/2; // Right
        }

        if(camera.position.x > 1557/2){
            camera.position.x = 1557/2; // Left
        }

        if(camera.position.z < -660/2){
            camera.position.z = -660/2; // Down
        }

        if(camera.position.z > 786/2){
            camera.position.z = 786/2; // Up
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            inst.transform.setToRotation(-560 , 560 , -120,45); //front view
            inst.calculateTransforms();
            walkDown();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)){
            inst.transform.setToRotation(new Vector3(0 , -800 , -360),180); // right view
            inst.calculateTransforms();
            walkUp();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            inst.transform.setToRotation(new Vector3(-500 , -300 , 90),45); // left view
            inst.calculateTransforms();
            walkLeft();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            inst.transform.setToRotation(new Vector3(500 , 300 , -90),90); // right view
            inst.calculateTransforms();
            walkRight();
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

    public void walkLeft(){
        inst.transform.translate(3, 0, -2);
        inst.transform.setToRotation(new Vector3(-500 , -300 , 90),45); // left view
        inst.calculateTransforms();
    }

    public void walkRight(){
        inst.transform.translate(-3, 0, 2);
    }

    public void walkUp(){
        inst.transform.translate(3, 0, 2);
    }

    public void walkDown(){
        inst.transform.setToRotation(-560 , 560 , -120,45); //front view
        inst.calculateTransforms();
        inst.transform.translate(-3, 0, -2);
    }


    public OrthographicCamera getCamera() {
        return camera;
    }
}
