package com.mygdx.game.rungun.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.rungun.components.DefaultButton;
import com.mygdx.game.rungun.constants.Constants;
import com.mygdx.game.rungun.entities.Enemy;
import com.mygdx.game.rungun.map.Direction;
import com.mygdx.game.rungun.map.Map;

import java.util.ArrayList;
import java.util.List;

import static com.mygdx.game.rungun.constants.ImageTransform.load100By100;

public class GameScreen extends MyScreen {

    DefaultButton menu;
    Dialog dialog;
    List<Enemy> enemies;
    DefaultButton homeButton;
    Map map;
    float speed;
    boolean isPaused;
    Group bg, fg;
    Image pauseImg = new Image(load100By100("pause.png"));

    public GameScreen(Game game) {
        super(game);
        this.bg = new Group();
        this.fg = new Group();
        stage.addActor(bg);
        stage.addActor(fg);
        createMenu();
        createHomeButton(game);
        this.map = new Map();
        this.enemies = new ArrayList<>();
        this.enemies.add(new Enemy());
        this.speed = 0.1f;
        this.isPaused = false;
    }

    private void createHomeButton(Game game) {
        this.homeButton = new DefaultButton("Home", Color.NAVY);
        this.homeButton.setPosition(30, 30);
        this.homeButton.onClick((event, actor) -> {
            game.setScreen(new MenuScreen(game));
            return null;
        });
        bg.addActor(homeButton);
    }

    private void createMenu() {
        this.menu = new DefaultButton("Menu", Color.GRAY);
        this.menu.setPosition(30, 100);
        this.menu.onClick(((changeEvent, actor) -> {
            pauseGame();
            return null;
        }));
        bg.addActor(menu);
    }

    private void pauseGame() {
        this.isPaused = true;
        this.speed = 0;
        showPauseImage(true);
        openDialog();
    }

    private void resumeGame() {
        this.isPaused = false;
        this.speed = 0.1f;
        showPauseImage(false);
    }

    public void openDialog() {
        this.dialog = new Dialog("Menu", Constants.skin);
        this.dialog.setVisible(true);
        this.dialog.setWidth(250);
        this.dialog.setHeight(250);
        this.dialog.setPosition(horizontallyCentered(dialog), verticallyCentered(dialog));
        DefaultButton closeDialogButton = new DefaultButton("Close", Color.GRAY);
        closeDialogButton.setVisible(true);
        closeDialogButton.setPosition(horizontallyCentered(dialog), verticallyCentered(dialog));
        closeDialogButton.onClick((changeEvent, actor) -> {
            this.fg.removeActor(dialog);
            this.stage.addActor(fg);
            resumeGame();
            return null;
        });
        this.fg.addActor(dialog);
        this.dialog.add(closeDialogButton);
    }

    private void showPauseImage(boolean visible) {
        pauseImg.setX(Gdx.graphics.getWidth() / 2.0f - 50);
        pauseImg.setY(Gdx.graphics.getHeight() - 250);
        pauseImg.setVisible(visible);
        fg.addActor(pauseImg);
    }


    @Override
    public void render(float delta) {
        // clear screen is mandatory
        clearScreen();
        batch.begin();

        // draw map
        this.map.drawHiddenButton(bg, stage);
        this.map.drawTiles(batch);


        // draw enemies
        for(Enemy e : enemies) {
            e.move(Direction.EAST, speed);
            e.draw(batch, delta, isPaused);
        }

        // pause
        //if(this.dialog != null && this.dialog.isVisible()) {
        //    this.fg.addActor(dialog);
        //}

        // draw buttons
        if(isPaused) {
            this.fg.draw(batch, 100);
        } else {
            this.fg.draw(batch, 100);
        }

        // stop rendering
        batch.end();
    }
}
