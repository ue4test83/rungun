package com.mygdx.game.rungun.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.rungun.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Run&Gun";
		config.width = 1024;
		config.height = 768;
		new LwjglApplication(new MyGdxGame(), config);
	}
}
