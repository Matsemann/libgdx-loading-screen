package com.matsemann.libgdxloadingscreen.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.matsemann.libgdxloadingscreen.SomeCoolGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "libgdx-loading-screen";
		config.width = 800;
		config.height = 480;
		new LwjglApplication(new SomeCoolGame(), config);
	}
}
