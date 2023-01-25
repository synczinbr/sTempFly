package com.github.synczinbr.tempfly.managers;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.github.synczinbr.tempfly.TemporaryFly;

public class FlyManager {

	static ArrayList<String> active = new ArrayList<>();

	public static void EnableFly(Player target, String rawtime, Long interval, String staffname) {
		target.setAllowFlight(true);
		target.sendMessage("§aO seu vôo foi ativado durante " + rawtime + " minutos.");
		active.add(target.getName());
		Bukkit.getScheduler().scheduleSyncDelayedTask(TemporaryFly.instance, () -> Disable(target), interval);
	}

	public static void Disable(Player target) {
		target.setAllowFlight(false);
		target.sendMessage("§cO seu tempo de vôo acabou.");
		active.remove(target.getName());
	}

	public static ArrayList<String> getActivePlayers() {
		return active;
	}

}
