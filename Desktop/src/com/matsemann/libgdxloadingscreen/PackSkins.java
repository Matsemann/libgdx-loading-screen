package com.matsemann.libgdxloadingscreen;

import com.badlogic.gdx.tools.imagepacker.TexturePacker2;

/**
 * @author Mats Svensson
 */
public class PackSkins {

    public static void main(String[] args) {
        TexturePacker2.Settings s = new TexturePacker2.Settings();
        TexturePacker2.process(s, "Main/workfiles/finished", "Android/assets/data", "loading.pack");
    }
}
