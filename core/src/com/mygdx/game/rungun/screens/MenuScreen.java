package com.mygdx.game.rungun.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.mygdx.game.rungun.components.DefaultButton;

public class MenuScreen extends MyScreen {

    DefaultButton playButton;
    DefaultButton quitButton;
    BitmapFont font;

    public MenuScreen(final Game game) {
        super(game);
        this.quitButton = new DefaultButton("Quit", Color.GRAY);
        this.playButton = new DefaultButton("Play", Color.LIME);
        this.playButton.setPosition(playButton.horizontallyCentered(), playButton.verticallyCentered());
        this.quitButton.setPosition(quitButton.horizontallyCentered(), quitButton.verticallyCentered() - 100 );
        this.stage.addActor(quitButton);
        this.stage.addActor(playButton);
        this.playButton.onClick((event, actor) -> {
            game.setScreen(new GameScreen(game));
            return null;
        });
        this.quitButton.onClick((event, actor) -> {
            Gdx.app.exit();
            return null;
        });

        font = new BitmapFont();
        font.setColor(1,0,0,1);
        font.getData().setScale(2.5f);

    }


    @Override
    public void render(float delta) {
        // clear screen is mandatory
        clearScreen();
        batch.begin();

        this.stage.draw();

        font.draw(batch, "You can write text like this " , Gdx.graphics.getWidth() / 2.0f - 50  ,Gdx.graphics.getHeight() - 50);

        batch.end();
    }
}
