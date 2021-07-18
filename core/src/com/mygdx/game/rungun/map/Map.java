package com.mygdx.game.rungun.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map {
    private final int SIZE = 10;
    private final int OFFSET_X = 350;
    private final int OFFSET_Y = 170;
    List<List<TextButton>> map;
    private static Skin skin = new Skin(Gdx.files.internal("ui/uiskin.json"));

    public Map() {
        this.map = new ArrayList<>();
        for(int i =0; i < SIZE; i ++){
            List<TextButton> col = new ArrayList<>();
            for (int j =0; j < SIZE; j ++){

                col.add(createTextButton("false", Color.NAVY));
            }
            this.map.add(col);
        }

        this.map.get(new Random().nextInt(10)).set(new Random().nextInt(10), createTextButton("true", Color.GOLD));
    }

    private TextButton createTextButton(String label, Color color){
        TextButton button = new TextButton(label, skin );
        button.setWidth(50);
        button.setHeight(50);
        button.setColor(color);

        return button;
    }
    public void draw(ShapeRenderer renderer, Stage stage) {
        for(int i =0; i < SIZE; i ++){
            List<TextButton> col = this.map.get(i);
            for (int j =0; j < SIZE; j ++){
                TextButton tb = col.get(j);
                boolean cellValue = tb.getText().equals("true");
                tb.setX(i*51 + OFFSET_X);
                tb.setY(j*51 + OFFSET_Y);
                stage.addActor(tb);
                /*if(cellValue){
                    renderer.setColor(Color.BLACK);
                    renderer.rect(i*51 + OFFSET_X, j*51 + OFFSET_Y, 50, 50);
                } else {
                    renderer.setColor(Color.BROWN);
                    renderer.rect(i*51 + OFFSET_X, j*51 + OFFSET_Y, 50, 50);
                }*/
            }
            this.map.add(col);
        }
    }
}
