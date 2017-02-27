package com.legend.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import com.legend.game.States.GameMenu;
import com.legend.game.States.GameStateManager;
import com.legend.game.States.SplashScreen;

public class LeGENDGAME extends ApplicationAdapter {

	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	public static final String TITLE = "LeGEND: Journey to promised Land";
	private GameStateManager gsm;
	private static SpriteBatch batch;
	public static Music backgroundMusic;



	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		gsm.push(new SplashScreen(gsm));
		//setScreen(new Screens(this));
		backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("Background playback.MP3"));
		backgroundMusic.setLooping(true);
		backgroundMusic.setVolume(0.5f);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}

}
