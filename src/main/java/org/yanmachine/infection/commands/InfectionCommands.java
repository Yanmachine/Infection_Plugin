package org.yanmachine.infection.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.yanmachine.infection.infectionGameUtility.InfectedGameLoop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InfectionCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        Bukkit.getLogger().info("command read");

        if (args.length == 1 && args[0].equalsIgnoreCase("start")){

            if (sender instanceof Player player) {
                Scoreboard scoreboard = player.getScoreboard();

                Team infectedTeam = scoreboard.getTeam("Infected");
                Team uninfectedTeam = scoreboard.getTeam("Uninfected");

                if (infectedTeam == null || uninfectedTeam == null) {
                    player.sendMessage("Teams not properly set up.");
                    return false;
                }

                List<Player> onlinePlayers = new ArrayList<>(Bukkit.getOnlinePlayers());

                if (onlinePlayers.size() < 2){
                    player.sendMessage("This game requires at least 2 players to start");
                    return false;
                }

                int randomIndex = new Random().nextInt(onlinePlayers.size());

                for (int i = 0; i < onlinePlayers.size(); i++) {
                    Player p = onlinePlayers.get(i);
                    if (i == randomIndex) {
                        infectedTeam.addPlayer(p);
                        p.sendMessage("You are " + ChatColor.RED + "Infected!");
                    } else {
                        uninfectedTeam.addPlayer(p);
                        p.sendMessage("You are " + ChatColor.GREEN + "Uninfected!");
                    }
                }

                player.sendMessage(ChatColor.GOLD + "Infection game started!");
            }
            return true;
        }
        else if (args.length == 1 && args[0].equalsIgnoreCase("end") ||
                args[0].equalsIgnoreCase("stop") ) {
            InfectedGameLoop game = new InfectedGameLoop();
            game.endGame();
            return true;
        }
        return true;
    }

}
