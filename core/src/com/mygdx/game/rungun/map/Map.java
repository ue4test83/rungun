package com.mygdx.game.rungun.map;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private final int SIZE = 10;
    private final int OFFSET_X = 350;
    private final int OFFSET_Y = 170;
    List<List<MapCell>> map;

    public Map() {
        this.map = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            List<MapCell> col = new ArrayList<>();
            for (int j = 0; j < SIZE; j++) {
                // simulate a path
                if(j == 5 || j == 4) {
                    col.add(createPathCell());
                } else {
                    col.add(createMapCell());
                }
            }
            this.map.add(col);

        }
    }

    private MapCell createPathCell() {
        return new MapCell(CellKind.PATH);
    }


    private MapCell createMapCell() {
        return new MapCell(CellKind.TOWER_BASE);
    }

    public void drawTiles(Batch batch) {
        for (int i = 0; i < SIZE; i++) {
            List<MapCell> col = map.get(i);
            for (int j = 0; j < SIZE; j++) {
                MapCell mapCell = col.get(j);
                batch.draw(mapCell.getTexture(),i * 51 + OFFSET_X, j * 51 + OFFSET_Y);
            }
        }
    }



}
