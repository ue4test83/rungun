package com.mygdx.game.rungun.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.rungun.map.Direction;

public class Enemy {

    TextureRegion[] animationFrames;
    Animation<TextureRegion> animation;
    Texture texture;
    float elapsedTime = 0;
    Vector2 coordinates;

    public Enemy() {
        texture = new Texture("Minotaur.png");

        TextureRegion[][] tmp = TextureRegion.split(texture, 96, 96);
        animationFrames = new TextureRegion[8];
        int index = 0;
        for(int i = 0; i < 8; i++) {
            animationFrames[index++] = tmp[1][i];
        }
        animation = new Animation<>(0.20f, animationFrames);
        this.coordinates = new Vector2(800,350);
    }

    public void move(Direction direction, float speed){
        switch (direction) {
            case EAST: {
                this.coordinates.set(this.coordinates.x - speed, this.coordinates.y);
                break;
            }
            case WEST: {
                this.coordinates.set(this.coordinates.x + speed, this.coordinates.y);
                break;
            }
            case NORTH: {
                this.coordinates.set(this.coordinates.x, this.coordinates.y + speed);
                break;
            }
            case SOUTH: {
                this.coordinates.set(this.coordinates.x, this.coordinates.y - speed);
                break;
            }
        }
    }

    public void draw(Batch batch, float elapsedTime, boolean gameIsPaused) {
        this.elapsedTime = gameIsPaused ? this.elapsedTime : this.elapsedTime + elapsedTime;
        TextureRegion frame = animation.getKeyFrame(this.elapsedTime, true);
        if(!frame.isFlipX()) frame.flip(true, false);
        batch.draw(frame, this.coordinates.x, this.coordinates.y);
    }
}
