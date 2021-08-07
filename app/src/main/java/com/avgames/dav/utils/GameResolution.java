package com.avgames.dav.utils;
import android.graphics.Point;

public enum GameResolution
{
	_480, _720, _1080, _2160;
	public static Point getResoultion(GameResolution res)
	{
		Point gr = null;
		switch(res)
		{
			case _480: gr = new Point(858,480); break;
			case _720: gr = new Point(1280,720); break;
			case _1080: gr = new Point(1920,1080); break;
			case _2160: gr = new Point(3860,2160); break;
			default: new Point(1920,1080); break;
		}
		return gr;
	}
}
