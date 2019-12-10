package com.joungwon.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.joungwon.game.MoonBunny;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = MoonBunny.WIDTH;
		config.height = MoonBunny.HEIGHT;
		config.title = MoonBunny.TITLE;
		new LwjglApplication(new MoonBunny(), config);
	}
}
