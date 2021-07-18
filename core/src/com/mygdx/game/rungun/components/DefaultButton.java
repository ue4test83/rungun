package com.mygdx.game.rungun.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.rungun.constants.Constants;

import java.util.function.BiFunction;

public class DefaultButton extends TextButton {

    private final int DEFAULT_WIDTH = 250;
    private final int DEFAULT_HEIGHT = 50;

    public DefaultButton(String text, Color backgroundColor) {
        super(text, Constants.skin);
        this.setDisabled(false);
        this.setHeight(DEFAULT_HEIGHT);
        this.setWidth(DEFAULT_WIDTH);
        this.setColor(backgroundColor);
    }

    public float horizontallyCentered(){
        return (Gdx.graphics.getWidth() / 2.0f) - (this.getWidth() / 2.0f);
    }

    public float verticallyCentered(){
        return Gdx.graphics.getHeight() / 2.0f;
    }

    public void onClick(final BiFunction<ChangeListener.ChangeEvent, Actor, Void> f) {
        this.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                f.apply(event, actor);
            }
        });
    }
}
