package com.legend.game.CutScenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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
import com.legend.game.Houses.AbrahamHouse;
import com.legend.game.LeGENDGAME;
import com.legend.game.States.GameMenu;
import com.legend.game.States.GameState;
import com.legend.game.States.GameStateManager;

/**
 * Created by Patrick Sky on 2/27/2017.
 */

public class GenesisIntro extends GameState{

    private Stage stage;
    private Image frontIntro, firstCS, secondCS, thirdCS, fourthCS, fifthCS, sixthCS, seventhCS;
    private Texture btnCont, btnSkip, btnFirstNext, btnSecondNext, btnthirdNext, btnFourthNext, btnFifthNext, btnSixthNext, btnSeventhNext, btnMenu;

    public GenesisIntro(final GameStateManager gsm){
        super(gsm);

        LeGENDGAME.storyMusic.play();
        stage = new Stage(gameView);
        Gdx.input.setInputProcessor(stage);


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
                                                                        gsm.set(new AbrahamHouse(gsm));
                                                                        dispose();

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
            public boolean touchDown(InputEvent e, float x, float y, int point, int button){
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
                gsm.set(new AbrahamHouse(gsm));
                dispose();
                return false;
            }
        });

        btnMenus.setPosition(stage.getWidth() / 2 - (btnMenu.getWidth() / 2), stage.getHeight() / 8);
        btnMenus.addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent e, float x, float y, int point, int button){
                gsm.set(new GameMenu(gsm));
                dispose();
            }
        });


    }


    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        LeGENDGAME.storyMusic.dispose();
    }

    @Override
    public void resize(int width, int height) {

    }
}
