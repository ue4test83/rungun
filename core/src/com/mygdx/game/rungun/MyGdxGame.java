package com.mygdx.game.rungun;

import com.badlogic.gdx.Game;
import com.mygdx.game.rungun.screens.MenuScreen;

public class MyGdxGame extends Game {

	@Override
	public void create () {
		setScreen(new MenuScreen(this));
	}


}