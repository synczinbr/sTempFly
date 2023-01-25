package com.github.synczinbr.tempfly;

import org.bukkit.plugin.java.JavaPlugin;

import com.github.synczinbr.tempfly.commands.TempFly;
import com.github.synczinbr.tempfly.utils.Log;

public class TemporaryFly extends JavaPlugin {

	public static TemporaryFly instance;
	
	public void onEnable() {
		TemporaryFly.instance = this;
		Log.success("Ligado.");
		getCommand("tempfly").setExecutor(new TempFly());
		getCommand("flytemp").setExecutor(new TempFly());
	}
	
}