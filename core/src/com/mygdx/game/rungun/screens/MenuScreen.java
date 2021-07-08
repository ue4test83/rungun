package com.mygdx.game.rungun.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class MenuScreen extends MyScreen {

    TextButton playButton;
    TextButton quitButton;
    Batch batch;
    Stage stage;

    public MenuScreen(final Game game) {
        super(game);
        TextButton.TextButtonStyle tbs = new TextButton.TextButtonStyle();
        tbs.font = new BitmapFont();
        this.quitButton = new TextButton("Quit", tbs);
        this.playButton = new TextButton("Play", tbs);
        this.playButton.setPosition(Gdx.graphics.getWidth() / 2.0f - 50 , Gdx.graphics.getHeight() / 2.0f);
        this.quitButton.setPosition(Gdx.graphics.getWidth() / 2.0f - 50 , Gdx.graphics.getHeight() / 2.0f - 50 );
        this.quitButton.setDisabled(false);
        this.quitButton.setHeight(50);
        this.quitButton.setWidth(250);
        this.quitButton.setColor(1,0,0,1);

        this.playButton.setDisabled(false);
        this.playButton.setHeight(50);
        this.playButton.setWidth(250);
        this.playButton.setColor(1,0,0,1);
        this.batch = new SpriteBatch();
        this.stage = new Stage();
        this.stage.addActor(quitButton);
        this.stage.addActor(playButton);

        playButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new GameScreen(game));
            }
        });

        quitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });

    }

    @Override
    public void show() {
        super.show();
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        // clear screen is mandatory
        clearScreen();
        batch.begin();
        if(playButton.getClickListener().isPressed()) {
            this.game.setScreen(new GameScreen(game));
        }

        if(this.quitButton.getClickListener().isPressed()) {
            dispose();
        }

        this.stage.draw();

        BitmapFont font = new BitmapFont();
        font.setColor(1,0,0,1);
        font.getData().setScale(2.5f);
        font.draw(batch, "You can write text like this " , Gdx.graphics.getWidth() / 2.0f - 50  ,Gdx.graphics.getHeight() - 50);

        batch.end();
    }
}
