package com.mygdx.game.rungun.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class GameScreen extends MyScreen {

    public GameScreen(Game game) {
        super(game);
    }


    @Override
    public void render(float delta) {
        // clear screen is mandatory
        clearScreen();
        batch.begin();

        BitmapFont font = new BitmapFont();
        font.setColor(1,0,0,1);
        font.getData().setScale(2.5f);
        font.draw(batch, "the game goes here " , Gdx.graphics.getWidth() / 2.0f - 50  ,Gdx.graphics.getHeight() - 50);

        batch.end();
    }
}
