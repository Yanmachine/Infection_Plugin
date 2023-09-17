package org.yanmachine.infection.infectionGameUtility;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class InfectedGameLoop extends BukkitRunnable {

    @Override
    public void run() {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team uninfectedTeam = scoreboard.getTeam("Uninfected");

        if (uninfectedTeam != null && uninfectedTeam.getPlayers().isEmpty()) {
            // Execute game-ending logic
            endGame();
        }
    }

    public void endGame() {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team infectedTeam = scoreboard.getTeam("Infected");
        Team uninfectedTeam = scoreboard.getTeam("Uninfected");
        for (OfflinePlayer player : infectedTeam.getPlayers()) {
            infectedTeam.removePlayer(player);
            InfectedGlow.removeGlowingEffect((Player) player);
        }

        for (OfflinePlayer player : uninfectedTeam.getPlayers()){
            uninfectedTeam.removePlayer(player);
        }

        Bukkit.broadcastMessage(ChatColor.GOLD + "The game has ended");
    }
}
