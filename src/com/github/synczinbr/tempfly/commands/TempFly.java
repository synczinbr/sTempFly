package com.github.synczinbr.tempfly.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import com.github.synczinbr.tempfly.managers.FlyManager;

public class TempFly implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof ConsoleCommandSender) {
			if (args.length == 0) {
				sender.sendMessage("§f");
				sender.sendMessage("§b§lsTempFly §f➠  §eAjuda");
				sender.sendMessage("§f");
				sender.sendMessage("§b/tempfly help §f- §aretorna essa mensagem");
				sender.sendMessage("§b/tempfly give <player> <tempo> §f- §adá fly por tempo determinado pra um jogador");
				sender.sendMessage("§b/tempfly list §f- §amostra os jogadores que tem um tempfly ativo");
				sender.sendMessage("§f");
				sender.sendMessage("§7Observação: O tempo é dado em minutos.");
				sender.sendMessage("§f");
				return true;
			}
			if (args.length == 1 || args.length == 2) {
				String execute = args[0];
				if (execute.equalsIgnoreCase("help")) {
					sender.sendMessage("§f");
					sender.sendMessage("§b§lsTempFly §f➠  §eAjuda");
					sender.sendMessage("§f");
					sender.sendMessage("§b/tempfly help §f- §aretorna essa mensagem");
					sender.sendMessage("§b/tempfly give <player> <tempo> §f- §adá fly por tempo determinado pra um jogador");
					sender.sendMessage("§b/tempfly list §f- §amostra todos os jogadores que tem um fly temporário");
					sender.sendMessage("§f");
					return true;
				}
				if (execute.equalsIgnoreCase("list")) {
					sender.sendMessage("§b§lsTempFly §f➠  Há " + FlyManager.getActivePlayers().size() + " jogadores com tempfly.\n" + FlyManager.getActivePlayers().toString() + ".");
					return true;
				}
				sender.sendMessage("§b§lsTempFly §f➠  §cErro de sintaxe. §b(/tempfly help)");
				return true;
			}
			if (args.length >= 3) {
				String execute = args[0];
				Player target = Bukkit.getPlayerExact(args[1]);
				String rawtime = args[2];
				Long time = Long.valueOf(rawtime) * 20 * 60;
				if (time <= 0) {
					sender.sendMessage("§b§lsTempFly §f➠  §cO tempo inserido não é válido. (O tempo tem que ser maior que zero)");
				}
				if (target == null) {
					sender.sendMessage("§b§lsTempFly §f➠  §cO jogador '" + args[1] + "' não foi encontrado.");
					return true;
				}
				if (execute.equalsIgnoreCase("give")) {
					sender.sendMessage("§b§lsTempFly §f➠  §aVocê ativou o fly para " + target.getName() + " por " + rawtime + " minutos.");
					FlyManager.EnableFly(target, rawtime, time, "Console");
					return true;
				}
			}
			return true;
		}
		
		if (sender instanceof Player) {
			if (args.length == 0) {
				sender.sendMessage("§f");
				sender.sendMessage("§b§lsTempFly §f➠  §ev1.0-Stable");
				sender.sendMessage("§7Mais plugins como esse: https://github.com/synczinbr");
				sender.sendMessage("§f");
				return true;
			}
			
			if (!(sender.hasPermission("syncplugins.tempfly.admin"))) {
				sender.sendMessage("§bTempFly §f➠  §cVocê não tem permissão.");
				return true;
			}
			
			if (args.length == 1 || args.length == 2) {
				String execute = args[0];
				if (execute.equalsIgnoreCase("help")) {
					sender.sendMessage("§f");
					sender.sendMessage("§b§lsTempFly §f➠  §eAjuda");
					sender.sendMessage("§f");
					sender.sendMessage("§b/tempfly help §f- §aretorna essa mensagem");
					sender.sendMessage("§b/tempfly give <player> <tempo> §f- §adá fly por tempo determinado pra um jogador");
					sender.sendMessage("§b/tempfly list §f- §amostra todos os jogadores que tem um fly temporário");
					sender.sendMessage("§f");
					return true;
				}
				if (execute.equalsIgnoreCase("list")) {
					sender.sendMessage("§b§lsTempFly §f➠  Há " + FlyManager.getActivePlayers().size() + " jogadores com tempfly.\n" + FlyManager.getActivePlayers().toString() + ".");
					return true;
				}
				sender.sendMessage("§b§lsTempFly §f➠  §cErro de sintaxe. §b(/tempfly help)");
				return true;
			}
			if (args.length >= 3) {
				String execute = args[0];
				Player target = Bukkit.getPlayerExact(args[1]);
				String rawtime = args[2];
				try {
					Integer.parseInt(rawtime);
					Long time = Long.valueOf(rawtime) * 20 * 60;
					if (rawtime == null) {
						sender.sendMessage("§b§lsTempFly §f➠  §cO tempo inserido não é válido. (O tempo tem que ser maior que zero)");
						return true;
					}
					if (time <= 0) {
						sender.sendMessage("§b§lsTempFly §f➠  §cO tempo inserido não é válido. (O tempo tem que ser maior que zero)");
						return true;
					}
					if (target == null) {
						sender.sendMessage("§b§lsTempFly §f➠  §cO jogador '" + args[1] + "' não foi encontrado.");
						return true;
					}
					if (execute.equalsIgnoreCase("give")) {
						sender.sendMessage("§b§lsTempFly §f➠  §aVocê ativou o fly para " + target.getName() + " por " + rawtime + " minutos.");
						FlyManager.EnableFly(target, rawtime, time, sender.getName());
						return true;
					}
				} catch(NumberFormatException exception){
					sender.sendMessage("§b§lsTempFly §f➠  §cO tempo inserido não é válido. (O tempo tem que ser maior que zero)");
					return true;
				}

		}
			return true;
		}
		
		return false;
	}

}
