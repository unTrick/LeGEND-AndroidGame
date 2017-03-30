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
import com.legend.game.Screen.GameScreen;

/**
 * Created by Patrick Sky on 3/13/2017.
 */

public class Extra {
    OrthographicCamera camera;

    Environment environment;
    AssetManager assets;
    private ModelInstance inst;
    ModelBatch modelBatch;
    private Vector3 position;
    private Vector3 moving;


    private static final float MOVE_SIX = 6f;
    private static final float MOVE_THREE = 3f;

    Array<ModelInstance> instances = new Array<ModelInstance>();

    public Extra(float x, float y, float z){
        position = new Vector3(x , y, z);
        moving = new Vector3(0,0,0);
        modelBatch = new ModelBatch();

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
        assets.load("abraham.g3db", Model.class);
        assets.finishLoading();

        Model model = assets.get("abraham.g3db", Model.class);
        inst = new ModelInstance(model);
        instances.add(inst);
        inst.transform.setToRotation(-560 , 560 , -120,45); //front view

        // Set up environment with simple lighting
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -0.8f, -10f, -10f));

    }

    public void update(float dt){
        moving.scl(dt);
        position.add(moving.x, 0, moving.z);

        moving.scl(1/dt);
        camera.update();
    }

    public void render(){
        modelBatch.begin(camera);
        modelBatch.render(instances, environment);
        modelBatch.end();
    }

    public void walkLeft(float dt){

        position.x -= MOVE_SIX * dt;
        position.z -= MOVE_THREE * dt;
    }

    public void walkRight(float dt){
        position.x += MOVE_SIX * dt;
        position.z += MOVE_THREE * dt;
    }

    public void walkUp(float dt){

        position.x -= MOVE_SIX * dt;
        position.z += MOVE_THREE * dt;
    }


    public void walkDown(float dt){

        position.x += MOVE_SIX * dt;
        position.z -= MOVE_THREE * dt;

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

    public Vector3 getPosition() {
        return position;
    }
}
