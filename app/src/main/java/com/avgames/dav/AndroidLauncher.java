package com.avgames.dav;

import android.os.Bundle;

import com.avgames.dav.sqlite.DBHelper;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class AndroidLauncher extends AndroidApplication {
	DBHelper dbHelper;
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new DAVGameClass(), config);

		dbHelper = new DBHelper(getContext());

		/*
		MobileAds.initialize(this, new OnInitializationCompleteListener() {
				@Override
				public void onInitializationComplete(InitializationStatus initializationStatus) {
				}
			});*/
	}

	@Override
	protected void onDestroy() {
		dbHelper.close();
		super.onDestroy();
	}
}
