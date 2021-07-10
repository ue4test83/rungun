package com.mygdx.game.rungun.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.rungun.components.DefaultButton;

public class GameScreen extends MyScreen {

    DefaultButton openDialogButton;
    Dialog dialog;
    DefaultButton closeDialogButton;
    float circleX, circleY;

    public GameScreen(Game game) {
        super(game);
        this.openDialogButton = new DefaultButton("Menu", Color.GRAY);
        this.openDialogButton.setPosition(100,100);
        this.openDialogButton.onClick(((changeEvent, actor) -> {
            openDialog();
            return null;
        }));
        this.stage.addActor(openDialogButton);
       this.circleX = 500;
       this.circleY = 500;
    }

    public void openDialog() {
        this.dialog = new Dialog("Menu", new Skin(Gdx.files.internal("ui/uiskin.json")));
        this.dialog.setVisible(true);
        this.dialog.setPosition(500,500);
        this.dialog.setWidth(200);
        this.dialog.setHeight(500);
        this.dialog.text("This is a dialog");
        this.closeDialogButton = new DefaultButton("Close", Color.GRAY);
        this.closeDialogButton.onClick((changeEvent, actor) -> {
            this.dialog.setVisible(false);
            return null;
        });
        this.dialog.button(closeDialogButton);
        this.stage.addActor(dialog);
    }




    @Override
    public void render(float delta) {
        // clear screen is mandatory
        clearScreen();
        batch.begin();


        this.stage.draw();
        // renderer.setAutoShapeType(true);
        // renderer.begin();
        // renderer.circle(circleX,circleY,10);
        // renderer.setAutoShapeType(false);
        BitmapFont font = new BitmapFont();
        font.setColor(1,0,0,1);
        // font.getData().setScale(2.5f);
        font.draw(batch, "the game goes here " , Gdx.graphics.getWidth() / 2.0f - 50  ,Gdx.graphics.getHeight() - 50);
        renderer.end();
        batch.end();
    }
}
