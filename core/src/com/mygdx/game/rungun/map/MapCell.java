package com.mygdx.game.rungun.map;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mygdx.game.rungun.components.DefaultButton;

import java.util.Optional;

import static com.mygdx.game.rungun.constants.ImageTransform.load50By50;

public class MapCell {

    private Texture texture;
    private Optional<TextButton> hiddenButton;
    private CellKind cellKind;

    MapCell(CellKind cellKind) {
        switch (cellKind) {
            case NONE:
            case PATH: {
                hiddenButton = Optional.empty();
                texture = load50By50("dirt.png");
                break;
            }
            case TOWER_BASE: {
                DefaultButton tb = new DefaultButton("", Color.NAVY);
                tb.setWidth(50);
                tb.setHeight(50);
                tb.onClick((changeEvent, actor) -> {
                    System.out.println("Clicked!");
                    return null;
                });

                this.hiddenButton = Optional.of(tb);
                texture = load50By50("grass.png");
            }
        }
        this.cellKind = cellKind;
    }

    public TextButton getHiddenButton() {
        return hiddenButton.orElse(null);
    }


    public CellKind getCellKind() {
        return cellKind;
    }

    public Texture getTexture() {
        return texture;
    }
}
