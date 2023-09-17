package org.yanmachine.infection.listeners;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.yanmachine.infection.infectionGameUtility.InfectedGameLoop;
import org.yanmachine.infection.infectionGameUtility.InfectedPlayerCheck;

public class InfectedHitListener implements Listener {

    @EventHandler
    public void onPlayerHit(EntityDamageByEntityEvent event) {

        Bukkit.getLogger().info("Hit Registered");

        if (event.getEntity() instanceof Player) {
            Bukkit.getLogger().info("Player is attacked");
            Player damagedPlayer = (Player) event.getEntity();

            if (!InfectedPlayerCheck.isPlayerUninfected(damagedPlayer)){
                Bukkit.getLogger().info("damaged player is infected");
                return;
            }

            Bukkit.getLogger().info("Attacked player is uninfected");

            if (event.getDamager() instanceof Player) {
                Player attacker = (Player) event.getDamager();
                Bukkit.getLogger().info("Attacker is damager");

                if (InfectedPlayerCheck.isPlayerInfected(attacker)) {
                    Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
                    Team infectedTeam = scoreboard.getTeam("Infected");


                    Team currentTeam = scoreboard.getPlayerTeam(attacker);
                    if (currentTeam != null) {
                        currentTeam.removeEntry(damagedPlayer.getName());
                    }

                    infectedTeam.addEntry(damagedPlayer.getName());


                    Bukkit.broadcastMessage(damagedPlayer.getName() +
                            " was infected");

                    InfectedGameLoop gameCheck = new InfectedGameLoop();
                    gameCheck.run();


                }
            }
        }
    }

}
