package com.legend.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.legend.game.BlenderObjects.MainCharacter;
import com.legend.game.Buttons.Controller;
import com.legend.game.LeGENDGAME;
import com.legend.game.Maps.Haran;

/**
 * Created by Patrick Sky on 2/11/2017.
 */

public class StartGameState extends GameState{

    private Stage stage;
    private Image frontIntro, firstCS, secondCS, thirdCS, fourthCS, fifthCS, sixthCS, seventhCS, House;
    private static Music storyMusic;
    private Sound clickSound;
    private Texture btnCont, btnSkip, btnFirstNext, btnSecondNext, btnthirdNext, btnFourthNext, btnFifthNext, btnSixthNext, btnSeventhNext, btnMenu;
    private MainCharacter mainCharacter;
    private Controller controller;
    private OrthographicCamera camera;
    private Viewport viewport;




    public StartGameState(final GameStateManager gsm){
        super(gsm);
        controller = new Controller();
        mainCharacter = new MainCharacter();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, LeGENDGAME.WIDTH, LeGENDGAME.HEIGHT);
        viewport = new StretchViewport(1280, 720, camera);

        storyMusic = Gdx.audio.newMusic(Gdx.files.internal("Intro to Genesis.MP3"));
        storyMusic.setLooping(true);
        storyMusic.setVolume(0.5f);
        storyMusic.play();
        clickSound = Gdx.audio.newSound(Gdx.files.internal("button-16.mp3"));
        stage = new Stage(viewport);


        House = new Image(new Texture("16736531_1423550517663996_795662824_n.jpg"));
        House.setPosition((stage.getWidth() / 2) - (House.getWidth() / 2), 0);
        stage.addActor(House);

        seventhCS = new Image(new Texture("Gen11.jpg"));
        stage.addActor(seventhCS);

        sixthCS = new Image(new Texture("Gen6to9.jpg"));
        stage.addActor(sixthCS);

        fifthCS = new Image(new Texture("Gen6.jpg"));
        stage.addActor(fifthCS);

        fourthCS = new Image(new Texture("Gen4.jpg"));
        stage.addActor(fourthCS);

        thirdCS = new Image(new Texture("Gen3C.jpg"));
        stage.addActor(thirdCS);

        secondCS = new Image(new Texture("Gen3.jpg"));
        stage.addActor(secondCS);

        firstCS = new Image(new Texture("Gen1to2.jpg"));
        stage.addActor(firstCS);

        frontIntro = new Image(new Texture("frontPage.png"));
        stage.addActor(frontIntro);

        Gdx.input.setInputProcessor(stage);


        btnMenu = new Texture("back.png");
        Drawable drawMenu = new TextureRegionDrawable(new TextureRegion(btnMenu));
        final ImageButton btnMenus = new ImageButton(drawMenu);
        stage.addActor(btnMenus);

        btnSkip = new Texture("skip.png");
        Drawable drawSkip = new TextureRegionDrawable(new TextureRegion(btnSkip));
        final ImageButton btnSkips = new ImageButton(drawSkip);
        stage.addActor(btnSkips);

        btnCont = new Texture("continue.png");
        Drawable drawCont = new TextureRegionDrawable(new TextureRegion(btnCont));
        final ImageButton btnConts = new ImageButton(drawCont);
        btnConts.setPosition(stage.getWidth() / 6 , stage.getHeight() / 8);

        btnConts.addListener(new ClickListener(){
           @Override
            public void touchUp(InputEvent e, float x, float y, int point, int button){
               frontIntro.remove();
               btnConts.remove();
               btnMenus.remove();
               btnSkips.remove();

               btnFirstNext = new Texture("nextandplayButton.png");
               Drawable drawFirst = new TextureRegionDrawable(new TextureRegion(btnFirstNext));
               final ImageButton btnFirst = new ImageButton(drawFirst);
               btnFirst.setPosition(stage.getWidth() - (stage.getWidth() / 8), stage.getHeight() / 8);

               btnFirst.addListener(new ClickListener(){
                   @Override
                   public void touchUp(InputEvent e, float x, float y, int point, int button){
                       firstCS.remove();
                       btnFirst.remove();

                       btnSecondNext = new Texture("nextandplayButton.png");
                       Drawable drawSecond = new TextureRegionDrawable(new TextureRegion(btnSecondNext));
                       final ImageButton btnSecond = new ImageButton(drawSecond);
                       btnSecond.setPosition(stage.getWidth() - (stage.getWidth() / 8), stage.getHeight() / 8);

                       btnSecond.addListener(new ClickListener(){
                           @Override
                           public void touchUp(InputEvent e, float x, float y, int point, int button){
                               secondCS.remove();
                               btnSecond.remove();


                               btnthirdNext = new Texture("nextandplayButton.png");
                               Drawable drawThird = new TextureRegionDrawable(new TextureRegion(btnthirdNext));
                               final ImageButton btnThird = new ImageButton(drawThird);
                               btnThird.setPosition(stage.getWidth() - (stage.getWidth() / 8), stage.getHeight() / 8);

                               btnThird.addListener(new ClickListener(){
                                   @Override
                                   public void touchUp(InputEvent e, float x, float y, int point, int button){
                                       thirdCS.remove();
                                       btnThird.remove();



                                       btnFourthNext = new Texture("nextandplayButton.png");
                                       Drawable drawFourth = new TextureRegionDrawable(new TextureRegion(btnFourthNext));
                                       final ImageButton btnFourth = new ImageButton(drawFourth);
                                       btnFourth.setPosition(stage.getWidth() - (stage.getWidth() / 8), stage.getHeight() / 8);

                                       btnFourth.addListener(new ClickListener(){
                                           @Override
                                           public void touchUp(InputEvent e, float x, float y, int point, int button){
                                               fourthCS.remove();
                                               btnFourth.remove();




                                               btnFifthNext = new Texture("nextandplayButton.png");
                                               Drawable drawFifth = new TextureRegionDrawable(new TextureRegion(btnFifthNext));
                                               final ImageButton btnFifth = new ImageButton(drawFifth);
                                               btnFifth.setPosition(stage.getWidth() - (stage.getWidth() / 8), stage.getHeight() / 8);

                                               btnFifth.addListener(new ClickListener(){
                                                   @Override
                                                   public void touchUp(InputEvent e, float x, float y, int point, int button){
                                                       fifthCS.remove();
                                                       btnFifth.remove();



                                                       btnSixthNext = new Texture("nextandplayButton.png");
                                                       Drawable drawSixth = new TextureRegionDrawable(new TextureRegion(btnSixthNext));
                                                       final ImageButton btnSixth = new ImageButton(drawSixth);
                                                       btnSixth.setPosition(stage.getWidth() - (stage.getWidth() / 8), stage.getHeight() / 8);

                                                       btnSixth.addListener(new ClickListener(){
                                                           @Override
                                                           public void touchUp(InputEvent e, float x, float y, int point, int button){
                                                               sixthCS.remove();
                                                               btnSixth.remove();



                                                               btnSeventhNext = new Texture("nextandplayButton.png");
                                                               Drawable drawSeventh = new TextureRegionDrawable(new TextureRegion(btnSeventhNext));
                                                               final ImageButton btnSeventh = new ImageButton(drawSeventh);
                                                               btnSeventh.setPosition(stage.getWidth() - (stage.getWidth() / 8), stage.getHeight() / 8);

                                                               btnSeventh.addListener(new ClickListener(){
                                                                   @Override
                                                                   public void touchUp(InputEvent e, float x, float y, int point, int button){
                                                                       seventhCS.remove();
                                                                       btnSeventh.remove();

                                                                       actualGame();


                                                                   }
                                                               });
                                                               stage.addActor(btnSeventh);




                                                           }
                                                       });
                                                       stage.addActor(btnSixth);



                                                   }
                                               });
                                               stage.addActor(btnFifth);




                                           }
                                       });
                                       stage.addActor(btnFourth);



                                   }
                               });
                               stage.addActor(btnThird);


                           }
                       });
                       stage.addActor(btnSecond);
                   }
               });
               stage.addActor(btnFirst);
           }
        });
        stage.addActor(btnConts);


        btnSkips.setPosition(stage.getWidth() - ((stage.getWidth() / 6) + btnSkips.getWidth()), stage.getHeight() / 8);

        btnSkips.addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent e, float x, float y, int point, int button){
                btnConts.remove();
                frontIntro.remove();
                firstCS.remove();
                secondCS.remove();
                thirdCS.remove();
                fourthCS.remove();
                fifthCS.remove();
                sixthCS.remove();
                seventhCS.remove();
                btnSkips.remove();
                btnMenus.remove();
                storyMusic.dispose();

                actualGame();

            }
        });

        btnMenus.setPosition(stage.getWidth() / 2 - (btnMenu.getWidth() / 2), stage.getHeight() / 8);

        btnMenus.addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent e, float x, float y, int point, int button){
                storyMusic.pause();
                dispose();
                gsm.set(new GameMenu(gsm));

            }
        });

        controller.getBtnGo().addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent e, float x, float y, int pointer, int button){
                dispose();
                gsm.set(new GameMenu(gsm));
                return false;
            }
        });



    }

    private void actualGame(){

        storyMusic.pause();

        stage.addActor(controller.getBtnUp());
        stage.addActor(controller.getBtnDown());
        stage.addActor(controller.getBtnGo());
        stage.addActor(controller.getBtnLeft());
        stage.addActor(controller.getBtnRight());

        mainCharacter.getAssets().finishLoading();

        Model model = mainCharacter.getAssets().get("abraham.g3db", Model.class);
        ModelInstance inst = new ModelInstance(model);
        mainCharacter.getInstances().add(inst);
        mainCharacter.getEnvironment().set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        mainCharacter.getEnvironment().add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -0.8f, -10f, -10f));
    }

    @Override
    protected void handleInput() {
        if (mainCharacter.getCamera().position.x >= 111.0){
            gsm.set(new Haran(gsm));
        }
        if (Gdx.input.isTouched()){
            System.out.println(mainCharacter.getCamera().position.x);
            System.out.println(mainCharacter.getCamera().position.y);
            System.out.println(stage.getCamera().position);
        }
        controller.getBtnUp().addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent e, float x, float y, int point, int button){
                mainCharacter.left();
            }
        });

    }

    @Override
    public void update(float dt) {

        handleInput();
        mainCharacter.update();

    }

    @Override
    public void render(SpriteBatch sb) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        stage.act();
        stage.draw();
        controller.render();
        mainCharacter.render();
    }

    @Override
    public void dispose() {
        clickSound.dispose();
        storyMusic.dispose();
    }

    @Override
    public void resize(int width, int height) {

    }
}
