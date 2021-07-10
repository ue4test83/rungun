package com.mygdx.game.rungun.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Super class for screens.
 * You should not add anything here, or ask me beforehand.
 */
public class MyScreen implements Screen {

    Game game;
    Batch batch;
    Stage stage;
    ShapeRenderer renderer;

    MyScreen(Game game) {
        this.game = game;
        this.batch = new SpriteBatch();
        this.stage = new Stage();
        this.renderer = new ShapeRenderer();
        this.renderer.setAutoShapeType(true);
    }

    /**
     * Mandatory to clear screen after each refresh.
     */
    void clearScreen() {
        Gdx.gl.glClearColor( 0.15f, 0.15f, 0.15f, 1 );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override public void render(float delta) {}
    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() {}
}
