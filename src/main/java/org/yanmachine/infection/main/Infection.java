package org.yanmachine.infection.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.yanmachine.infection.commands.InfectionCommands;
import org.yanmachine.infection.infectionGameUtility.InfectionTeams;
import org.yanmachine.infection.listeners.InfectedHitListener;

public final class Infection extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("--- Server Initiated ---");

        //checks for player getting punched
        getServer().getPluginManager().registerEvents(new InfectedHitListener(), this);

        getCommand("infection").setExecutor(new InfectionCommands());

        InfectionTeams.setUp();

    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("--- Server Terminated ---");
    }
}
