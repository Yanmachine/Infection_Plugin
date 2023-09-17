package org.yanmachine.infection.infectionGameUtility;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ChangePlayerTeam {
    public static void makePlayerInfected(Player player){
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team team = scoreboard.getTeam("Infected");
        Team currentTeam = scoreboard.getPlayerTeam(player);
        if (currentTeam != null) {
            currentTeam.removeEntry(player.getName());
        }

        team.addEntry(player.getName());
        InfectedGlow.applyGlowingEffect(player);

        long elapsedTime = TimeRecorder.getElapsedTimeSeconds();
        Bukkit.broadcastMessage(player.getName() +
                " was " + ChatColor.RED + "infected" + ChatColor.WHITE + " after "
                + elapsedTime + " seconds");


    }
}
