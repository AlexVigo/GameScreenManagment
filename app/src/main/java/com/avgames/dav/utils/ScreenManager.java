package com.avgames.dav.utils;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.avgames.dav.screens.*;
import java.util.ArrayList;
import com.badlogic.gdx.Gdx;

public class ScreenManager
{
	public enum ScreensEnum {
		defaultErrorScreen
		}
	private static ScreenManager screenManager;
	private Game gameref;
	
	public static ScreenManager getScreenManager()
	{
		assert (screenManager == null) : "Screen manager is not created";
		return screenManager;
	}
	
	public ScreenManager(Game game)
	{
		Gdx.input.setCatchBackKey(true);
		this.gameref = game;
		this.screenManager = this;
		showScreen(ScreensEnum.startScreen);
	}
	
	public void showScreen(ScreensEnum screenID, Object ... params) 
	{
		Screen currentScreen = gameref.getScreen();
		AbstractBaseScreen newScreen = getScreenFromEnum(screenID, params);

		gameref.setScreen(newScreen);
		newScreen.loadStage();

		if (currentScreen != null) {
			currentScreen.dispose();
			currentScreen = null;
		}
	}
	
	private AbstractBaseScreen getScreenFromEnum(ScreensEnum screenID, Object ... params)
	{
		switch(screenID)
		{
			default : return createErrorScreen();
		}
	}
	
	private static AbstractBaseScreen createErrorScreen() {return new ErrorScreen();}
}
