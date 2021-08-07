package com.avgames.dav.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class UIManager
{
	public static Color dialogBackgroundColor, dialogHexBackground, dialogHexBorder,
	dialogButtonsColor, dialogButtonsBackground, dialogButtonsBorderColor;
	
	public static Color levelChooserBackground, levelChooserWave, levelChooserHexBG, levelChooserHexBorder;
	
	public static Color baseMenuBackground, baseMenuHexBackground, baseMenuHexBorder;
	
	//Hex level colors
	public static Color backgroundHexagonalColor;
	public static Color innerNotFixed, innerFixed,
	sidesColor,centerColor, innerCenterColor,
	blockedColor, cornerColor, lockedColor,
	connectedColor, clearColor, mainHexColor, starHexColor;
	
	//public static ScreenBackground backgroundImage;
	public static TextButton.TextButtonStyle levelNumsButtonStyle, menuTextStyle, settingsTextStyle;
	public static Label.LabelStyle titleStyle, simpleStyle, settingLabelStyle;
	public static GameResolution gameResolution;

	public static final int widthScreen = Gdx.graphics.getWidth();
	public static final int heightScreen = Gdx.graphics.getHeight();
	
	public UIManager()
	{
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA,GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glDepthMask(false);
		
		clearColor = Color.CLEAR;
		
		innerFixed = new Color(1f,158/255f,157/255f,1);
		innerNotFixed = new Color(63/255f,184/255f,175/255f,1);
		sidesColor = Color.DARK_GRAY;
		centerColor = Color.BLACK;
		innerCenterColor = clearColor;
		connectedColor = centerColor;
		blockedColor = new Color(1f,61/255f,127/255f,1);
		//new Color(215/255f,159/255f,219/255f,1);
		
		cornerColor = new Color(127/255f,199/255f,175/255f,1);
		mainHexColor = new Color(1f,253/255f,171/255f,1);
		starHexColor = new Color(255/255f,215/255f,0/255f,1);//gold
		lockedColor = blockedColor;
		//new Color(218/255f,165/255f,32/255f,1);//goldenrod
		//new Color(1f,140/255f,0,1);//darkorange
		//new Color(210/255f,105/255f,30/255f,1);//chocolate
		
		backgroundHexagonalColor = cornerColor;
		dialogBackgroundColor = AddtionalFunctions.colorA(cornerColor,.6f);
		dialogHexBackground = innerNotFixed;
		dialogHexBorder = centerColor;
		
		dialogButtonsColor = centerColor;
		dialogButtonsBackground = mainHexColor;
		dialogButtonsBorderColor = starHexColor;
		
		levelChooserBackground = lockedColor;
		levelChooserWave = innerNotFixed;
		levelChooserHexBG = innerNotFixed;
		levelChooserHexBorder = cornerColor;
		
		baseMenuBackground = innerNotFixed;
		baseMenuHexBackground = blockedColor;
		baseMenuHexBorder = starHexColor;
		//
		
		levelNumsButtonStyle = new TextButton.TextButtonStyle(null,null,null,
			initFont(Constants.fontPath_national_park_heavy, UIManager.heightScreen/16,
				Color.BLACK,null,null));
				
		menuTextStyle = new TextButton.TextButtonStyle(null, null, null, 
			initFont(Constants.fontPath_national_park_regular, UIManager.heightScreen/10,
				Color.BLACK,null,null));
				
		titleStyle = new Label.LabelStyle();
		titleStyle.font = initFont(Constants.fontPath_national_park_heavy,UIManager.heightScreen/8,
			innerNotFixed,starHexColor,null);
		
		simpleStyle = new Label.LabelStyle();
		simpleStyle.font = initFont(Constants.fontPath_national_park_regular, UIManager.heightScreen/10,
			Color.BLACK,null,null);
			
		settingsTextStyle = new TextButton.TextButtonStyle();
		settingsTextStyle.font = UIManager.initFont(Constants.fontPath_national_park_thin, UIManager.heightScreen/16,Color.BLACK,null,null);
		
		settingLabelStyle = new Label.LabelStyle();
		settingLabelStyle.font = initFont(Constants.fontPath_national_park_thin, UIManager.heightScreen/16,
									Color.BLACK,null,null);
			
		update();
	}
	
	public static void update()
	{
		gameResolution = GameResolution.valueOf(getPreferences().getString(Constants.GAME_RESOLUTION,Constants.defaultGameResolution));
	}
	
	public static BitmapFont initFont(String fontPath,int fontSize, Color fontColor, Color borderColor, Color shadowColor)
	{
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(fontPath));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size = fontSize;
		if(borderColor!=null)
		{
			parameter.borderColor = borderColor;
			parameter.borderStraight = true;
			parameter.borderWidth = 5;
		}
		parameter.color = fontColor;
		parameter.incremental = true;
		parameter.kerning = true;
		//parameter.minFilter = Texture.TextureFilter.Nearest;
		if (shadowColor!=null)
		{
			parameter.shadowColor = shadowColor;
			parameter.shadowOffsetX = 5;
			parameter.shadowOffsetY = 5;
		}
		parameter.spaceX = 9;
		parameter.spaceY = 9;
		parameter.borderGamma = 0.5f;
		parameter.gamma = 0.5f;
		BitmapFont font = generator.generateFont(parameter);
		generator.dispose();
		return font;
	}
	
	public static android.content.SharedPreferences getPreferences()
	{
		return ((android.app.Activity)(Gdx.app)).getPreferences(android.content.Context.MODE_PRIVATE);
	}
	
	/*public static Label getLabel(String s, BitmapFont font)
	{
		Label.LabelStyle style = new Label.LabelStyle();
		style.font = font;
		return new Label(s,style);
	}
	
	public static BitmapFont getVirgoFont()
	{
		return initFont(Constants.fontPath_national_park_heavy,UIManager.heightScreen/8,
			innerNotFixed,starHexColor,null);
	}
	
	public static BitmapFont getSimpleFont()
	{
		return initFont(Constants.fontPath_national_park_regular, UIManager.heightScreen/10,
			Color.BLACK,null,null);
	}*/
	
	/*public static TextureRegionDrawable drawArrow(int psize, boolean mirror)
	{
		Pixmap pnext = new Pixmap(psize,psize, Pixmap.Format.RGBA8888);
		pnext.setBlending(Pixmap.Blending.None);
		pnext.setColor(clearColor);
		pnext.fill();
		pnext.setColor(levelPageChangeArrowColor);
		int c = psize/2;
		int arrow = psize/2;
		//float amount = psize;
		//for(int j=0;j<amount*.90f;j++)
		//{
		//	pnext.fillCircle((int)AddtionalFunctions.lerp(0,psize,j/amount),c,(int)(c*.1f));
		//}

		PointF pf = AddtionalFunctions.triangleStraight3V_01(psize-arrow,c,psize,c,-arrow);
		pnext.fillTriangle(psize-arrow,c,psize,c,(int)pf.x,(int)pf.y);
		pf = AddtionalFunctions.triangleStraight3V_01(psize-arrow,c,psize,c,arrow);
		pnext.fillTriangle(psize-arrow,c,psize,c,(int)pf.x,(int)pf.y);
		TextureRegion tnext =new TextureRegion( new Texture(pnext));
		tnext.flip(mirror,false);
		return new TextureRegionDrawable(tnext);
	}*/
	
}
