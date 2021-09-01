package com.mygdx.game;


import com.badlogic.gdx.Game;

import com.mygdx.game.Screen.MenuScreen;

public class StarGame extends Game {

	
	@Override
	public void create () {
		setScreen(new MenuScreen());
	}

}
