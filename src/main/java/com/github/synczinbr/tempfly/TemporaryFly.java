package com.github.synczinbr.tempfly;

import com.github.synczinbr.tempfly.events.WorldListener;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.synczinbr.tempfly.commands.TempFly;
import com.github.synczinbr.tempfly.utils.Log;

import java.io.File;

public class TemporaryFly extends JavaPlugin {

	public static TemporaryFly instance;
	
	public void onEnable() {
		TemporaryFly.instance = this;
		Log.success("Ligado.");
		new WorldListener(instance);
		File configuration = new File(getDataFolder(), "config.yml");
		if (!configuration.exists()) saveResource("config.yml", false);
		getCommand("tempfly").setExecutor(new TempFly());
	}
	
}