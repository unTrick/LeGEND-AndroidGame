package com.legend.game.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.legend.game.LeGENDGAME;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = LeGENDGAME.WIDTH;
		config.height = LeGENDGAME.HEIGHT;
		config.title = LeGENDGAME.TITLE;
		config.useGL30 = true;
		//config.addIcon(Gdx.files.internal("joshuaColoredT.png"), Files.FileType.Internal);
		new LwjglApplication(new LeGENDGAME(), config);
	}
}
