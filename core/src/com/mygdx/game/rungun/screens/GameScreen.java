package com.mygdx.game.rungun.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.rungun.components.DefaultButton;
import com.mygdx.game.rungun.map.Map;

public class GameScreen extends MyScreen {

    DefaultButton openDialogButton;
    Dialog dialog;
    DefaultButton closeDialogButton;
    float circleX, circleY;
    DefaultButton homeButton;
    Map map;

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
        this.homeButton = new DefaultButton("Home", Color.NAVY );
        this.homeButton.setPosition(100,30);
        this.stage.addActor(homeButton);
        this.homeButton.onClick((event, actor) -> {
            game.setScreen(new MenuScreen(game));
            return null;
        });
        this.map = new Map();

    }

    public void openDialog() {
        this.dialog = new Dialog("Menu", new Skin(Gdx.files.internal("ui/uiskin.json")));
        this.dialog.setVisible(true);
        this.dialog.setPosition(horizontallyCentered(dialog), verticallyCentered(dialog));
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
        //BitmapFont font = new BitmapFont();
        //font.setColor(1,0,0,1);
//
        //font.draw(batch, "the game goes here " , Gdx.graphics.getWidth() / 2.0f - 50  ,Gdx.graphics.getHeight() - 50);


        this.stage.draw();
        renderer.setAutoShapeType(true);
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.circle(Gdx.input.getX(0),Gdx.graphics.getHeight()- Gdx.input.getY(0),10);
        renderer.setAutoShapeType(false);
        // font.getData().setScale(2.5f);
        this.map.draw(renderer, stage);
        renderer.end();
        batch.end();
    }
}
