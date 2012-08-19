package com.matsemann.libgdxloadingscreen;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

/**
 * @author Mats Svensson
 */
public class DesktopStarter {
    public static void main(String[] args) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "libgdx-loading-screen";
        cfg.useGL20 = false;
        cfg.width = 800;
        cfg.height = 480;

        new LwjglApplication(new SomeCoolGame(), cfg);
    }
}
