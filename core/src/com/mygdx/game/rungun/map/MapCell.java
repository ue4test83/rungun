package com.mygdx.game.rungun.map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import static com.mygdx.game.rungun.constants.ImageTransform.load50By50;

public class MapCell extends Actor {

    private Texture texture;
    private CellKind cellKind;

    MapCell(CellKind cellKind) {
        switch (cellKind) {
            case NONE:
            case PATH: {
                texture = load50By50("dirt.png");
                break;
            }
            case TOWER_BASE: {
                texture = load50By50("grass.png");
            }
        }
        this.cellKind = cellKind;
    }

    @Override
    public boolean addListener(EventListener listener) {
        return super.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Clicked!");
            }
        });
    }


    public CellKind getCellKind() {
        return cellKind;
    }

    public Texture getTexture() {
        return texture;
    }
}
