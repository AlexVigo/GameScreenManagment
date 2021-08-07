package com.avgames.dav.screens;

import com.badlogic.gdx.utils.viewport.FitViewport;
import com.avgames.dav.utils.UIManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class AbstractBaseScreen extends com.badlogic.gdx.scenes.scene2d.Stage implements com.badlogic.gdx.Screen
{
	protected abstract void createStage();
	public abstract void loadStage();
	private boolean runState = true;
	private float worldTime = 0, timeMultiplier = 1;
	
	public float getWorldTime()
	{
		return worldTime;
	}
	
	public void setWorldTime(float time)
	{
		worldTime = time;
	}
	
	public float getTimeMultiplier()
	{
		return timeMultiplier;
	}

	public void setTimeMultiplier(float multiplier)
	{
		timeMultiplier = multiplier;
	}
	
	private void internalCreate()
	{
		com.badlogic.gdx.Gdx.input.setInputProcessor(this);
		worldTime = 0;
		timeMultiplier = 1;
		createStage();
	}
	
	public AbstractBaseScreen()
	{
		super(
			new FitViewport(
				UIManager.widthScreen,
				UIManager.heightScreen,
				new OrthographicCamera()),
			new SpriteBatch());
			
        getViewport().apply();
        getCamera().position.set(getCamera().viewportWidth / 2, getCamera().viewportHeight / 2, 0);
        getCamera().update(); 
		internalCreate();
	}

	@Override
	public void render(float p1)
	{
		if (runState) 
			super.act(p1);
		com.avgames.dav.utils.AddtionalFunctions.clearScreen();
		super.draw();
		if (runState) worldTime += p1 * timeMultiplier;
	}

	@Override
	public void show() {}

	@Override
	public void resize(int p1, int p2)
	{
		getViewport().update(p1,p2,true);
	}
	
	@Override public void hide() {}
	
	public boolean isPaused() 
	{
		return !runState;
	}
	
	@Override 
	public void pause()
	{
		runState = false;
	}

	@Override
	public void dispose()
	{
		super.dispose();
	}
	
	@Override 
	public void resume() 
	{
		runState = true;
	}
}
