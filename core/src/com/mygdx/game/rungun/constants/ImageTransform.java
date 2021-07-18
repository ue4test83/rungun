package com.mygdx.game.rungun.constants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

public abstract class ImageTransform {


    public static Texture load50By50(String path){
        return loadAndResize(path, 50);
    }


    public static Texture load100By100(String path){
        return loadAndResize(path, 100);
    }

    private static Texture loadAndResize(String path, int size){

        Pixmap pixmap256 = new Pixmap(Gdx.files.internal(path));
        Pixmap pixmap50 = new Pixmap(size, size, pixmap256.getFormat());
        pixmap50.drawPixmap(pixmap256,
                0, 0, pixmap256.getWidth(), pixmap256.getHeight(),
                0, 0, pixmap50.getWidth(), pixmap50.getHeight()
        );
        Texture texture = new Texture(pixmap50);
        pixmap256.dispose();
        pixmap50.dispose();
        return texture;
    }
}
