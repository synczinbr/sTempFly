package com.github.synczinbr.tempfly.utils;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import com.github.synczinbr.tempfly.TemporaryFly;

import net.md_5.bungee.api.ChatColor;


public class Log {
	private static final CommandSender console;
	
	static {
		console = Bukkit.getConsoleSender();
	}
	
	Plugin instance = TemporaryFly.instance;
	private static String $plugin_name_prefix = "[TemporaryFly] "; 
	
	public static void clean(String message) {
		console.sendMessage(ChatColor.GREEN + "[syncPlugins] " + $plugin_name_prefix + ChatColor.WHITE + "" + message);
	}
	
	public static void info(String message) {
		console.sendMessage(ChatColor.GREEN + "[syncPlugins] " + $plugin_name_prefix + ChatColor.AQUA + "[INFO] " + ChatColor.WHITE + "" + message);
	}
	
	public static void success(String message) {
		console.sendMessage(ChatColor.GREEN + "[syncPlugins] " + $plugin_name_prefix + ChatColor.GREEN + "[SUCESSO] " + ChatColor.WHITE + "" + message);
	}
	
	public static void warn(String message) {
		console.sendMessage(ChatColor.GREEN + "[syncPlugins] " + $plugin_name_prefix + ChatColor.YELLOW + "[WARN] " + ChatColor.WHITE + "" + message);
	}
	
	public static void error(String message) {
		console.sendMessage(ChatColor.GREEN + "[syncPlugins] " + $plugin_name_prefix + ChatColor.RED + "[ERROR] " + ChatColor.WHITE + "" + message);
	}
	
	public static void fatal(String message) {
		console.sendMessage(ChatColor.GREEN + "[syncPlugins] " + $plugin_name_prefix + ChatColor.DARK_RED + "[FATAL] " + ChatColor.WHITE + "" + message);
	}
}
