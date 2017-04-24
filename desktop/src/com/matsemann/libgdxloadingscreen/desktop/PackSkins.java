package com.matsemann.libgdxloadingscreen.desktop;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;

/**
 * @author Mats Svensson
 */
public class PackSkins {

    public static void main(String[] args) {
    	TexturePacker.process("../../core/workfiles/finished", "data", "loading.pack");
    }
}
