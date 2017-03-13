package com.legend.game.Buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.legend.game.LeGENDGAME;

/**
 * Created by Patrick Sky on 3/9/2017.
 */

public class GenesisPortal {

    private Stage stage;
    private OrthographicCamera cam;
    private Viewport viewport;

    private Label lblEgypt, lblBeerLahaiRoi, lblNegeb, lblBeersheba,
            lblSodom, lblMachpelah, lblGerar, lblLandOfMoriah, lblBethel, lblLandOfCanan, lblHaran, lblPaddanAram;

    private ImageButton btnEgypt, btnBeerLahaiRoi, btnNegeb, btnBeersheba,
            btnSodom, btnMachpelah, btnGerar, btnLandOfMoriah, btnBethel, btnLandOfCanan, btnHaran, btnPaddanAram;

    private Texture deadPortal, activePortal;

    public GenesisPortal(){

        cam = new OrthographicCamera();
        cam.setToOrtho(false, LeGENDGAME.WIDTH, LeGENDGAME.HEIGHT);
        viewport = new StretchViewport(1280, 720, cam);
        stage = new Stage(viewport);

        deadPortal = new Texture("deadportal.png");
        activePortal = new Texture("activeportal.png");


        FileHandle fontFile = Gdx.files.internal("font/Candarab.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 20;
        BitmapFont font = generator.generateFont(parameter);

        lblEgypt = new Label("Egypt", new Label.LabelStyle(font, Color.BLACK));
        lblBeerLahaiRoi = new Label("Beer-Lahai-Roi", new Label.LabelStyle(font, Color.BLACK));
        lblBeersheba = new Label("Beersheba", new Label.LabelStyle(font, Color.BLACK));
        lblBethel = new Label("Bethel", new Label.LabelStyle(font, Color.BLACK));
        lblGerar = new Label("Gerar", new Label.LabelStyle(font, Color.BLACK));
        lblHaran = new Label("Haran", new Label.LabelStyle(font, Color.BLACK));
        lblLandOfCanan = new Label("Land of Canaan", new Label.LabelStyle(font, Color.BLACK));
        lblLandOfMoriah = new Label("Land of Moriah", new Label.LabelStyle(font, Color.BLACK));
        lblMachpelah = new Label("Machpelah", new Label.LabelStyle(font, Color.BLACK));
        lblNegeb = new Label("Negeb", new Label.LabelStyle(font, Color.BLACK));
        lblPaddanAram = new Label("Paddan-Aram", new Label.LabelStyle(font, Color.BLACK));
        lblSodom = new Label("Sodom", new Label.LabelStyle(font, Color.BLACK));

        lblEgypt.setPosition(164, 720 - 630);
        lblBeerLahaiRoi.setPosition(680 ,710 - 517 );
        lblBeersheba.setPosition(684,720 - 393 );
        lblBethel.setPosition(722 ,720 - 282 );
        lblGerar.setPosition(628 ,720 - 324 );
        lblHaran.setPosition(804 ,720 - 79 );
        lblLandOfCanan.setPosition(808 ,720 - 314 );
        lblLandOfMoriah.setPosition(718 ,720 - 338 );
        lblMachpelah.setPosition(755 ,710 - 404 );
        lblNegeb.setPosition(700 ,710 - 453 );
        lblPaddanAram.setPosition(967 ,720 - 104 );
        lblSodom.setPosition(869 ,720 - 453 );



        stage.addActor(lblEgypt);
        stage.addActor(lblBeerLahaiRoi);
        stage.addActor(lblBeersheba);
        stage.addActor(lblBethel);
        stage.addActor(lblGerar);
        stage.addActor(lblHaran);
        stage.addActor(lblLandOfCanan);
        stage.addActor(lblLandOfMoriah);
        stage.addActor(lblMachpelah);
        stage.addActor(lblNegeb);
        stage.addActor(lblPaddanAram);
        stage.addActor(lblSodom);


        Drawable activeDraw = new TextureRegionDrawable(new TextureRegion(activePortal));
        Drawable deadDraw = new TextureRegionDrawable(new TextureRegion(deadPortal));

        btnEgypt = new ImageButton(deadDraw);
        btnBeerLahaiRoi = new ImageButton(deadDraw);
        btnNegeb = new ImageButton(deadDraw);
        btnBeersheba = new ImageButton(deadDraw);
        btnSodom = new ImageButton(deadDraw);
        btnMachpelah = new ImageButton(deadDraw);
        btnGerar = new ImageButton(deadDraw);
        btnLandOfMoriah = new ImageButton(deadDraw);
        btnBethel = new ImageButton(deadDraw);
        btnLandOfCanan = new ImageButton(activeDraw);
        btnHaran = new ImageButton(activeDraw);
        btnPaddanAram = new ImageButton(deadDraw);

        btnEgypt.setPosition(114, 705 - 630);
        btnBeerLahaiRoi.setPosition(630 ,695 - 517 );
        btnBeersheba.setPosition(634,705 - 393 );
        btnBethel.setPosition(672 ,705 - 282 );
        btnGerar.setPosition(578 ,705 - 324 );
        btnHaran.setPosition(754 ,705 - 79 );
        btnLandOfCanan.setPosition(758 ,705 - 314 );
        btnLandOfMoriah.setPosition(668 ,705 - 338 );
        btnMachpelah.setPosition(705 ,695 - 404 );
        btnNegeb.setPosition(650 ,695 - 453 );
        btnPaddanAram.setPosition(917 ,705 - 104 );
        btnSodom.setPosition(824 ,705 - 453 );

        btnEgypt.setSize(50,50);
        btnBeerLahaiRoi.setSize(50,50);
        btnBeersheba.setSize(50,50);
        btnBethel.setSize(50,50);
        btnGerar.setSize(50,50 );
        btnHaran.setSize(50,50);
        btnLandOfCanan.setSize(50,50);
        btnLandOfMoriah.setSize(50,50);
        btnMachpelah.setSize(50,50);
        btnNegeb.setSize(50,50);
        btnPaddanAram.setSize(50,50);
        btnSodom.setSize(50,50);

        stage.addActor(btnEgypt);
        stage.addActor(btnBeerLahaiRoi);
        stage.addActor(btnBeersheba);
        stage.addActor(btnBethel);
        stage.addActor(btnGerar);
        stage.addActor(btnHaran);
        stage.addActor(btnLandOfCanan);
        stage.addActor(btnLandOfMoriah);
        stage.addActor(btnMachpelah);
        stage.addActor(btnNegeb);
        stage.addActor(btnPaddanAram);
        stage.addActor(btnSodom);

    }

    public Stage getStage() {
        return stage;
    }
}
