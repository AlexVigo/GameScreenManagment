package com.avgames.dav;

import com.avgames.dav.utils.ScreenManager;
import com.avgames.dav.utils.UIManager;


public class DAVGameClass extends com.badlogic.gdx.Game {
	UIManager ui;
	@Override
	public void create()
	{
		ui = new UIManager();
		new ScreenManager(this);
	}

	@Override
	public void render()
	{
		super.render();
	}

	@Override
	public void dispose()
	{
		getScreen().dispose();
	}

	@Override
	public void resize(int width, int height)
	{
		getScreen().resize(width,height);
	}

	@Override
	public void pause()
	{
		getScreen().pause();
	}

	@Override
	public void resume()
	{
		getScreen().resume();
	}
}
