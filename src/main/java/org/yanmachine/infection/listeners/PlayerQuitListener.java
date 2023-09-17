package org.yanmachine.infection.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.yanmachine.infection.infectionGameUtility.ChangePlayerTeam;
import org.yanmachine.infection.infectionGameUtility.InfectedGameLoop;
import org.yanmachine.infection.infectionGameUtility.InfectedPlayerCheck;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Bukkit.getLogger().info("player quit registered");
        Player player = event.getPlayer();
        if (InfectedPlayerCheck.isPlayerUninfected(player)) {
            ChangePlayerTeam.makePlayerInfected(player);
            InfectedGameLoop gameCheck = new InfectedGameLoop();
            gameCheck.run();
        }
    }
}
