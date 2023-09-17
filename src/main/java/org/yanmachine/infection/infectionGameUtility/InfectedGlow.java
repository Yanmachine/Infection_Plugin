package org.yanmachine.infection.infectionGameUtility;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class InfectedGlow {

    public static void applyGlowingEffect(Player player) {
        // Apply the glowing effect
        PotionEffect glowingEffect = new PotionEffect(
                PotionEffectType.GLOWING,
                Integer.MAX_VALUE, // Infinite time
                0, //amplifier
                false, // ambient effect
                false // particles
        );
        player.addPotionEffect(glowingEffect);


    }

    public static void removeGlowingEffect(Player player) {
        player.removePotionEffect(PotionEffectType.GLOWING);
    }

}

/**
 * // Set player to "Infected" team if not already
 *         Scoreboard scoreboard = player.getScoreboard();
 *         Team infectedTeam = scoreboard.getTeam("Infected");
 *         if (infectedTeam != null) {
 *             infectedTeam.addPlayer(player);
 *         }
 */