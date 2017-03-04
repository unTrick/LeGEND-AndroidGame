package com.legend.game.BlenderObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
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
    private Vector3 position;
    private Vector3 moving;

    private static final float MOVE_SIX = 6f;
    private static final float MOVE_THREE = 3f;


    Array<ModelInstance> instances = new Array<ModelInstance>();

    public MainCharacter(float x, float y, float z){

        // Create ModelBatch that will render all models using a camera
        modelBatch = new ModelBatch();

        position = new Vector3(x , y, z);
        moving = new Vector3(0,0,0);

        // Create a camera and point it to our model
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(0f, 500f, 0f);
        camera.lookAt(0, 0, 0);
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

    public void update(float dt) {

        moving.scl(dt);
        position.add(moving.x, 0, moving.z);



        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            inst.transform.setToRotation(-560 , 560 , -120,45); //front view
            inst.calculateTransforms();
            walkDown(dt);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)){
            inst.transform.setToRotation(new Vector3(90 , 1200, -370),210); // back view
            inst.calculateTransforms();
            walkUp(dt);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            inst.transform.setToRotation(new Vector3(-500 , -300 , 90),45); // left view
            inst.calculateTransforms();
            walkLeft(dt);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            inst.transform.setToRotation(new Vector3(-140, 1200, -380),150); // right view
            inst.calculateTransforms();
            walkRight(dt);
        }

        moving.scl(1/dt);

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

    public void walkLeft(float dt){

//        moving.x = 6;
//        moving.z = -3;

        position.x -= MOVE_SIX * dt;
        position.z -= MOVE_THREE * dt;

        inst.transform.setToRotation(new Vector3(-500 , -300 , 90),45); // left view
        inst.calculateTransforms();
//        camera.translate(6, 0, -3);
    }

    public void walkRight(float dt){
//        moving.x = -6;
//        moving.z = 3;

        position.x += MOVE_SIX * dt;
        position.z += MOVE_THREE * dt;

        inst.transform.setToRotation(new Vector3(-140, 1200, -380),150); // right view
        inst.calculateTransforms();
//        camera.translate(-6, 0, 3);
    }

    public void walkUp(float dt){
//        moving.x = 6;
//        moving.z = 3;

        position.x -= MOVE_SIX * dt;
        position.z += MOVE_THREE * dt;

        inst.transform.setToRotation(new Vector3(90 , 1200, -370),210); // back view
        inst.calculateTransforms();
//        camera.translate(6, 0, 3);
    }

    public void walkDown(float dt){
//        moving.x = -6;
//        moving.z = -3;

        position.x += MOVE_SIX * dt;
        position.z -= MOVE_THREE * dt;

        inst.transform.setToRotation(-560 , 560 , -120,45); //front view
        inst.calculateTransforms();
//        camera.translate(-6, 0, -3);

    }


    public void walkLeftSpeed(){
        camera.translate(12, 0, -6);
        inst.transform.setToRotation(new Vector3(-500 , -300 , 90),45); // left view
        inst.calculateTransforms();

    }

    public void walkRightSpeed(){
        camera.translate(-12, 0, 6);
    }

    public void walkUpSpeed(){
        camera.translate(12, 0, 6);
    }

    public void walkDownSpeed(){
        inst.transform.setToRotation(-560 , 560 , -120,45); //front view
        inst.calculateTransforms();
        camera.translate(-12, 0, -6);
    }


    public OrthographicCamera getCamera() {
        return camera;
    }

    public Vector3 getMoving() {
        return moving;
    }

    public Vector3 getPosition() {
        return position;
    }
}
