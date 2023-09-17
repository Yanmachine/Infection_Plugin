package org.yanmachine.infection.infectionGameUtility;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class InfectionTeams {
    /**
     * Initializes 2 basic teams for the game
     */
    public static void setUp() {
        createTeam("Infected", "RED", ChatColor.RED + "Infected");
        createTeam("Uninfected", "GREEN", ChatColor.GREEN + "Uninfected");
    }

    /**
     * Used to create teams
     * Note: If new games added, this class should be separate from infectionTeams
     * @param teamName name of team/ how to access it
     * @param colour colour of display in game
     * @param displayName display name in game
     */
    public static void createTeam(String teamName, String colour, String displayName) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();

        //This checks for duplicate teams, even though as of now there will only ever be 2 teams
        if (!scoreboard.getTeams().contains(scoreboard.getTeam(teamName))){
            Team newTeam = scoreboard.registerNewTeam(teamName);
            if (colour.equalsIgnoreCase("RED")) {
                newTeam.setColor(ChatColor.RED);
            }
            else{
                newTeam.setColor(ChatColor.GREEN);
            }
            newTeam.setDisplayName(displayName);

        }
    }

}
