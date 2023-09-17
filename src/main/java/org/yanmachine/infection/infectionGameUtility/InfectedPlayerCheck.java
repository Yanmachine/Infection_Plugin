package org.yanmachine.infection.infectionGameUtility;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class InfectedPlayerCheck {

    public static boolean isPlayerInfected(Player player) {
        Scoreboard scoreboard = player.getScoreboard();
        Team infectedTeam = scoreboard.getTeam("Infected");

        if (infectedTeam != null) {
            return infectedTeam.getPlayers().contains(player);
        }

        return false;
    }

    public static boolean isPlayerUninfected(Player player) {
        Scoreboard scoreboard = player.getScoreboard();
        Team uninfectedTeam = scoreboard.getTeam("Uninfected");

        if (uninfectedTeam != null) {
            return uninfectedTeam.getPlayers().contains(player);
        }

        return false;
    }
}
