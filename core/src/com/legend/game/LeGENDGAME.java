package com.legend.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.legend.game.States.GameStateManager;
import com.legend.game.States.SplashScreen;

public class LeGENDGAME extends ApplicationAdapter {

	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	public static final String TITLE = "LeGEND: Journey to promised Land";
	private GameStateManager gsm;
	private static SpriteBatch batch;
	public static Music backgroundMusic;
	public static Music splashSound;
	public static Music storyMusic;
	public static Sound clickSound;


	@Override
	public void create () {
		batch = new SpriteBatch();
		splashSound = Gdx.audio.newMusic(Gdx.files.internal("splash screen.MP3"));
		splashSound.setLooping(true);
		splashSound.setVolume(1f);

		backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("Background playback.MP3"));
		backgroundMusic.setLooping(true);
		backgroundMusic.setVolume(0.5f);

		clickSound = Gdx.audio.newSound(Gdx.files.internal("button-16.mp3"));

		storyMusic = Gdx.audio.newMusic(Gdx.files.internal("Intro to Genesis.MP3"));
		storyMusic.setLooping(true);
		storyMusic.setVolume(0.5f);

		gsm = new GameStateManager();
		gsm.push(new SplashScreen(gsm));
		//setScreen(new Screens(this));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}

}
