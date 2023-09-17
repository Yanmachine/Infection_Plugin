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
import org.yanmachine.infection.infectionGameUtility.InfectedGlow;
import org.yanmachine.infection.infectionGameUtility.InfectedPlayerCheck;

public class InfectedHitListener implements Listener {

    @EventHandler
    public void onPlayerHit(EntityDamageByEntityEvent event) {

        if (event.getEntity() instanceof Player) {
            Player damagedPlayer = (Player) event.getEntity();

            if (!InfectedPlayerCheck.isPlayerUninfected(damagedPlayer)){
                return;
            }


            if (event.getDamager() instanceof Player) {
                Player attacker = (Player) event.getDamager();

                if (InfectedPlayerCheck.isPlayerInfected(attacker)) {
                    Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
                    Team infectedTeam = scoreboard.getTeam("Infected");


                    changePlayerTeam(damagedPlayer, infectedTeam);

                    InfectedGameLoop gameCheck = new InfectedGameLoop();
                    gameCheck.run();


                }
            }
        }
    }

    private void changePlayerTeam(Player player, Team team){
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team currentTeam = scoreboard.getPlayerTeam(player);
        if (currentTeam != null) {
            currentTeam.removeEntry(player.getName());
        }

        team.addEntry(player.getName());
        InfectedGlow.applyGlowingEffect(player);


        Bukkit.broadcastMessage(player.getName() +
                " was infected");


    }

}
